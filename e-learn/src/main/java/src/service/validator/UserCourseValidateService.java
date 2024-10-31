package src.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.entity.Course;
import src.entity.Student;
import src.entity.StudentCourse;
import src.exception.UserException.UserAlreadyEnrolledException;
import src.exception.UserException.UserNotYetEnrolledException;
import src.repository.UserCourseRepository;

import java.util.Objects;

@Service
public class UserCourseValidateService {

    private final UserCourseRepository userCourseRepository;

    @Autowired
    public UserCourseValidateService(UserCourseRepository userCourseRepository) {
        this.userCourseRepository = userCourseRepository;
    }

    public void checkIfUserAlreadyEnrolledCourse(Student user, Course course) {

        if(Objects.nonNull(userCourseRepository.getStudentCourseById(user, course)))
            throw new UserAlreadyEnrolledException("User with id: " + user.getId() +
                    " is already enrolled in course with id: " + course.getId());

    }
    
    public StudentCourse validateUserEnrolledCourse(Student user, Course course) {

        StudentCourse sc = userCourseRepository.getStudentCourseById(user, course);
        if(Objects.isNull(sc))
            throw new UserNotYetEnrolledException("User with id: " + user.getId() +
                    " has not enrolled course with id: " + course.getId() + " yet!");

        return sc;
    }

}
