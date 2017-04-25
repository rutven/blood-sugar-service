package name.legkodymov.poc.sugar.monitor;

import name.legkodymov.poc.sugar.monitor.entity.Customer;
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
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            //save some customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "Smith"));
            repository.save(new Customer("Jennifer", "Palmer"));
            repository.save(new Customer("David", "Smith"));

            //fetch all
            log.info("Customers found by findAll");
            log.info("------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            //fetch customer by Id
            log.info("Customers found by findOne");
            log.info("------------------------------");
            Customer customer1 = repository.findOne(1L);
            log.info(customer1.toString());
            log.info("");

            //fetch by lastName
            log.info("Customers found by findByLastName");
            log.info("------------------------------");
            for (Customer customer : repository.findByLastName("Smith")) {
                log.info(customer.toString());
            }
            log.info("");

        };
    }
}
