import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MainTest {
    /** Проверка основной функциональности класса {@linkplain Calc} */
    private Calc calc;

    @Before
    public void setUp() {
        calc = new Calc();
    }

    @Test
    public void testCalc() {
        Item2d expected = new Item2d(10.0, 20.0, 2000.0);
        Item2d actual = calc.calc(10.0, 20.0);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testSaveAndRestore() {
        Item2d expected = new Item2d(5.0, 10.0, 250.0);
        calc.setResult(expected);
        try {
            calc.save();
            calc.restore();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Item2d actual = calc.getResult();
        assertEquals(expected.toString(), actual.toString());
    }

    @After
    public void tearDown() {
        calc = null;
    }

}

