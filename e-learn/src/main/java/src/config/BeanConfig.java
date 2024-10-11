package src.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import src.service.impl.AdminServiceImpl;

@Configuration
public class BeanConfig {

    @Bean
    public AdminServiceImpl adminService() {
        return new AdminServiceImpl();
    }
}
