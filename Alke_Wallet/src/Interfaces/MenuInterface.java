package Interfaces;

/**
 * La interfaz MenuInterface define los métodos necesarios para gestionar un menú interactivo.
 * Estos métodos incluyen iniciar el menú, mostrar las opciones disponibles, seleccionar una opción
 * y ejecutar la acción correspondiente a la selección.
 */
public interface MenuInterface {

    /**
     * Inicia el menú interactivo.
     */
    void iniciarMenu();

    /**
     * Muestra las opciones disponibles en el menú.
     */
    void mostrarMenu();

    /**
     * Selecciona una opción del menú.
     *
     * @param seleccion El número de la opción seleccionada.
     */
    void seleccionMenu(int seleccion);

    /**
     * Ejecuta la acción correspondiente a la opción seleccionada.
     *
     * @param seleccion El número de la opción seleccionada.
     */
    void ejecutarSeleccion(int seleccion);
}
