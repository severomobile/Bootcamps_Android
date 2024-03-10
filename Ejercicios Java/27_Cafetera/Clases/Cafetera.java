package Clases;

import java.util.Scanner;

public class Cafetera {

    // 1. Atributos de clase
    private int capacidadMaxima; // Cantidad maxima que puede contener la cafetera
    private int capacidadActual; // Cantidad actual en la cafetera

    // 2. Constructor
    public Cafetera() {
    }

    public Cafetera(int capacidadMaxima, int capacidadActual) {
    }

    // 3. Metodos de acceso
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    // 4. Metodos de comportamiento
    public void llenarCafetera () {
        while (capacidadActual < capacidadMaxima) {
            capacidadActual ++;
        }
    }

    public void servirTaza (int sizeTaza) {

        if (capacidadActual >= sizeTaza) {

            capacidadActual -= sizeTaza;

            System.out.println("Se lleno la taza");

        } else {

            int falta = sizeTaza - capacidadActual;

            System.out.println(
                    "Falto de cafe: " + falta + " para llenar la taza.");
        }

    }

    public void vaciarCafetera () {
        capacidadActual = 0;
    }

    public void agregarCafe( int cantidadAgregar) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Agrega un cantidad de cafe a la cafetera:");
        cantidadAgregar = scanner.nextInt();
        capacidadActual += cantidadAgregar;
    }
}