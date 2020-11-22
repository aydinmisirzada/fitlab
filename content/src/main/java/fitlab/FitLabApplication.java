package fitlab;

import fitlab.BussinessLogic.Logic.RegistrationLogic;
import fitlab.Data.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FitLabApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(FitLabApplication.class, args);
    }
    /*@Autowired
    UserRepository user;*/
    @Autowired
    RegistrationLogic registrationLogic;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FitLabApplication.class);
    }

    @Bean
    public void createAdmin(){
        User u = new User();

        u.setEmail("some@m");
        u.setUsername("root");
        u.setName("root");
        u.setSurname("root");
        u.setPhone("1");
        u.setPassword("root");
        registrationLogic.addAdmin(u);
    }
    /*@Bean
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
    }*/
}
