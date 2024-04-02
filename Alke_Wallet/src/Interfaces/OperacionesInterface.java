package Interfaces;

/**
 * La interfaz OperacionesInterface define los métodos necesarios para realizar operaciones básicas en una cuenta.
 * Estos métodos incluyen agregar saldo, retirar saldo y consultar saldo.
 */
public interface OperacionesInterface {

    /**
     * Agrega un monto específico al saldo de la cuenta.
     *
     * @param monto El monto a agregar al saldo.
     */
    void agregarSaldo(double monto);

    /**
     * Retira un monto específico del saldo de la cuenta.
     *
     * @param monto El monto a retirar del saldo.
     */
    void retirarSaldo(double monto);

    /**
     * Consulta el saldo actual de la cuenta.
     */
    void consultarSaldo();
}

