package Clases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * La clase CuentaTest contiene métodos de prueba para verificar el funcionamiento
 * de las operaciones en la clase Cuenta.
 */
class CuentaTest {
    private Cuenta cuenta;

    /**
     * Configura el entorno de prueba creando una nueva instancia de Cuenta
     * antes de cada método de prueba.
     */
    @BeforeEach
    public void setUp() {
        cuenta = new Cuenta();
    }

    /**
     * Prueba el método agregarSaldo para asegurar que el saldo se agregue correctamente.
     */
    @Test
    void testAgregarSaldo() {
        cuenta.agregarSaldo(1000);
        assertEquals(1000, cuenta.getSaldo());
    }

    /**
     * Prueba el método retirarSaldo para asegurar que el saldo se retire correctamente.
     */
    @Test
    void testRetirarSaldo() {
        cuenta.agregarSaldo(1000);
        cuenta.retirarSaldo(500);
        assertEquals(500, cuenta.getSaldo());
    }

    /**
     * Prueba el método consultarSaldoDespuesDeOperaciones para asegurar que el saldo se calcule correctamente
     * después de realizar varias operaciones.
     */
    @Test
    void testConsultarSaldoDespuesDeOperaciones() {
        cuenta.agregarSaldo(1000);
        cuenta.retirarSaldo(500);
        cuenta.agregarSaldo(200);
        assertEquals(700, cuenta.getSaldo());
    }

    /**
     * Prueba el método agregarSaldo con un monto negativo para asegurar que no se agregue saldo.
     */
    @Test
    void testAgregarSaldoNegativo() {
        cuenta.agregarSaldo(-500);
        assertEquals(0, cuenta.getSaldo());
    }

    /**
     * Prueba el método retirarSaldo con un monto negativo para asegurar que no se retire saldo.
     */
    @Test
    void testRetirarSaldoNegativo() {
        cuenta.retirarSaldo(-200);
        assertEquals(0, cuenta.getSaldo());
    }
}
