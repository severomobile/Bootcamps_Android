package Clases;

import Interfaces.MenuInterface;
import java.util.Scanner;

/**
 * La clase Login implementa la interfaz MenuInterface con métodos para iniciar sesión y registrarse.
 */
public class Login implements MenuInterface {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Constructor de la clase Login.
     */
    public Login() {
    }

    /**
     * Inicia el menú.
     */
    @Override
    public void iniciarMenu() {
        int seleccion;
        mostrarMenu();
        seleccion = scanner.nextInt();
        seleccionMenu(seleccion);
    }

    /**
     * Muestra las opciones disponibles en el menú.
     */
    @Override
    public void mostrarMenu() {
        System.out.println("Menu de Inicio de Sesión");
        System.out.println("1. Iniciar Sesión");
        System.out.println("2. Registrarse");
        System.out.print("Ingrese el número de la opción que desea realizar: ");
    }

    /**
     * Selecciona una opción del menú.
     *
     * @param seleccion El número de la opción seleccionada.
     */
    @Override
    public void seleccionMenu(int seleccion) {
        ejecutarSeleccion(seleccion);
    }

    /**
     * Ejecuta la acción correspondiente a la opción seleccionada.
     *
     * @param seleccion El número de la opción seleccionada.
     */
    @Override
    public void ejecutarSeleccion(int seleccion) {
        switch (seleccion) {
            case 1:
                iniciarSesion();
                break;
            case 2:
                registrarUsuario();
                break;
            default:
                System.out.println("Opción no válida, por favor intente de nuevo.");
        }
    }

    /**
     * Simula la acción de iniciar sesión.
     */
    private void iniciarSesion() {
        System.out.println("Estoy trabajando en esto ...");
    }

    /**
     * Simula la acción de registrar un nuevo usuario.
     */
    private void registrarUsuario() {
        String nombre;
        System.out.println("Ingrese su nombre de usuario: ");
        nombre = scanner.next();

        String email;
        System.out.println("Ingrese su email: ");
        email = scanner.next();

        String contrasena;
        System.out.println("Ingrese su contraseña: ");
        contrasena = scanner.next();

        // Crear nueva cuenta
        Cuenta cuentaNueva = new Cuenta();

        // Crear un nuevo menú asociado a la cuenta
        Menu nuevoMenu = new Menu(cuentaNueva);

        // Iniciar el menú para que el usuario interactúe con la billetera electrónica
        nuevoMenu.iniciarMenu();
    }

    /**
     * Método estático para invocar un objeto Login y comenzar el proceso de inicio de sesión.
     */
    public static void invocarObjetoLogin() {
        Login loginNuevo = new Login();
        loginNuevo.iniciarMenu();
    }
}

