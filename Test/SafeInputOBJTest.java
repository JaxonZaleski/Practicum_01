import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SafeInputOBJTest {

    Scanner in = new Scanner(System.in);
    SafeInputOBJ obj = new SafeInputOBJ(in);


    @Test
    void getTestNonZeroLenString() {
        String name = obj.getNonZeroLenString("Enter your name");
        assertEquals("N", name);
    }

    @Test
    void getTestInt() {
        int number = obj.getInt("Enter a number");
        assertEquals(1, number);
    }

    @Test
    void getTestDouble() {
        double number = obj.getDouble("Enter a double");
        assertEquals(1.0, number);
    }

    @Test
    void getTestRangedInt() {
        int rangedInt = obj.getRangedInt("Enter an int between 1 and 10", 1, 10);
        assertEquals(9, rangedInt);

    }

    @Test
    void getTestRangedDouble() {
        double rangedDouble = obj.getRangedDouble("Enter a double between 1.0 and 10.0", 1.0, 10.0);
        assertEquals(9.0, rangedDouble);
    }

    @Test
    void getTestYNConfirm() {
        boolean ynConfirm = obj.getYNConfirm("Enter Yes [Y] or No [N]");
        assertEquals(true, ynConfirm);
    }

    @Test
    void getTestRegExString() {
        String regEx = obj.getRegExString("Enter a 2 digit number", "\\d{2}");
        assertEquals("20", regEx);
    }
}