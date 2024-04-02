package Clases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * La clase ConversorMonedaTest contiene métodos de prueba para verificar el funcionamiento
 * de las conversiones de moneda en la clase ConversorMoneda.
 */
public class ConversorMonedaTest {
    private ConversorMoneda conversorMoneda;
    private Cuenta cuenta;

    /**
     * Configura el entorno de prueba creando una instancia de cuenta y conversorMoneda
     * antes de cada método de prueba.
     */
    @BeforeEach
    void setUp() {
        cuenta = new Cuenta();
        conversorMoneda = new ConversorMoneda(cuenta);
    }

    /**
     * Prueba la conversión de saldo de CLP a USD.
     */
    @Test
    void testCLP_A_USD() {
        cuenta.setSaldo(1000);
        String resultado = conversorMoneda.CLP_A_USD();
        Assertions.assertEquals("1,04 USD", resultado);
    }

    /**
     * Prueba la conversión de saldo de CLP a EUR.
     */
    @Test
    void testCLP_A_EUR() {
        cuenta.setSaldo(1000);
        String resultado = conversorMoneda.CLP_A_EUR();
        Assertions.assertEquals("0,95 EUR", resultado);
    }
}

