package ex03;

import java.util.Formatter;
import ex02.Item2d;
import ex02.ViewResult;
/** ConcreteProduct
 * (design template
 *Factory Method)<br>
 * Table output
 * @author xone
 * @version1.0
 * @seeViewResult
 */

public class ViewTable extends ViewResult {
    /** Defines the default table width */
    private static final int DEFAULT_WIDTH = 45;
    /** Current table width */
    private int width;
    /** Set {@linkplain ViewTable#width width}
     * value {@linkplain ViewTable#DEFAULT_WIDTH DEFAULT_WIDTH}<br>
     * The super class constructor is called {@linkplain ViewResult#ViewResult() ViewResult()}
     */
    public ViewTable() {
        width = DEFAULT_WIDTH;
    }
    /** Sets {@linkplain ViewTable#width} to <b>width</b><br>
     * The super class constructor is called {@linkplain ViewResult#ViewResult() ViewResult()}
     * @param width specifies the width of the table
     */
    public ViewTable(int width) {
        this.width = width;
    }
    /** Sets {@linkplain ViewTable#width} to <b>width</b><br>
     * The superclass constructor is called {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
     * @param width specifies the width of the table
     * @param n number of elements in the collection; passed to the super constructor
     */
    public ViewTable(int width, int n) {
        super(n);
        this.width = width;
    }
    /** Sets the {@linkplain ViewTable#width} field to <b>width</b>
     * @param width new table width
     * @return the width of the table specified by the <b>width</b> parameter
     */
    public int setWidth(int width) {
        return this.width = width;
    }
    /** Returns the field value {@linkplain ViewTable#width}
     * @return current table width
     */
    public int getWidth() {
        return width;
    }
    /** Displays a vertical separator with a width of {@linkplain ViewTable#width} characters */
    private void outLine() {
        for(int i = width; i > 0; i--) {
            System.out.print('-');
        }
    }
    /** Calls {@linkplain ViewTable#outLine()}; ends the output with a line separator */
    private void outLineLn() {
        outLine();
        System.out.println();
    }
    /** Displays the table title with a width of {@linkplain ViewTable#width} characters */
    private void outHeader() {
        Formatter formatter = new Formatter();
        formatter.format("%" + ((width)/3) + "s|%" + ((width)/3) + "s|%" + ((width)/3) + "s\n", "Mass", "Velocity", "KineticEnergy");
        System.out.print(formatter.toString());
    }
    /** Displays the body of the table with a width of {@linkplain ViewTable#width} characters */
    private void outBody() {
        for (Item2d item : getItems()) {
            Formatter formatter = new Formatter();
            formatter.format("%" + ((width)/3) + ".2f|%" + ((width)/3) + ".2f|%" + ((width)/3) + "s\n", item.getMass(), item.getVelocity(), item.getKineticEnergy());
            System.out.print(formatter.toString());
        }
    }
    /** Overloading (overloading) a superclass method;
     * sets the {@linkplain ViewTable#width} field to <b>width</b><br>
     * Calls the {@linkplain ViewResult#viewInit() viewInit()} method
     * @param width new table width
     */
    public final void init(int width) { // method overloading
        this.width = width;
        viewInit();
    }
    /** Superclass method overload;
     * sets the {@linkplain ViewTable#width} field to <b>width</b><br>
     * @param width new table width.
     */
    public final void init(int width, double stepMass, double stepVelocity) { // method overloading
        this.width = width;
        init(stepMass, stepVelocity );
    }
    /** Redefining (replacing, overriding) the superclass method;
     * displays an informational message and calls the superclass method
     * {@inheritDoc}
     */
    @Override
    public void init(double stepMass, double stepVelocity) { // method overriding
        System.out.print("Initialization... ");
        super.init( stepMass,stepVelocity);
        System.out.println("done. ");
    }


    /** Display table element<br>{@inheritDoc} */
    @Override
    public void viewHeader() {
        outHeader();
        outLineLn();
    }
    /** Display table element<br>{@inheritDoc} */
    @Override
    public void viewBody() {
        outBody();
    }
    /** Display table element<br>{@inheritDoc} */
    @Override
    public void viewFooter() {
        outLineLn();
    }
}
