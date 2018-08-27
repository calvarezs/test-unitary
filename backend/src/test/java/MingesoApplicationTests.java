import mingeso.UnitTests.UserTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class MingesoApplicationTests {

    public static void main(String[] args) {
        org.junit.runner.Result result = JUnitCore.runClasses(UserTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }

}