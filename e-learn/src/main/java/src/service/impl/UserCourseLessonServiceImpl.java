package src.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.repository.UserCourseLessonRepository;
import src.service.IUserCourseLessonService;

@Service
public class UserCourseLessonServiceImpl implements IUserCourseLessonService {

    @Autowired
    private UserCourseLessonRepository userCourseLessonRepository;

    @Override
    public void deleteByStatus(String value) {
        userCourseLessonRepository.deleteByStatus(value);
    }
}
