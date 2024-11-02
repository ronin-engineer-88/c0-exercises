package src.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.entity.Course;
import src.entity.Student;
import src.entity.StudentCourse;
import src.exception.UserException.UserNotYetEnrolledException;
import src.repository.UserCourseRepository;

@Service
public class UserCourseValidateService {
    private final UserCourseRepository userCourseRepository;

    @Autowired
    public UserCourseValidateService(UserCourseRepository userCourseRepository) {
        this.userCourseRepository = userCourseRepository;
    }

    public StudentCourse validateUserEnrolledCourse(Student user, Course course) {
        return userCourseRepository.getStudentCourseById(user, course)
                .orElseThrow(() -> new UserNotYetEnrolledException("User with id: " + user.getId() +
                        " has not enrolled course with id: " + course.getId() + " yet!"));
    }
}
