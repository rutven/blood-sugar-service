package name.legkodymov.poc.sugar.monitor;

import name.legkodymov.poc.sugar.monitor.controller.MonitorController;
import name.legkodymov.poc.sugar.monitor.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestServiceTest {

    private static final String HOST = "http://localhost:8080";
    private static final String USER_ENDPOINT = HOST + MonitorController.USERS_PATH;
    private static final String FIRST_NAME = "Ivan";
    private static final String LAST_NAME = "Petrov";
    private static final int AGE = 25;
    private static final String EMAIL = "ivan.petrov@mail.com";
    private static final String PASSWORD = "qwerty";

    @Autowired
    private TestRestTemplate template;

    @Test
    public void whenSaveUser_thenCorrect() {

        User user = new User();

        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setAge(AGE);
        user.setEmail(EMAIL);
        user.setPassword(PASSWORD);

        template.postForEntity(USER_ENDPOINT, user, User.class);

        /*
        ResponseEntity<User> userResponseEntity = template.getForEntity(USER_ENDPOINT + "/1", User.class);

        System.out.println("response = " + userResponseEntity.getBody().toString());

        assertEquals("First name is incorrect", userResponseEntity.getBody().getFirstName(), FIRST_NAME);
        assertEquals("Last name is incorrect", userResponseEntity.getBody().getLastName(), LAST_NAME);
        assertEquals("Age is incorrect", userResponseEntity.getBody().getAge().longValue(), AGE);
        assertEquals("Email is incorrect", userResponseEntity.getBody().getEmail(), EMAIL);
        assertEquals("Password is incorrect", userResponseEntity.getBody().getPassword(), PASSWORD);
        */
    }
}
