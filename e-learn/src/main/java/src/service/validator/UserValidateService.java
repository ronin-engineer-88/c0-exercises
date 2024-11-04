package src.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.constant.ConfigConstant;
import src.entity.User;
import src.exception.UserException.UserInactiveException;
import src.exception.UserException.UserNotFoundException;
import src.exception.UserException.UsernameExistException;
import src.repository.UserRepository;


@Service
public class UserValidateService {

    private final UserRepository userRepository;

    @Autowired
    public UserValidateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void checkRegisterUsername(String username) {
        if (userRepository.findUserByUsername(username).isPresent()) {
            throw new UsernameExistException("Username has already existed!");
        }
    }

    public User validateLoginUsername(String username) {
        return userRepository.findActiveUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Incorrect username!"));
    }

    public User validateUserExist(Long userId) {
        return userRepository.getStudentById(userId)
                .orElseThrow(() -> new UserNotFoundException("Not found student with id: " + userId));
    }

    public void checkActiveUser(User user) {
        if(user.getStatus().equals(ConfigConstant.INACTIVE.getValue()))
            throw new UserInactiveException("User is now unavailable!");

    }

}
