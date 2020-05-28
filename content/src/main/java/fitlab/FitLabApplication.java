package fitlab;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.builder.SpringApplicationBuilder;
        import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

        import javax.swing.*;

@SpringBootApplication
public class FitLabApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(FitLabApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FitLabApplication.class);
    }
}
