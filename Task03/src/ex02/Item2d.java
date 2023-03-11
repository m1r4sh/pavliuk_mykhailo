package ex02;

import java.io.Serializable;

public class Item2d implements Serializable {
    private static final long serialVersionUID = 1L;
    private double mass;
    private double velocity;
    private double kineticEnergy;
    public Item2d (){}
    public Item2d(double mass, double velocity, double kineticEnergy) {
        this.mass = mass;
        this.velocity = velocity;
        this.kineticEnergy = kineticEnergy;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getKineticEnergy() {
        return kineticEnergy;
    }

    public void setKineticEnergy(double kineticEnergy) {
        this.kineticEnergy = kineticEnergy;
    }

    @Override
    public String toString() {
        return "маса=" + mass + ", швидкість=" + velocity + ", кінетична енергія=" + kineticEnergy  ;
    }
}