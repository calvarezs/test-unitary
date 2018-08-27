package mingeso.UnitTests;

import cl.novuscreate.backend.Application;
import cl.novuscreate.backend.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.TestCase.assertEquals;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class UserTest {

    @Test
    public void userEmailMustExists() {
        User user = new User();

        user.setUserPassword("userTester1");
        user.setUserType(1);

        assertEquals("The User instance is invalid",false,user.verificateUser());
    }

    @Test
    public void userTypeMustExists() {
        User user = new User();

        user.setUserPassword("userTester2");
        user.setUserEmail("email@mail.some"); 
    	user.setUserPassword("verySecretPassword");  

        assertEquals("The User instance is invalid",false,user.verificateUser());
    }

    @Test
    public void  correctVerificationUser() {
        User user = new User();

        user.setUserPassword("userTester3");
        user.setUserEmail("email@mail.some"); 
    	user.setUserPassword("verySecretPassword"); 
 		user.setUserType(1);

        assertEquals("The User instance is invalid",true,user.verificateUser());

    } 
}
