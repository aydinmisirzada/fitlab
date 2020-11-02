package fitlab.Presentation.Config;

import fitlab.Data.Model.Role;
import fitlab.Data.Model.User;
import fitlab.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    UserRepository user;
    @Bean
    public CommandLineRunner data() {
        return (args) -> {
            User u  = new User(0,"root","root","root", "some@m","root","1", Role.ADMIN);
            u.setActivationCode("");
            u.setPathId("root");
            user.save(u);

        };
    }
/**
     * This method is used to control simple pages : login and main
     * @param registry This is needed and provided by the framework
     */

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/activation").setViewName("activationPage");
    }

}
