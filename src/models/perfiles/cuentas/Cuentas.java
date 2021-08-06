package models.perfiles.cuentas;

public abstract class Cuentas {
    public double dinero;

    // Constructores

    public Cuentas() {

    }

    public Cuentas(float dinero) {
        this.dinero = dinero;
    }

    public Cuentas(double dinero) {
        this.dinero = dinero;
    }

    /**
     * @return double
     */
    // Getter Dinero

    public double getDinero() {
        return this.dinero;
    }

}
