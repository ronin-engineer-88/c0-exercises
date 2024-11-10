package src.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.constant.StatusConstant;
import src.dto.request.admin.AdminLoginReq;
import src.dto.response.admin.*;
import src.entity.*;
import src.exception.AppException;
import src.repository.*;
import src.service.IAdminService;
import src.utils.*;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements IAdminService {
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final ChapterRepository chapterRepository;
    private final LessonRepository lessonRepository;
    private final TeacherRepository teacherRepository;
    private final UserCourseRepository userCourseRepository;
    private final UserCourseLessonRepository userCourseLessonRepository;

    @Autowired
    public AdminServiceImpl(
            AdminRepository adminRepository,
            UserRepository userRepository,
            CourseRepository courseRepository,
            ChapterRepository chapterRepository,
            LessonRepository lessonRepository,
            TeacherRepository teacherRepository,
            UserCourseRepository userCourseRepository,
            UserCourseLessonRepository userCourseLessonRepository
    ) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.chapterRepository = chapterRepository;
        this.lessonRepository = lessonRepository;
        this.teacherRepository = teacherRepository;
        this.userCourseRepository = userCourseRepository;
        this.userCourseLessonRepository = userCourseLessonRepository;
    }


    @Override
    public AdminResponseDto login(AdminLoginReq req) {
        // Validate admin
        Admin admin = adminRepository.findActiveAdminByUsername(req.getUsername());
        if(Objects.isNull(admin))
            throw new AppException("Incorrect username!");
        // Validate password
        if(!admin.getPassword().equals(req.getPassword()))
            throw new AppException("Incorrect password!");

        return convertToAdminResponseDto(admin);
    }

    @Override
    public UserResponseDto getUserInfo(Long userId) {
        // Validate user
        User user = userRepository.getUserById(userId);
        if(Objects.isNull(user))
            throw new AppException("Not found student with id: " + userId);

        return convertToUserResponseDto(user);
    }

    public UserCourseInfoRes getUserCourseInfo(Long userId, Long courseId) {
        // Validate user
        User user = userRepository.getUserById(userId);
        if(Objects.isNull(user))
            throw new AppException("Not found student with id: " + userId);
        // Validate course
        Course course = courseRepository.getCourseById(courseId);
        if(Objects.isNull(course))
            throw new AppException("Not found course with id: " + courseId);
        // Validate if user has enrolled course
        UserCourse uc = userCourseRepository.getUserCourse(user, course);
        if(Objects.isNull(uc))
            throw new AppException("User with id: " + user.getId() +
                    " has not enrolled course with id: " + course.getId() + " yet!");
        //
        List<UserCourseLesson> userCourseLessonList = userCourseLessonRepository.getListUserCourseLesson(uc);
        //
        UserCourseInfoRes res = new UserCourseInfoRes();
        res.setUser(convertToUserResponseDto(user));
        res.setCourse(convertToCourseResponseDto(course));
        res.setRate(
                uc.getRating() != null ? uc.getRating() : null
        );
        res.setReview(
                uc.getReview() != null ? uc.getReview() : null
        );
        res.setCreatedDate(DateUtils.formatDateTime(uc.getCreatedDate()));
        res.setUpdatedDate(
                uc.getUpdatedDate() != null ? DateUtils.formatDateTime(uc.getUpdatedDate()) : null
        );
        res.setNumLessonProcessing((int) userCourseLessonList.stream()
                .filter(scl -> StatusConstant.PROCESSING.getValue().equals(scl.getStatus()))
                .count());
        res.setNumLessonDone((int) userCourseLessonList.stream()
                .filter(scl -> StatusConstant.DONE.getValue().equals(scl.getStatus()))
                .count());

        return res;
    }

    @Override
    public UserCourseLessonInfoRes getUserCourseLessonInfo(Long userId, Long courseId, Long lessonId) {
        // Validate user
        User user = userRepository.getUserById(userId);
        if(Objects.isNull(user))
            throw new AppException("Not found student with id: " + userId);
        // Validate course
        Course course = courseRepository.getCourseById(courseId);
        if(Objects.isNull(course))
            throw new AppException("Not found course with id: " + courseId);
        // Validate if user has enrolled course
        UserCourse uc = userCourseRepository.getUserCourse(user, course);
        if(Objects.isNull(uc))
            throw new AppException("User with id: " + user.getId() +
                    " has not enrolled course with id: " + course.getId() + " yet!");
        // Validate lesson
        Lesson lesson = lessonRepository.getLessonById(lessonId);
        if(Objects.isNull(lesson))
            throw new AppException("Not found lesson with id: " + lessonId);
        // Validate if course has corresponding lesson
        boolean lessonExistsInCourse = course.getChapters().stream()
                .anyMatch(chapter -> chapter.getLessons().contains(lesson));

        if (!lessonExistsInCourse) {
            throw new AppException(
                    "Course with id: " + course.getId() +
                            " does not have lesson with id: " + lesson.getId());
        }
        //
        UserCourseLesson ucl = userCourseLessonRepository.getUserCourseLesson(uc, lesson);
        if(Objects.isNull(ucl))
            throw new AppException(
                    "Record with user id: " + uc.getUser().getId() +
                            " and course id: " + uc.getCourse().getId() +
                            " and lesson id: " + lesson.getId() +
                            " does not exist!");
        //
        UserCourseLessonInfoRes res = new UserCourseLessonInfoRes();
        res.setUser(convertToUserResponseDto(user));
        res.setCourse(convertToCourseResponseDto(course));
        res.setLesson(convertToLessonResponseDto(lesson));
        res.setStatus(ucl.getStatus());
        res.setCreatedDate(DateUtils.formatDateTime(ucl.getCreatedDate()));
        res.setUpdatedDate(
                ucl.getUpdatedDate() != null ? DateUtils.formatDateTime(ucl.getUpdatedDate()) : null
        );

        return res;
    }

    @Override
    public TeacherInfoRes getTeacherInfo(Long teacherId) {
        // Validate teacher
        Teacher teacher = teacherRepository.getTeacherById(teacherId);
        if(Objects.isNull(teacher))
            throw new AppException("Not found teacher with id: " + teacherId);
        //
        TeacherInfoRes res = new TeacherInfoRes();
        res.setTeacher(convertToTeacherResponseDto(teacher));
        res.setNumCourseTeach(teacher.getCourses().size());

        return res;
    }

    @Override
    public CourseInfoRes getCourseInfo(Long courseId) {
        // Validate course
        Course course = courseRepository.getCourseById(courseId);
        if(Objects.isNull(course))
            throw new AppException("Not found course with id: " + courseId);
        //
        CourseInfoRes res = new CourseInfoRes();
        res.setCourse(convertToCourseResponseDto(course));
        res.setNumChapter(course.getChapters().size());
        res.setNumLesson(course.getChapters().stream()
                .mapToInt(ch -> ch.getLessons().size())
                .sum());
        res.setNumRegisterUser(course.getUserCourses().size());

        return res;
    }

    @Override
    public ChapterInfoRes getChapterInfo(Long chapterId) {
        // Validate chapter
        Chapter chapter = chapterRepository.getChapterById(chapterId);
        if(Objects.isNull(chapter))
            throw new AppException("Not found chapter with id: " + chapterId);
        //
        ChapterInfoRes res = new ChapterInfoRes();
        res.setChapter(convertToChapterResponseDto(chapter));
        res.setCourse(convertToCourseResponseDto(chapter.getCourse()));
        res.setNumLesson(chapter.getLessons().size());

        return res;
    }

    @Override
    public LessonInfoRes getLessonInfo(Long lessonId) {
        // Validate lesson
        Lesson lesson = lessonRepository.getLessonById(lessonId);
        if(Objects.isNull(lesson))
            throw new AppException("Not found lesson with id: " + lessonId);
        //
        LessonInfoRes res = new LessonInfoRes();
        res.setCourse(convertToCourseResponseDto(lesson.getChapter().getCourse()));
        res.setChapter(convertToChapterResponseDto(lesson.getChapter()));
        res.setLesson(convertToLessonResponseDto(lesson));
        res.setNumUserProcessing((int) lesson.getUserCourseLessons().stream()
                .filter(scl -> StatusConstant.PROCESSING.getValue().equals(scl.getStatus()))
                .count()
        );
        res.setNumUserDone((int) lesson.getUserCourseLessons().stream()
                .filter(scl -> StatusConstant.DONE.getValue().equals(scl.getStatus()))
                .count()
        );

        return res;
    }

    @Override
    public void deleteByStatus(String value) {
        adminRepository.deleteByStatus(value);
    }

    private AdminResponseDto convertToAdminResponseDto(Admin admin) {

        AdminResponseDto adminResponseDto = new AdminResponseDto();
        BeanUtils.copyProperties(admin, adminResponseDto);
        adminResponseDto.setCreatedDate(DateUtils.formatDateTime(admin.getCreatedDate()));
        adminResponseDto.setUpdatedDate(
                admin.getUpdatedDate() != null ? DateUtils.formatDateTime(admin.getUpdatedDate()) : null
        );

        return adminResponseDto;

    }

    private UserResponseDto convertToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(user, userResponseDto);
        userResponseDto.setFullName(convertToFullNameResponseDto(user.getFullName()));
        userResponseDto.setAddresses(
                user.getAddress().stream()
                        .map(this::convertToAddressResponseDto)
                        .toList()
        );
        userResponseDto.setCreatedDate(DateUtils.formatDateTime(user.getCreatedDate()));
        userResponseDto.setUpdatedDate(
                user.getUpdatedDate() != null ? DateUtils.formatDateTime(user.getUpdatedDate()) : null
        );
        userResponseDto.setNumCourseRegister(user.getUserCourses().size());

        return userResponseDto;
    }

    private TeacherResDto convertToTeacherResponseDto(Teacher teacher) {

        TeacherResDto teacherResDto = new TeacherResDto();
        BeanUtils.copyProperties(teacher, teacherResDto);
        teacherResDto.setCreatedDate(DateUtils.formatDateTime(teacher.getCreatedDate()));
        teacherResDto.setUpdatedDate(
                teacher.getUpdatedDate() != null ? DateUtils.formatDateTime(teacher.getUpdatedDate()) : null
        );

        return teacherResDto;
    }

    private FullNameResponseDto convertToFullNameResponseDto(FullName fullName) {
        FullNameResponseDto fullNameResponseDto = new FullNameResponseDto();
        fullNameResponseDto.setFullName(
                fullName.getLastName() + " " +
                        fullName.getMidName() + " " +
                        fullName.getFirstName());

        return fullNameResponseDto;
    }

    private AddressResponseDto convertToAddressResponseDto(Address address) {

        AddressResponseDto addressResponseDto = new AddressResponseDto();
        addressResponseDto.setAddress(
                address.getAddressDetail() + ", " +
                        address.getStreet() + ", " +
                        address.getDistrict() + ", " +
                        address.getCity() + ", " +
                        address.getCountry()
        );

        return addressResponseDto;
    }

    private CourseResponseDto convertToCourseResponseDto(Course course) {
        CourseResponseDto courseResponseDto = new CourseResponseDto();
        BeanUtils.copyProperties(course, courseResponseDto);
        courseResponseDto.setCreatedDate(DateUtils.formatDateTime(course.getCreatedDate()));
        courseResponseDto.setUpdatedDate(
                course.getUpdatedDate() != null ? DateUtils.formatDateTime(course.getUpdatedDate()) : null
        );

        return courseResponseDto;
    }

    private ChapterResponseDto convertToChapterResponseDto(Chapter chapter) {

        ChapterResponseDto chapterResponseDto = new ChapterResponseDto();
        BeanUtils.copyProperties(chapter, chapterResponseDto);
        chapterResponseDto.setCreatedDate(DateUtils.formatDateTime(chapter.getCreatedDate()));
        chapterResponseDto.setUpdatedDate(
                chapter.getUpdatedDate() != null ? DateUtils.formatDateTime(chapter.getUpdatedDate()) : null
        );

        return chapterResponseDto;
    }

    private LessonResDto convertToLessonResponseDto(Lesson lesson) {
        LessonResDto lessonResponseDto = new LessonResDto();
        BeanUtils.copyProperties(lesson, lessonResponseDto);
        lessonResponseDto.setCreatedDate(DateUtils.formatDateTime(lesson.getCreatedDate()));
        lessonResponseDto.setUpdatedDate(
                lesson.getUpdatedDate() != null ? DateUtils.formatDateTime(lesson.getUpdatedDate()) : null
        );

        return lessonResponseDto;
    }
}