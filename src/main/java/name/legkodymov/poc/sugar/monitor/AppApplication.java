package name.legkodymov.poc.sugar.monitor;

import name.legkodymov.poc.sugar.monitor.entity.User;
import name.legkodymov.poc.sugar.monitor.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication {

    private static final Logger log = LoggerFactory.getLogger(AppApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            //save some users
            repository.save(new User("Jack", "Bauer"));
            repository.save(new User("Chloe", "Smith"));
            repository.save(new User("Jennifer", "Palmer"));
            repository.save(new User("David", "Smith"));

            //fetch all
            log.info("Users found by findAll");
            log.info("------------------------------");
            for (User user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            //fetch user by Id
            log.info("Users found by findOne");
            log.info("------------------------------");
            User user1 = repository.findOne(1L);
            log.info(user1.toString());
            log.info("");

            //fetch by lastName
            log.info("Users found by findByLastName");
            log.info("------------------------------");
            for (User user : repository.findByLastName("Smith")) {
                log.info(user.toString());
            }
            log.info("");

        };
    }
}
