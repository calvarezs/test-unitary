package mingeso.UnitTests;

import cl.novuscreate.backend.Application; 
import cl.novuscreate.backend.entity.Input;
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
public class InputTest {    

    @Test
    public void testGetInputId() {
        Input input = new Input();  
 
        input.setInputId(1000);

        assertTrue(input.getInputId() == 1000);  
    } 

    @Test
    public void testSetInputId() {
        Input input = new Input();    

        input.setInputId(1000);

        assertTrue(input.getInputId() == 1000);    
    } 

    @Test
    public void testGetInputType() {
        Input input = new Input();  
 
        input.setInputType("generic");

        assertTrue(input.getInputType() == "generic");  
    } 

    @Test
    public void testSetInputType() {
        Input input = new Input();    

        input.setInputType("generic");

        assertTrue(input.getInputType() == "generic");    
    }     
 
    @Test
    public void testGetInputValue() {
        Input input = new Input();  
 
        input.setInputValue("generic");

        assertTrue(input.getInputValue() == "generic");  
    } 

    @Test
    public void testSetInputValue() {
        Input input = new Input();    

        input.setInputValue("generic");

        assertTrue(input.getInputValue() == "generic");    
    }  

    @Test
    public void testGetExample() {
        Input input = new Input(); 
        Example example = new Example(); 
 
        input.setExample(example);

        assertTrue(input.getExample() == example);  
    } 

    @Test
    public void testSetExample() {
        Input input = new Input();  
        Example example = new Example();   

        input.setExample(example);

        assertTrue(input.getExample() == example);    
    }  
}