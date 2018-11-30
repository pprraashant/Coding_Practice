import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;



/**
 * Test the add method of Math object
 */
public class MathAddTestWithOutMock {
 Math mathObj; 

 @Before
 /**
  * Create Math object before you use them
  */
 public void create() {
  mathObj = new Math();//create a math object
 }

 @Test
 public void test() {
  assertSame(3, mathObj.add(1, 2)); // Assert that math object return 3

 }

}