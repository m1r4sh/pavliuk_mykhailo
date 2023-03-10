
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Calc {

    private static final String FNAME = "Item2d.bin";

    private Item2d result;

    public Calc() {
        result = new Item2d();
    }

    public void setResult(Item2d result) {
        this.result = result;
    }
    public Item2d getResult() {
        return result;
    }

    Item2d calc(double mass, double velocity) {
        // обчислюємо кінетичну енергію
        double kineticEnergy = 0.5 * mass * Math.pow(velocity, 2);

        // отримуємо цілу частину кінетичної енергії
        int integerPart = (int) kineticEnergy;

        // переводимо цілу частину в двійкову систему числення
        String binaryIntegerPart = Integer.toBinaryString(integerPart);

        return new Item2d(mass, velocity, kineticEnergy);
    }


    public void init(double mass,double velocity) {
        setResult(calc(mass, velocity));
    }
    public void show() {
        System.out.println(result);
    }

    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new
                FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }

    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Item2d)is.readObject();
        is.close();
    }
}
