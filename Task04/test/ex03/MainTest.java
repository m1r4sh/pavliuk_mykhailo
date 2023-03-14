package ex03;
import static org.junit.Assert.*;
import org.junit.Test;
import ex02.Item2d;

public class MainTest {

    @Test
    public void testSettersAndGetters() {
        Item2d item = new Item2d();
        item.setMass(10.0);
        item.setVelocity(20.0);
        item.setKineticEnergy(2000.0);

        assertEquals(10.0, item.getMass(), 0.01);
        assertEquals(20.0, item.getVelocity(), 0.01);
        assertEquals(2000.0, item.getKineticEnergy(), 0.01);
    }

    @Test
    public void testToString() {
        Item2d item = new Item2d(10.0, 20.0, 2000.0);
        assertEquals("маса=10.0, швидкість=20.0, кінетична енергія=2000.0", item.toString());
    }
}
