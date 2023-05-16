import com.aggrey.annotations.LazyAutowired;
import com.aggrey.annotations.SeleniumTest;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

@SeleniumTest
@Getter
public class BaseTest {

    /*
    The base test class is annotated by @SeleniumTest annotation and the Lombok library’s @Getter annotation to get the instances from the base test class.
     We have here the common logger, application context instances,
     and by using the applicationContext’s WebDriver bean, we can quit the browser in the teardown() method.
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeEach
    public void setup(){
    }

    @LazyAutowired
    public ApplicationContext applicationContext;


    public void teardown(){
        this.applicationContext
                .getBean(WebDriver.class)
                .quit();
    }


}
