/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package nqueens;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void testAppHasAGreeting() {
    	System.out.println("testAppHasAGreeting test");
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
