import Clases.Cafetera;

public class Main {
    public static void main(String[] args) {

        // Crear una instancia de la cafetera
        Cafetera miCafetera = new Cafetera();

        // Establecer la capacidad máxima y actual de la cafetera
        miCafetera.setCapacidadMaxima(1000); // Supongamos una capacidad máxima de 1000 ml
        miCafetera.setCapacidadActual(500); // Supongamos una capacidad actual de 500 ml

        // Mostrar la capacidad máxima y actual de la cafetera
        System.out.println("Capacidad máxima de la cafetera: " + miCafetera.getCapacidadMaxima() + " ml");
        System.out.println("Capacidad actual de la cafetera: " + miCafetera.getCapacidadActual() + " ml");

        // Llenar la cafetera
        miCafetera.llenarCafetera();
        System.out.println("Capacidad actual después de llenar la cafetera: " + miCafetera.getCapacidadActual() + " ml");

        // Servir una taza de café
        miCafetera.servirTaza(200); // Supongamos una taza de 200 ml
        System.out.println("Capacidad actual después de servir una taza: " + miCafetera.getCapacidadActual() + " ml");

        // Vaciar la cafetera
        miCafetera.vaciarCafetera();
        System.out.println("Capacidad actual después de vaciar la cafetera: " + miCafetera.getCapacidadActual() + " ml");

        // Agregar café a la cafetera
        miCafetera.agregarCafe(300); // Supongamos agregar 300 ml de café
        System.out.println("Capacidad actual después de agregar café: " + miCafetera.getCapacidadActual() + " ml");
    }
}
