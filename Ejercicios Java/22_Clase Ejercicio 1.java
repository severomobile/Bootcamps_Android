import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arreglo = new int[3];

        for (int i = 0; i < arreglo.length; i++) {

            System.out.println("ingrese un numero");
            arreglo[i] = scanner.nextInt();
        }

        int mayor = arreglo[0];

        for (int j : arreglo) {

            if (j > mayor) {
                mayor = j;
            }
        }

        System.out.println("El número mayor ingresado es: " + mayor);

        scanner.close();
    }
}