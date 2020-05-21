package test;

import domain.ObamaBot;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ObamaBotTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        result = JUnitCore.runClasses(ComponentTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }

}
