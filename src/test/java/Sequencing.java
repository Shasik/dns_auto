import org.testng.Assert;
import org.testng.annotations.*;


public class Sequencing {

    @Test(groups = "two")
    public void testCase1() throws InterruptedException {

        Thread.sleep(3000);
        Assert.assertTrue(false);

    }

    @Test(dependsOnMethods = "testCase1")
    public void testCase2() {

        System.out.println("This is the Test Case 2");

    }

    @BeforeMethod
    public void beforeMethod() {

        System.out.println("This will execute before every Method");

    }

    @AfterMethod
    public void afterMethod() {

        System.out.println("This will execute after every Method");

    }

    @BeforeClass
    public void beforeClass() {

        System.out.println("This will execute before Class");

    }

    @AfterClass
    public void afterClass() {

        System.out.println("This will execute after the Class");

    }

    @BeforeTest
    public void beforeTest() {

        System.out.println("This will execute before the Test");

    }

    @AfterTest
    public void afterTest() {

        System.out.println("This will execute after the Test");

    }

    @BeforeSuite
    public void beforeSuite() {

        System.out.println("This will execute before the Test Suite");

    }

    @AfterSuite
    public void afterSuite() {

        System.out.println("This will execute after Test Suite");

    }

}