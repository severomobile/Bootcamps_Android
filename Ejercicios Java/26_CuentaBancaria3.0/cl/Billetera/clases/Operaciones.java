package cl.Billetera.clases;

public class Operaciones {

    public void depositar (Cuenta cuenta, double cantidad) {

        double saldoActual = cuenta.getSaldoCuenta();

        cuenta.setSaldoCuenta(saldoActual + cantidad);

        System.out.println("Se realizo el deposito con exito. Saldo actual: "
                + cuenta.formatearSaldo(cuenta.getSaldoCuenta()));
    }
}
