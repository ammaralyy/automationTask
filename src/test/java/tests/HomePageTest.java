package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.MyTasksPage;
import pages.NewTaskPage;
import pages.SignUp;

public class HomePageTest extends TestBase {

    HomePage homepageObject;
    MyTasksPage myTasksObject;
     NewTaskPage newTaskPage;
    SignUp signUpObject;

    @Test(priority = 1, alwaysRun = true)
    public void userRegisteredSuccessfully() throws InterruptedException {

        homepageObject = new HomePage(driver);
        myTasksObject = new MyTasksPage(driver);

        signUpObject = new SignUp(driver);
        signUpObject.register("ammar", "01265555555", "vbbvbbbb@mail.com", "12345678");

        Thread.sleep(2000);

        homepageObject.openMyTasks();

        Thread.sleep(2000);

        myTasksObject.openNewTask();

        Thread.sleep(2000);

    }

    @Test(dependsOnMethods = {"userRegisteredSuccessfully"})
    public void createNewTask() throws InterruptedException {

        newTaskPage = new NewTaskPage(driver);

        newTaskPage.setPriorityList();
        newTaskPage.setAssignee();
        newTaskPage.createNewTask("task1");

        Thread.sleep(5000);
    }
}
