package src.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.repository.UserCourseRepository;
import src.service.IUserCourseService;

@Service
public class UserCourseServiceImpl implements IUserCourseService {

    @Autowired
    private UserCourseRepository userCourseRepository;

    @Override
    public void deleteByStatus(String value) {
        userCourseRepository.deleteByStatus(value);
    }
}
