package mingeso.UnitTests;

import cl.novuscreate.backend.Application;
import cl.novuscreate.backend.entity.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.TestCase.assertEquals;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class SolutionTest {
    
    @Test
    public void solutionLanguageMustExists() {
        Solution solution = new Solution();
 
        solution.setSolutionCode("print \'hola mundo\'");

        assertEquals("The solution instance is invalid",false,solution.verificateSolution());
    }

    @Test
    public void solutionSolutionCodeExists() {
        Solution solution = new Solution();

        solution.setLanguage("solutionTester1"); 

        assertEquals("The solution instance is invalid",false,solution.verificateSolution());
    }

    @Test
    public void  correctVerificationSolution() {
        Solution solution = new Solution();

        solution.setLanguage("solutionTester1");
        solution.setSolutionCode("print \'hola mundo\'");

        assertEquals("The solution instance is invalid",true,solution.verificateSolution());

    } 
}
