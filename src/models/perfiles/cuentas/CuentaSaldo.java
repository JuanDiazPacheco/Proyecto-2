package models.perfiles.cuentas;

import java.util.LinkedList;

import models.productos.Producto;

public class CuentaSaldo extends Cuentas {
    // private double dinero;
    private LinkedList<String> operaciones = new LinkedList<>();

    // Constructor

    public CuentaSaldo(double monto) {
        super(monto);
        operaciones.add("Se ha abierto una cuenta con un monto de: " + monto + "$.");
    }

    /**
     * @return LinkedList<String>
     */
    // Getters

    public LinkedList<String> getOperaciones() {
        return this.operaciones;
    }

    /**
     * @param operaciones
     */
    // Setter

    public void setOperaciones(LinkedList<String> operaciones) {
        this.operaciones = operaciones;
    }

    /**
     * @param monto
     * @param producto
     * @return boolean
     */
    // Metodos
    public boolean comprar(double monto, Producto producto) {
        if (dinero - monto > 0) {
            this.dinero -= monto;
            operaciones.add("Se ha comprado: " + monto + "$.");
            return true;
        } else
            return false;
    }

    /**
     * @param deposito
     */
    public void depositarDinero(double deposito) {
        this.dinero += deposito;
        operaciones.add("Se ha depositado: " + deposito + "$.");
    }

}
