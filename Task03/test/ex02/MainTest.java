package ex02;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testItem2d() {
        Item2d item = new Item2d(10.0, 20.0, 3000.0);
        assertEquals(10.0, item.getMass(), 0.0);
        assertEquals(20.0, item.getVelocity(), 0.0);
        assertEquals(3000.0, item.getKineticEnergy(), 0.0);

        item.setMass(15.0);
        item.setVelocity(10.0);
        item.setKineticEnergy(750.0);

        assertEquals(15.0, item.getMass(), 0.0);
        assertEquals(10.0, item.getVelocity(), 0.0);
        assertEquals(750.0, item.getKineticEnergy(), 0.0);
    }

    @Test
    public void testView() {
        View view = new ViewableResult().getView();
        assertNotNull(view);
    }
    @Test
    public void testFactoryMethod() throws Exception {
        Viewable viewable = new ViewableResult();
        View view = viewable.getView();
        assertNotNull(view);

        view.viewInit();
        view.viewHeader();
        view.viewBody();
        view.viewSave();
        view.viewRestore();
        view.viewHeader();
        view.viewBody();
    }

}