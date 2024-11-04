package src.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.constant.StatusConstant;
import src.entity.*;
import src.exception.LessonException.NoLessonInCourseException;
import src.repository.UserCourseLessonRepository;

@Service
public class UserCourseLessonValidateService {

    public final UserCourseLessonRepository userCourseLessonRepository;

    @Autowired
    public UserCourseLessonValidateService(UserCourseLessonRepository userCourseLessonRepository) {
        this.userCourseLessonRepository = userCourseLessonRepository;
    }

    public UserCourseLesson validateRecordExist(UserCourse uc, Lesson lesson) {
        return userCourseLessonRepository.getStudentCourseLesson(uc, lesson)
                .orElseThrow(() -> new NoLessonInCourseException(
                        "Record with user id: " + uc.getUser().getId() +
                        " and course id: " + uc.getCourse().getId() +
                        " and lesson id: " + lesson.getId() +
                        " does not exist!"));

    }

    public boolean checkIfCompleteAllLesson(UserCourse uc) {

        return userCourseLessonRepository.getListStudentCourseLesson(uc).stream()
                .allMatch(ucl -> StatusConstant.DONE.getValue().equals(ucl.getStatus()));
    }


}
