package src.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import src.constant.ConfigConstant;
import src.constant.StatusConstant;
import src.dto.request.user.*;
import src.dto.response.admin.UserSearchRes;
import src.dto.response.user.*;
import src.dto.response.user.DetailResponse.CourseResponseDto;
import src.dto.response.user.DetailResponse.UserResponseDto;
import src.entity.*;
import src.entity.CompositeKey.*;
import src.repository.*;
import src.service.IUserService;
import src.service.validator.*;
import src.util.CourseUtils;
import src.util.DateUtils;
import src.util.PageableUtils;
import src.util.UserUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(IUserService.class);
    private final UserRepository userRepository;
    private final FullNameRepository fullNameRepository;
    private final AddressRepository addressRepository;
    private final UserCourseRepository userCourseRepository;
    private final UserCourseLessonRepository userCourseLessonRepository;
    private final UserValidateService userValidateService;
    private final CourseValidateService courseValidateService;
    private final LessonValidatorService lessonValidatorService;
    private final UserCourseValidateService userCourseValidateService;
    private final UserCourseLessonValidateService userCourseLessonValidateService;
    private final RequestValidateService requestValidateService;

    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            FullNameRepository fullNameRepository,
            AddressRepository addressRepository,
            UserCourseRepository userCourseRepository,
            UserCourseLessonRepository userCourseLessonRepository,
            UserValidateService userValidateService,
            CourseValidateService courseValidateService,
            LessonValidatorService lessonValidatorService,
            UserCourseValidateService userCourseValidateService,
            UserCourseLessonValidateService userCourseLessonValidateService,
            RequestValidateService requestValidateService

    ) {
        this.userRepository = userRepository;
        this.fullNameRepository = fullNameRepository;
        this.addressRepository = addressRepository;
        this.userCourseRepository = userCourseRepository;
        this.userCourseLessonRepository = userCourseLessonRepository;
        this.userValidateService = userValidateService;
        this.courseValidateService = courseValidateService;
        this.lessonValidatorService = lessonValidatorService;
        this.userCourseValidateService = userCourseValidateService;
        this.userCourseLessonValidateService = userCourseLessonValidateService;
        this.requestValidateService = requestValidateService;
    }


    @Override
    public UserResponseDto register(UserRegisterReq req) {

        userValidateService.checkRegisterUsername(req.getUsername());

        User user = new User();
        BeanUtils.copyProperties(req, user);
        user.setCreatedDate(LocalDateTime.now());
        user.setStatus(ConfigConstant.ACTIVE.getValue());
        User savedUser = userRepository.save(user);

        FullName fullName = new FullName();
        BeanUtils.copyProperties(req, fullName);
        fullName.setCreatedDate(LocalDateTime.now());
        fullName.setStatus(ConfigConstant.ACTIVE.getValue());
        fullName.setUser(savedUser);
        FullName savedFullname = fullNameRepository.save(fullName);

        List<Address> addresses = new ArrayList<>();
        for(AddressRequest addressRequest : req.getAddressCreateRequests()) {
            Address address = new Address();
            BeanUtils.copyProperties(addressRequest, address);
            Address savedAddress = addressRepository.save(address);
            addresses.add(savedAddress);
        }

        savedUser.setAddress(addresses);
        savedUser.setFullName(savedFullname);
        savedUser = userRepository.save(savedUser);

        return UserUtils.convertToResponseDto(savedUser);
    }

    @Override
    public UserResponseDto login(UserLoginReq req) {

        User user = userValidateService.validateLoginUsername(req.getUsername());

        requestValidateService.checkLoginPassword(user, req.getPassword());

        return UserUtils.convertToResponseDto(user);
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserUpdateReq req) {

        User user = userValidateService.validateUserExist(userId);
        requestValidateService.checkConfigStatusRequest(req.getStatus());

        String newStatus = (req.getStatus() == ConfigConstant.INACTIVE.getCode())
                            ? ConfigConstant.INACTIVE.getValue() : ConfigConstant.ACTIVE.getValue();
        if(!newStatus.equals(user.getStatus()))
            user.setStatus(newStatus);

        FullName fullName = user.getFullName();
        BeanUtils.copyProperties(req, fullName);
        fullName.setStatus(newStatus);
        fullName.setUpdatedDate(LocalDateTime.now());
        FullName savedFullname = fullNameRepository.save(fullName);

        for(int i = 0; i < req.getAddressUpdateRequests().size(); i++) {
            BeanUtils.copyProperties(req.getAddressUpdateRequests().get(i), user.getAddress().get(i));
            addressRepository.save(user.getAddress().get(i));
        }

        BeanUtils.copyProperties(req, user);
        user.setFullName(savedFullname);
        user.setUpdatedDate(LocalDateTime.now());
        User updateUser = userRepository.save(user);

        return UserUtils.convertToResponseDto(updateUser);
    }

    @Override
    public void deleteUser(Long userId) {

        User user = userValidateService.validateUserExist(userId);
        userValidateService.checkActiveUser(user);

        user.setStatus(ConfigConstant.INACTIVE.getValue());
        user.getFullName().setStatus(ConfigConstant.INACTIVE.getValue());
        user.setUpdatedDate(LocalDateTime.now());
        user.getFullName().setUpdatedDate(LocalDateTime.now());
        userRepository.save(user);
        fullNameRepository.save(user.getFullName());

        log.info("Soft delete user with id: {}", userId);
    }

    @Override
    public UserSearchRes getUsers(UserSearchReq req) {
        //
        req.setPageIndex(req.getPageIndex() != null && req.getPageIndex() >= 0 ? req.getPageIndex() : 0);
        req.setPageSize(req.getPageSize() != null && req.getPageSize() >= 1 ? req.getPageSize() : 10);
        //
        Sort sort = PageableUtils.determineSort(req.getSort());
        Pageable pageable = PageRequest.of(req.getPageIndex(), req.getPageSize(), sort);
        //
        Page<User> userPage = userRepository.findStudents(
                req.getName(),
                req.getUsername(),
                req.getStatus(),
                req.getCreatedDateFrom(),
                req.getCreatedDateTo(),
                pageable
        );
        //
        List<UserResponseDto> listUserRes = userPage.getContent().stream()
                .map(UserUtils::convertToResponseDto)
                .toList();
        //
        UserSearchRes res = new UserSearchRes();
        res.setUsers(listUserRes);
        res.setTotalItems(userPage.getTotalElements());


        return res;
    }

    @Override
    public UserEnrollCourseRes enrollCourse(Long userId, Long courseId) {

        User user = userValidateService.validateUserExist(userId);
        userValidateService.checkActiveUser(user);
        Course course = courseValidateService.validateCourseExist(courseId);
        courseValidateService.validateActiveCourse(course);
        userCourseValidateService.checkIfUserAlreadyEnrolledCourse(user, course);

        UserCourseId userCourseId = new UserCourseId(userId, courseId);

        UserCourse sc = new UserCourse();
        sc.setUserCourseId(userCourseId);
        sc.setUser(user);
        sc.setCourse(course);
        sc.setCreatedDate(LocalDateTime.now());
        sc.setStatus(StatusConstant.START.getValue());

        UserCourse savedSc = userCourseRepository.save(sc);

        for(Chapter ch : savedSc.getCourse().getChapters()) {
            for(Lesson l : ch.getLessons()) {
                UserCourseLesson scl = new UserCourseLesson();
                UserCourseLessonId id = new UserCourseLessonId(
                        savedSc.getUserCourseId().getUserId(),
                        savedSc.getUserCourseId().getCourseId(),
                        l.getId());

                scl.setId(id);
                scl.setUser(user);
                scl.setCourse(course);
                scl.setLesson(l);
                scl.setStatus(StatusConstant.START.getValue());
                scl.setCreatedDate(LocalDateTime.now());
                userCourseLessonRepository.save(scl);
            }
        }

        UserEnrollCourseRes res = new UserEnrollCourseRes();
        BeanUtils.copyProperties(savedSc, res);
        res.setUserId(userId);
        res.setCourseId(courseId);
        res.setCreatedDate(DateUtils.dateTimeToString(savedSc.getCreatedDate()));

        log.info("User with id: {} has successfully enrolled in course with id: {}", userId, courseId);

        return res;
    }

    @Override
    public UserRateCourseRes rateCourse(Long userId, Long courseId, UserRateCourseReq req) {

        User user = userValidateService.validateUserExist(userId);
        userValidateService.checkActiveUser(user);
        Course course = courseValidateService.validateCourseExist(courseId);
        courseValidateService.validateActiveCourse(course);
        UserCourse uc = userCourseValidateService.validateUserEnrolledCourse(user, course);

        uc.setRating(req.getRate());
        uc.setUpdatedDate(LocalDateTime.now());

        UserCourse savedSc = userCourseRepository.save(uc);

        UserRateCourseRes res = new UserRateCourseRes();
        res.setUserId(userId);
        res.setCourseId(courseId);
        res.setRate(req.getRate());
        res.setUpdatedDate(DateUtils.dateTimeToString(savedSc.getUpdatedDate()));

        log.info("User with id: {} has rated course with id: {}", userId, courseId);

        return res;
    }

    @Override
    public UserReviewCourseRes reviewCourse(Long userId, Long courseId, UserReviewCourseReq req) {

        User user = userValidateService.validateUserExist(userId);
        userValidateService.checkActiveUser(user);
        Course course = courseValidateService.validateCourseExist(courseId);
        courseValidateService.validateActiveCourse(course);
        UserCourse uc = userCourseValidateService.validateUserEnrolledCourse(user, course);

        uc.setReview(req.getReview());
        uc.setUpdatedDate(LocalDateTime.now());

        UserCourse savedSc = userCourseRepository.save(uc);

        UserReviewCourseRes res = new UserReviewCourseRes();
        res.setUserId(userId);
        res.setCourseId(courseId);
        res.setReview(req.getReview());
        res.setUpdatedDate(DateUtils.dateTimeToString(savedSc.getUpdatedDate()));

        log.info("User with id: {} has review course with id: {}", userId, courseId);

        return res;
    }

    @Override
    public CourseResponseDto getCourseInfo(Long courseId) {

        Course course = courseValidateService.validateCourseExist(courseId);

        return CourseUtils.User.convertToResponseDto(course);
    }

    @Override
    public UserSearchCourseRes getRegisterCourse(UserSearchCourseReq req) {
        //
        userValidateService.validateUserExist(req.getUserId());
        //
        req.setPageIndex(req.getPageIndex() != null && req.getPageIndex() >= 0 ? req.getPageIndex() : 0);
        req.setPageSize(req.getPageSize() != null && req.getPageSize() >= 1 ? req.getPageSize() : 10);
        //
        Sort sort = PageableUtils.determineSort(req.getSort());
        Pageable pageable = PageRequest.of(req.getPageIndex(), req.getPageSize(), sort);

        Page<Course> coursePage = userRepository.findRegisterCourses(
                req.getUserId(),
                req.getName(),
                req.getStatus(),
                req.getTeacherName(),
                req.getCreatedDateFrom(),
                req.getCreatedDateFrom(),
                req.getRatingFrom(),
                req.getRatingTo(),
                req.getNumLessons(),
                pageable
        );

        List<Course> courses = coursePage.getContent();
        List<CourseRegisterSearchResponse> listCourseRegisterRes = courses.stream()
                .map(course -> CourseUtils.User.convertToResponseDto(req.getUserId(), course))
                .toList();

        UserSearchCourseRes res = new UserSearchCourseRes();
        res.setRegisterCourses(listCourseRegisterRes);
        res.setTotalItems(coursePage.getTotalElements());

        return res;
    }

    @Override
    public UserStudyRes study(Long userId, Long courseId, Long lessonId, UserStudyReq req) {

        User user = userValidateService.validateUserExist(userId);
        userValidateService.checkActiveUser(user);
        Course course = courseValidateService.validateCourseExist(courseId);
        courseValidateService.validateActiveCourse(course);
        UserCourse uc = userCourseValidateService.validateUserEnrolledCourse(user, course);
        Lesson lesson = lessonValidatorService.validateLessonExist(lessonId);
        lessonValidatorService.validateActiveLesson(lesson);
        courseValidateService.checkIfCourseHasLesson(course, lesson);
        requestValidateService.checkStatusRequest(req.getStatus());

        UserCourseLesson ucl = userCourseLessonValidateService.validateRecordExist(uc, lesson);
        ucl.setStatus(req.getStatus());
        ucl.setUpdatedDate(LocalDateTime.now());

        UserCourseLesson savedUcl = userCourseLessonRepository.save(ucl);

        if (userCourseLessonValidateService.checkIfCompleteAllLesson(savedUcl.getUserCourse())) {
            savedUcl.getUserCourse().setStatus(StatusConstant.DONE.getValue());
            userCourseRepository.save(ucl.getUserCourse());
        }
            UserStudyRes res = new UserStudyRes();
            res.setUserId(userId);
            res.setCourseId(courseId);
            res.setLessonId(lessonId);
            res.setStatus(req.getStatus());
            res.setUpdatedDate(DateUtils.dateTimeToString(savedUcl.getUpdatedDate()));

            return res;
        }
}
