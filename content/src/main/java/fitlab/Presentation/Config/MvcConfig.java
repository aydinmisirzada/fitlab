package fitlab.Presentation.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
/**
     * This method is used to control simple pages : login and main
     * @param registry This is needed and provided by the framework
     */

    public void addViewControllers(ViewControllerRegistry registry) {
      //  registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/activation").setViewName("activationPage");
    }

}
