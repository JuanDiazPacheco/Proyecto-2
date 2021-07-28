package models.perfiles.cuentas;

import java.util.LinkedList;

public class CuentaAhorro extends Cuentas {
    // private double dinero;
    private LinkedList<String> operaciones = new LinkedList<>();

    // Constructor

    public CuentaAhorro(double monto) {
        super(monto);
        operaciones.add("Se ha abierto una cuenta con un monto de: " + monto + "$.");
    }

    // Getters

    public LinkedList<String> getOperaciones() {
        return this.operaciones;
    }

    // Setter

    public void setOperaciones(LinkedList<String> operaciones) {
        this.operaciones = operaciones;
    }

    // Metodos
    public boolean retirarDinero(double monto, boolean investing) {
        if (dinero - monto > 0) {
            this.dinero -= monto;
            if (investing)
                operaciones.add("Se ha invertido: " + monto + "$.");
            else
                operaciones.add("Se ha retirado: " + monto + "$.");
            return true;
        } else
            return false;
    }

    public void depositarDinero(double deposito) {
        this.dinero += deposito;
        operaciones.add("Se ha depositado: " + deposito + "$.");
    }

    public void depositarDineroInvertido(double deposito) {
        this.dinero += deposito;
        operaciones.add("Se han depositado: " + deposito + "$ por la inversion.");
    }

}
