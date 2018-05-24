package name.legkodymov.poc.sugar.monitor.repository;

import name.legkodymov.poc.sugar.monitor.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sergei on 25/04/2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);
}
