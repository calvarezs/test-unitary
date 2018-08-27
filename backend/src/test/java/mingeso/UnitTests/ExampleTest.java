package mingeso.UnitTests;

import cl.novuscreate.backend.Application; 
import cl.novuscreate.backend.entity.Example;
import cl.novuscreate.backend.entity.Input;
import cl.novuscreate.backend.entity.Result;
import cl.novuscreate.backend.entity.Problem;
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
public class ExampleTest {    

    @Test
    public void testGetExampleId() {
        Example example = new Example();  
 
        example.setExampleId(1000);

        assertTrue(example.getExampleId() == 1000);  
    } 

    @Test
    public void testSetExampleId() {
        Example example = new Example();  

        example.setExampleId(1000);

        assertTrue(example.getExampleId() == 1000);    
    }    
 

    @Test
    public void testGetExampleTitle() {
        Example example = new Example();  
 
        example.setExampleTitle("supero original exampe title");

        assertTrue(example.getExampleTitle() == "supero original exampe title");  
    } 

    @Test
    public void testSetExampleTitle() {
        Example example = new Example();  

        example.setExampleTitle("supero original exampe title");

        assertTrue(example.getExampleTitle() == "supero original exampe title");    
    }    

    @Test
    public void testGetProblem() {
        Example example = new Example(); 
        Problem problem = new Problem();
 
        example.setProblem(problem);

        assertTrue(example.getProblem() == problem);  
    } 

    @Test
    public void testSetProblem() {
        Example example = new Example(); 
        Problem problem = new Problem();

        example.setProblem(problem);

        assertTrue(example.getProblem() == problem);    
    }

    @Test
    public void testGetExampleInputs() {
        Example example = new Example();  

        Set setExampleInputs = new HashSet();
        Input input = new Input();
        setExampleInputs.add(input);
 
        example.setExampleInputs(setExampleInputs);

        assertTrue(example.getExampleInputs() == setExampleInputs);  
    } 

    @Test
    public void testSetExampleInputs() {
        Example example = new Example();  

        Set setExampleInputs = new HashSet();
        Input input = new Input();
        setExampleInputs.add(input);
 
        example.setExampleInputs(setExampleInputs);

        assertTrue(example.getExampleInputs() == setExampleInputs);    
    }     

    @Test
    public void testGetResult() {
        Example example = new Example(); 
        Result result = new Result();
 
        example.setResult(result);

        assertTrue(example.getResult() == result);  
    } 

    @Test
    public void testSetResult() {
        Example example = new Example(); 
        Result result = new Result();

        example.setResult(result);

        assertTrue(example.getResult() == result);    
    }        
}