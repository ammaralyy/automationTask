package tests;

import org.testng.annotations.Test;
import pages.*;

public class StartTaskTest extends TestBase {

    HomePage homepageObject;
    MyTasksPage myTasksObject;
    SignIn signInObject;

    @Test(priority = 1, alwaysRun = true)
    public void userLoginSuccessfully() throws InterruptedException {

        homepageObject = new HomePage(driver);
        myTasksObject = new MyTasksPage(driver);

        signInObject = new SignIn(driver);
        signInObject.signIn("01287114418", "12345678");

        Thread.sleep(2000);

        homepageObject.openMyTasks();

        Thread.sleep(2000);

        myTasksObject.openTask();

        Thread.sleep(2000);

    }

    @Test(dependsOnMethods = {"userLoginSuccessfully"})
    public void cancelTask() throws InterruptedException {

        myTasksObject = new MyTasksPage(driver);

        myTasksObject.startTask();

        Thread.sleep(5000);
    }
}
