/**
 * Created by Yasi on 11/22/2017.
 */
import dataaccess.CountryDao;
import manager.Manager;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AppTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestManagerDetails.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("Result was successful: " + result.wasSuccessful());
    }
}

