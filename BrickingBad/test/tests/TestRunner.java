package tests;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(GameControllerTest.class, BallTest.class, BrickFactoryTest.class, PaddleTest.class, SimpleBrickTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        
        System.out.println("---------- Testing Classes As A Whole ----------");

        System.out.println(result.wasSuccessful());
        
        
        System.out.println("---------- Testing repOk() ----------");
        
        System.out.println("\n---------- Ball Test ----------");
        BallTest ballTest = new BallTest();
        System.out.println("repOK() = " + ballTest.repOk());
        System.out.println(ballTest.toString());
        
        System.out.println("\n---------- Brick Factory Test ----------");
        BrickFactoryTest factoryTest = new BrickFactoryTest();
        System.out.println("repOK() = " + factoryTest.repOk());
        System.out.println(factoryTest.toString());
        
        System.out.println("\n---------- Game Controller Test ----------");
        GameControllerTest gcTest = new GameControllerTest();
        System.out.println("repOK() = " + gcTest.repOk());
        System.out.println(gcTest.toString());
        
        System.out.println("\n---------- Paddle Test ----------");
        PaddleTest paddleTest = new PaddleTest();
        System.out.println("repOK() = " + paddleTest.repOk());
        System.out.println(paddleTest.toString());
        
        System.out.println("\n---------- Simple Brick Test ----------");
        SimpleBrickTest simpleBrickTest = new SimpleBrickTest();
        System.out.println("repOK() = " + simpleBrickTest.repOk());
        System.out.println(simpleBrickTest.toString());
        
        
    }
}