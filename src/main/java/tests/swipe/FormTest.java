package tests.swipe;


import org.testng.annotations.Test;
import test_flows.form_flow.FormFlow;
import tests.BaseTest;

public class FormTest extends BaseTest {

    @Test
    public void formTest() throws InterruptedException {
        System.out.println("Session ID: " +getDriver().getSessionId());
        FormFlow formFlow = new FormFlow(getDriver());

        formFlow.clickToFormScreen();
        formFlow.form();
    }

}
