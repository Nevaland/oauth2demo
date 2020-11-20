package nevaland.oauth2demo.config;

import nevaland.oauth2demo.repository.MemoryUserRepository;
import nevaland.oauth2demo.repository.UserRepository;
import nevaland.oauth2demo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public UserService UserService() {
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new MemoryUserRepository();
    }
}
