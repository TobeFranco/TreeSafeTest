package mx.edu.itsur.tototlan.tototlan;

//import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;


        import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
//@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest  {


    TestSQliteDAO testSQliteDAO = new TestSQliteDAO();
    mx.edu.itsur.tototlan.tototlan.modelo.Test t = new mx.edu.itsur.tototlan.tototlan.modelo.Test();


    @org.junit.Test
    public void testAdd(){
        t.setIdTest(2);
        assertTrue(testSQliteDAO.add(t));

    }

    @Test
    public void testGet(){
       assertNotNull(testSQliteDAO.get(1));
    }
}
