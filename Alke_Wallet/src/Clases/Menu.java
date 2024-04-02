package Clases;

import Interfaces.MenuInterface;
import java.util.Scanner;

/**
 * La clase Menu gestiona las interacciones del usuario,
 * permitiéndo agregar saldo, retirar saldo, consultar saldo y convertir divisas.
 */
public class Menu implements MenuInterface {
    private final Cuenta cuenta;
    private final Scanner scanner;

    /**
     * Construye una instancia de Menu asociada a una cuenta.
     *
     * @param cuenta La cuenta con la que el menú interactuará.
     */
    public Menu(Cuenta cuenta) {
        this.cuenta = cuenta;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Inicia el menú.
     */
    @Override
    public void iniciarMenu() {
        int seleccion;
        do {
            mostrarMenu();
            seleccion = scanner.nextInt();
            seleccionMenu(seleccion);
        } while (seleccion != 5);
    }

    /**
     * Muestra las opciones disponibles en el menú.
     */
    @Override
    public void mostrarMenu() {
        System.out.println("Menu Alke Wallet");
        System.out.println("1. Agregar Saldo CLP");
        System.out.println("2. Retirar Saldo CLP");
        System.out.println("3. Consultar Saldo");
        System.out.println("4. Conversor Divisas");
        System.out.println("5. Salir");
        System.out.print("Ingrese el número de la opción que desea realizar: ");
    }

    /**
     * Procesa la selección del usuario del menú.
     *
     * @param seleccion El número de la opción elegida por el usuario.
     */
    @Override
    public void seleccionMenu(int seleccion) {
        ejecutarSeleccion(seleccion);
    }

    /**
     * Ejecuta la acción correspondiente a la selección del usuario.
     *
     * @param seleccion El número de la opción elegida por el usuario.
     */
    @Override
    public void ejecutarSeleccion(int seleccion) {
        switch (seleccion) {
            case 1:
                agregarSaldo();
                break;
            case 2:
                retirarSaldo();
                break;
            case 3:
                consultarSaldo();
                break;
            case 4:
                menuConversor();
                break;
            case 5:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida, por favor intente de nuevo.");
        }
    }

    /**
     * Permite al usuario agregar saldo a su cuenta.
     */
    void agregarSaldo() {
        System.out.print("Ingrese el monto a agregar: ");
        double monto = scanner.nextDouble();
        cuenta.agregarSaldo(monto);
    }

    /**
     * Permite al usuario retirar saldo de su cuenta.
     */
    private void retirarSaldo() {
        System.out.print("Ingrese el monto a retirar: ");
        double monto = scanner.nextDouble();
        cuenta.retirarSaldo(monto);
    }

    /**
     * Permite al usuario consultar el saldo de su cuenta.
     */
    private void consultarSaldo() {
        cuenta.consultarSaldo();
    }

    /**
     * Inicia el menú del conversor de divisas.
     */
    private void menuConversor () {
        ConversorMoneda conversor = new ConversorMoneda(cuenta);
        conversor.iniciarMenu();
    }
}

