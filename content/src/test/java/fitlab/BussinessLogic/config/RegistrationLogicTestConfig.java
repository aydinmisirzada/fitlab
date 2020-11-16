package fitlab.BussinessLogic.config;

import fitlab.BussinessLogic.Logic.RegistrationLogic;
import fitlab.Data.Repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class RegistrationLogicTestConfig {

    @Bean
    public RegistrationLogic registrationLogic(){
        return new RegistrationLogic();
    }

    @Bean
    public UserRepository userRepository(){
        return mock(UserRepository.class);
    }
}
