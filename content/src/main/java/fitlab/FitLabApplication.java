package fitlab;

import fitlab.BussinessLogic.Logic.RegistrationLogic;
import fitlab.Data.Model.Role;
import fitlab.Data.Model.User;
import fitlab.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class FitLabApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(FitLabApplication.class, args);
    }
    @Autowired
    UserRepository user;
    @Autowired
    RegistrationLogic registrationLogic;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FitLabApplication.class);
    }

    @Bean
    public CommandLineRunner data() {
        return (args) -> {
            User u = new User();

            u.setEmail("some@m");
            u.setUsername("root");
            u.setName("root");
            u.setSurname("root");
            u.setPhone("1");
            u.setPassword("root");
            registrationLogic.addAdmin(u);

        };
    }
}
