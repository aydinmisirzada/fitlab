package fitlab.Config;

import fitlab.Model.Subject;
import fitlab.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class Config {
    @Autowired
    SubjectRepository repo;

    @Bean
    public CommandLineRunner data() {
        return (args) -> {

        };

    }
}
