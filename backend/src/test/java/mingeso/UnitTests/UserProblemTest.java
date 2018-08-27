package mingeso.UnitTests;

import cl.novuscreate.backend.Application; 
import cl.novuscreate.backend.entity.User;
import cl.novuscreate.backend.entity.Problem; 
import cl.novuscreate.backend.entity.UserProblem; 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class UserProblemTest {    

    @Test
    public void testGetUserProblemId() {
        User user = new User();
        Problem problem = new Problem(); 
        UserProblem userProblem = new UserProblem(user, problem, 0);
 
        userProblem.setUserProblemId(1000);

        assertTrue(userProblem.getUserProblemId() == 1000);  
    } 

    @Test
    public void testSetUserProblemId() {
        User user = new User();
        Problem problem = new Problem(); 
        UserProblem userProblem = new UserProblem(user, problem, 0);
 
        userProblem.setUserProblemId(1000);

        assertTrue(userProblem.getUserProblemId() == 1000);    
    } 

    @Test
    public void testGetUser() {
        User user = new User();
        Problem problem = new Problem(); 
        UserProblem userProblem = new UserProblem(user, problem, 0);

        assertTrue(userProblem.getUser() == user);  
    } 

    @Test
    public void testSetUser() {
        User user = new User();
        Problem problem = new Problem(); 
        UserProblem userProblem = new UserProblem(user, problem, 0);
 
        userProblem.setUser(user);

        assertTrue(userProblem.getUser() == user);    
    } 

    @Test
    public void testGetProblem() {
        User user = new User();
        Problem problem = new Problem(); 
        UserProblem userProblem = new UserProblem(user, problem, 0);

        assertTrue(userProblem.getProblem() == problem);  
    } 

    @Test
    public void testSetProblem() {
        User user = new User();
        Problem problem = new Problem(); 
        UserProblem userProblem = new UserProblem(user, problem, 0);
 
        userProblem.setProblem(problem);

        assertTrue(userProblem.getProblem() == problem);    
    } 

    @Test
    public void testGetStatusComplete() {
        User user = new User();
        Problem problem = new Problem(); 
        UserProblem userProblem = new UserProblem(user, problem, 0);

        userProblem.setStatusComplete(1);

        assertTrue(userProblem.getStatusComplete() == 1);  
    } 

    @Test
    public void testSetStatusComplete() {
        User user = new User();
        Problem problem = new Problem(); 
        UserProblem userProblem = new UserProblem(user, problem, 0);
 
        userProblem.setStatusComplete(1);

        assertTrue(userProblem.getStatusComplete() == 1);    
    }     
 
    @Test
    public void testGetFeedback() {
        User user = new User();
        Problem problem = new Problem(); 
        UserProblem userProblem = new UserProblem(user, problem, 0);

        userProblem.setFeedback("1 mistake on line 4");

        assertTrue(userProblem.getFeedback() == "1 mistake on line 4");  
    } 

    @Test
    public void testSetFeedback() {
        User user = new User();
        Problem problem = new Problem(); 
        UserProblem userProblem = new UserProblem(user, problem, 0);
 
        userProblem.setFeedback("1 mistake on line 4");

        assertTrue(userProblem.getFeedback() == "1 mistake on line 4");    
    }     
}