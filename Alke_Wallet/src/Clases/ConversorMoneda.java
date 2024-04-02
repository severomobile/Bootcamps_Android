package Clases;

import Interfaces.MenuInterface;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * La clase ConversorMoneda implementa la interfaz MenuInterface y
 * tiene metodos para convertir el saldo de CLP a USD y EUR.
 */
public class ConversorMoneda implements MenuInterface {

    private static final double TASA_USD_A_CLP = 965.96856; // 1 USD a CLP 19 de marzo de 2024
    private static final double TASA_EUR_A_CLP = 1048.8227; // 1 EUR a CLP 19 de marzo de 2024

    private final Cuenta cuenta;
    private final Scanner scanner;

    /**
     * Constructor de la clase ConversorMoneda.
     *
     * @param cuenta La cuenta bancaria asociada al conversor.
     */
    public ConversorMoneda(Cuenta cuenta) {
        this.cuenta = cuenta;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Convierte el saldo de CLP a USD y muestra el resultado.
     *
     * @return La cantidad convertida de CLP a USD.
     */
    public String CLP_A_USD() {
        double moneda = cuenta.getSaldo() / TASA_USD_A_CLP;
        return formatoMiles(moneda) + " USD";
    }

    /**
     * Convierte el saldo de CLP a EUR y muestra el resultado.
     *
     * @return La cantidad convertida de CLP a EUR.
     */
    public String CLP_A_EUR() {
        double moneda = cuenta.getSaldo() / TASA_EUR_A_CLP;
        return formatoMiles(moneda) + " EUR";
    }

    /**
     * Inicia el menú de conversor de divisas.
     */
    @Override
    public void iniciarMenu() {
        if (cuenta.getSaldo() > 0) {
            int seleccion;
            do {
                mostrarMenu();
                seleccion = scanner.nextInt();
                seleccionMenu(seleccion);
            } while (seleccion != 3);
        } else {
            System.out.println("Debes agregar saldo para convertir divisas");
        }
    }

    /**
     * Muestra el menú de conversor de divisas.
     */
    @Override
    public void mostrarMenu() {
        System.out.println("Menú Conversor De Divisas");
        System.out.println("1. Convertir Saldo de CLP a USD");
        System.out.println("2. Convertir Saldo de CLP a EUR");
        System.out.println("3. Salir");
        System.out.print("Ingrese el número de la opción que desea realizar: ");
    }

    /**
     * Selecciona una opción del menú y ejecuta la acción correspondiente.
     *
     * @param seleccion La opción seleccionada por el usuario.
     */
    @Override
    public void seleccionMenu(int seleccion) {
        ejecutarSeleccion(seleccion);
    }

    /**
     * Ejecuta la acción correspondiente a la opción seleccionada.
     *
     * @param seleccion La opción seleccionada por el usuario.
     */
    @Override
    public void ejecutarSeleccion(int seleccion) {
        switch (seleccion) {
            case 1:
                System.out.println(CLP_A_USD());
                break;
            case 2:
                System.out.println(CLP_A_EUR());
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida, por favor intente de nuevo.");
        }
    }

    /**
     * Formatea un número para mostrarlo con separadores de miles.
     *
     * @param numero El número a formatear.
     * @return El número formateado con separadores de miles.
     */
    private String formatoMiles(double numero) {
        DecimalFormat formatoMiles = new DecimalFormat("#,###.##");
        return formatoMiles.format(numero);
    }
}


