package name.legkodymov.poc.sugar.monitor;

import name.legkodymov.poc.sugar.monitor.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sergei on 25/04/2017.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
