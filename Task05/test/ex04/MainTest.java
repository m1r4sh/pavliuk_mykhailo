package ex04;
import org.junit.Before;
import org.junit.Test;
import ex02.Item2d;
import ex02.ViewResult;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MainTest {
    private Item2d item;
    private ViewResult viewResult;

    @Before
    public void init(){
        item = new Item2d(10.0, 20.0, 2000.0);
        viewResult = new ViewResult();
        viewResult.init(10.0, 20.0);
    }

    @Test
    public void testItem2D(){
        assertEquals(10.0, item.getMass(), 0.001);
        assertEquals(20.0, item.getVelocity(), 0.001);
        assertEquals(2000.0, item.getKineticEnergy(), 0.001);
        item.setMass(5.0);
        item.setVelocity(10.0);
        item.setKineticEnergy(250.0);
        assertEquals(5.0, item.getMass(), 0.001);
        assertEquals(10.0, item.getVelocity(), 0.001);
        assertEquals(250.0, item.getKineticEnergy(), 0.001);
    }

    @Test
    public void testViewResult(){
        assertNotNull(viewResult.getItems());
        ArrayList<Item2d> items = viewResult.getItems();
        assertEquals(10, items.size());
        for (Item2d item : items) {
            assertNotNull(item.getMass());
            assertNotNull(item.getVelocity());
            assertNotNull(item.getKineticEnergy());
        }
    }
}
