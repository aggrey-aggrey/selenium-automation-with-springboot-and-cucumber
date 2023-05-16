import com.aggrey.annotations.LazyAutowired;
import com.aggrey.steps.LoginSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class LoginTest {
    /*

    The LoginTest class extends the BaseTest class and is annotated with Junit Jupiter’s @Execution(ExecutionMode.CONCURRENT)
    annotation for parallel test execution.
     In this class,  LoginSteps is autowired and  then  used its methods to implement test scenarios for each test.
     */

    @LazyAutowired
    LoginSteps loginSteps;


    @Test
    public void invalidUserNameInvalidPassword() throws InterruptedException {
        loginSteps
                .givenIAmAtLoginPage()
                .whenILogin("", "")
                .thenIVerifyInvalidLoginMessage();
    }

    @Test
    public void emptyUserEmptyPassword() {
        loginSteps
                .givenIAmAtLoginPage()
                .whenILogin("", "")
                .thenIVerifyUserNameErrorMessages("Lütfen e-posta adresinizi girin.")
                .thenIVerifyPasswordErrorMessage("Bu alanın doldurulması zorunludur.");
    }
}
