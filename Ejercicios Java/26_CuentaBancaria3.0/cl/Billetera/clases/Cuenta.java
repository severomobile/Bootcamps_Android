package cl.Billetera.clases;

import java.text.DecimalFormat;

public class Cuenta {

    //1. Atributos de una clase

    private int numeroCuenta;
    private String titularCuenta;
    private double saldoCuenta;

    //2. Constructor

    public Cuenta () {
    }

    //3. Metodos de acceso

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitularCuenta() {
        return titularCuenta;
    }

    public void setTitularCuenta(String titularCuenta) {
        this.titularCuenta = titularCuenta;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }


    //4. Metodos de comportamiento

    public void mostrarInformacionCuentaCorriente () {

        String formatoSaldo = formatearSaldo(saldoCuenta);

        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Titular de cuenta: " + titularCuenta);
        System.out.println("Saldo de cuenta: " + formatoSaldo);
    }

    //5. Metodos utilitarios o de logica
    public String formatearSaldo (double saldo) {
        DecimalFormat formatoSaldo = new DecimalFormat("#,###");

        return formatoSaldo.format(saldo);
    }
}
