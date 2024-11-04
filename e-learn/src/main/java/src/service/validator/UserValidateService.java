package src.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.entity.User;
import src.exception.UserException.UserNotFoundException;
import src.repository.UserRepository;

@Service
public class UserValidateService {

    private final UserRepository userRepository;

    @Autowired
    public UserValidateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User validateUserExist(Long userId) {
        return userRepository.getStudentById(userId)
                .orElseThrow(() -> new UserNotFoundException("Not found student with id: " + userId));
    }

}
