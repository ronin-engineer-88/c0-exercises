package src.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import src.service.IUserService;
import src.service.impl.UserServiceImpl;


@Configuration
public class BeanConfig {

    @Bean
    public IUserService userService() {
        return new UserServiceImpl();
    }
}
