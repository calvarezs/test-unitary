package mingeso.UnitTests;

import cl.novuscreate.backend.Application;
import cl.novuscreate.backend.entity.Problem;
import cl.novuscreate.backend.entity.User;
import cl.novuscreate.backend.entity.UserProblem;
import cl.novuscreate.backend.entity.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
 
import java.util.HashSet; 
import java.util.Set;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class ProblemTest {

    @Test
    public void testGetProblemId() {
        Problem problem = new Problem();
 
        problem.setProblemId(100);

        assertTrue(problem.getProblemId() == 100);    
    } 

    @Test
    public void testSetProblemId() {
        Problem problem = new Problem();
 
        problem.setProblemId(100);

        assertTrue(problem.getProblemId() == 100);    
    } 

    @Test
    public void testGetProblemTitle() {
        Problem problem = new Problem();
 
        problem.setProblemTitle("Super original problem name");

        assertTrue(problem.getProblemTitle() == "Super original problem name");  
    } 

    @Test
    public void testSetProblemTitle() {
        Problem problem = new Problem();
 
        problem.setProblemTitle("Super original problem name");

        assertTrue(problem.getProblemTitle() == "Super original problem name");    
    } 

    @Test
    public void testGetProblemStatement() {
        Problem problem = new Problem();
 
        problem.setProblemStatement("Super original problem statement");

        assertTrue(problem.getProblemStatement() == "Super original problem statement");  
    } 

    @Test
    public void testSetProblemStatement() {
        Problem problem = new Problem();
 
        problem.setProblemStatement("Super original problem statement");

        assertTrue(problem.getProblemStatement() == "Super original problem statement");    
    }  

    @Test
    public void testGetUser() {
        Problem problem = new Problem();
        User user = new User();
 
        problem.setUser(user);

        assertTrue(problem.getUser() == user);  
    } 

    @Test
    public void testSetUser() {
        Problem problem = new Problem();
        User user = new User();

        problem.setUser(user);

        assertTrue(problem.getUser() == user);    
    }     
 

    @Test
    public void testGetUserProblems() {
        User user = new User();
        Problem problem = new Problem(); 

        Set setUSerProblem = new HashSet();
        UserProblem userProblem = new UserProblem(user,problem,0);
        setUSerProblem.add(userProblem);
 
        problem.setUserProblems(setUSerProblem);

        assertTrue(problem.getUserProblems() == setUSerProblem);  
    } 

    @Test
    public void testSetUserProblems() {
        User user = new User();
        Problem problem = new Problem(); 

        Set setUSerProblem = new HashSet();
        UserProblem userProblem = new UserProblem(user,problem,0); 
        setUSerProblem.add(userProblem);
 
        problem.setUserProblems(setUSerProblem);

        assertTrue(problem.getUserProblems() == setUSerProblem);   
    }     

    @Test
    public void testGetLanguage() {
        Problem problem = new Problem(); 
 
        problem.setLanguage("C");

        assertTrue(problem.getLanguage() == "C");  
    } 

    @Test
    public void testSetLanguage() {
        Problem problem = new Problem(); 

        problem.setLanguage("C");

        assertTrue(problem.getLanguage() == "C");    
    }        

    @Test
    public void testGetProblemExamples() {
        Problem problem = new Problem();  

        Set setExample = new HashSet();
        Example example = new Example();
        setExample.add(example);
 
        problem.setProblemExamples(setExample);

        assertTrue(problem.getProblemExamples() == setExample);  
    } 

    @Test
    public void testSetProblemExamples() {
        Problem problem = new Problem();  

        Set setExample = new HashSet();
        Example example = new Example();
        setExample.add(example);
 
        problem.setProblemExamples(setExample);

        assertTrue(problem.getProblemExamples() == setExample);   
    }         
 
}
