import static org.junit.Assert.*;
import org.junit.Test;

public class TestFlik {

    @Test
        public void testIsSameNumber() {
        boolean a = true;
        boolean b = false;
        assertEquals (a, Flik.isSameNumber(5, 5));

        assertEquals(b,Flik.isSameNumber(6,7));
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", TestFlik.class);
    }



}
