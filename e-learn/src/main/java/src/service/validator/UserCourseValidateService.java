package src.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.entity.Course;
import src.entity.User;
import src.entity.UserCourse;
import src.exception.UserException.UserAlreadyEnrolledException;
import src.exception.UserException.UserNotYetEnrolledException;
import src.repository.UserCourseRepository;

@Service
public class UserCourseValidateService {

    private final UserCourseRepository userCourseRepository;

    @Autowired
    public UserCourseValidateService(UserCourseRepository userCourseRepository) {
        this.userCourseRepository = userCourseRepository;
    }

    public void checkIfUserAlreadyEnrolledCourse(User user, Course course) {

        if(userCourseRepository.getUserCourse(user, course).isPresent())
            throw new UserAlreadyEnrolledException("User with id: " + user.getId() +
                    " is already enrolled in course with id: " + course.getId());

    }
    
    public UserCourse validateUserEnrolledCourse(User user, Course course) {
        return userCourseRepository.getUserCourse(user, course)
                .orElseThrow(() -> new UserNotYetEnrolledException("User with id: " + user.getId() +
                        " has not enrolled course with id: " + course.getId() + " yet!"));
    }



}
