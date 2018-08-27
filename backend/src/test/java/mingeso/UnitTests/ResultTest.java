package mingeso.UnitTests;

import cl.novuscreate.backend.Application; 
import cl.novuscreate.backend.entity.Result; 
import cl.novuscreate.backend.entity.Example; 
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
public class ResultTest {    

    @Test
    public void testGetResultId() {
        Result result = new Result();  
 
        result.setResultId(1000);

        assertTrue(result.getResultId() == 1000);  
    } 

    @Test
    public void testSetResultId() {
        Result result = new Result();    

        result.setResultId(1000);

        assertTrue(result.getResultId() == 1000);    
    } 

    @Test
    public void testGetResultType() {
        Result result = new Result();  
 
        result.setResultType("generic");

        assertTrue(result.getResultType() == "generic");  
    } 

    @Test
    public void testSetResultType() {
        Result result = new Result();    

        result.setResultType("generic");

        assertTrue(result.getResultType() == "generic");    
    } 

    @Test
    public void testGetResultValue() {
        Result result = new Result();
 
        result.setResultValue("generic");

        assertTrue(result.getResultValue() == "generic");
    } 

    @Test
    public void testSetResultValue() {
        Result result = new Result();

        result.setResultValue("generic");

        assertTrue(result.getResultValue() == "generic");
    } 

    @Test
    public void testGetExample() {
        Result result = new Result();  
        Example example = new Example();
 
        result.setExample(example);

        assertTrue(result.getExample() == example);  
    } 

    @Test
    public void testSetExample() {
        Result result = new Result();    
        Example example = new Example();

        result.setExample(example);

        assertTrue(result.getExample() == example);    
    } 
}