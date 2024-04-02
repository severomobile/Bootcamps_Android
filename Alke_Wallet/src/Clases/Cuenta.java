package Clases;

import Interfaces.OperacionesInterface;
import java.text.DecimalFormat;

/**
 * La clase Cuenta representa una cuenta bancaria con métodos para agregar, retirar y consultar saldo.
 * Implementa la interfaz OperacionesInterface para heredar los métodos.
 */
public class Cuenta extends EntidadBilletera implements OperacionesInterface {

    private double saldo;

    /**
     * Constructor de la clase Cuenta.
     */
    public Cuenta() {
        super();
        this.saldo = 0.0;
    }

    /**
     * Agrega un monto al saldo de la cuenta.
     *
     * @param monto El monto a agregar al saldo. Debe ser mayor que 0.
     */
    @Override
    public void agregarSaldo(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Se han agregado: " + formatoMiles(monto) + " al saldo de tu cuenta");
        } else {
            System.out.println("El monto a agregar debe ser mayor a 0");
        }
    }

    /**
     * Retira un monto del saldo de la cuenta.
     *
     * @param monto El monto a retirar del saldo. Debe ser mayor que 0
     *              y no debe superar el saldo actual.
     */
    @Override
    public void retirarSaldo(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            System.out.println("Se han retirado: " + formatoMiles(monto) + " al saldo de tu cuenta");
        } else {
            System.out.print("El monto que desea retirar es inválido o supera el saldo de su cuenta");
        }
    }

    /**
     * Consulta el saldo actual de la cuenta.
     */
    @Override
    public void consultarSaldo() {
        System.out.println("El saldo de su cuenta es: " + formatoMiles(saldo));
    }

    /**
     * Formatea un número para mostrarlo con separadores de miles y con la moneda CLP.
     *
     * @param numero El número a formatear.
     * @return El número formateado con separadores de miles y la moneda CLP.
     */
    private String formatoMiles(double numero) {
        DecimalFormat formatoMiles = new DecimalFormat("#,###.##" + " CLP");
        return formatoMiles.format(numero);
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     *
     * @return El saldo actual de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo de la cuenta.
     *
     * @param saldo El saldo a establecer.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

