import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int suma = 0;

        System.out.print("Ingresar tamano N del vector: ");

        int sizeN = scanner.nextInt();

        int[] vector = new int[sizeN];

        System.out.println("Ingresar cada elemento del vector:");

        for (int i = 0; i < sizeN; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vector[i] = scanner.nextInt();

            suma += vector[i];
        }

        System.out.println("Elementos del vector:");

        for (int i = 0; i < sizeN; i++) {

            System.out.println("Vector[" + i + "] = " + vector[i]);
        }

        System.out.println("La suma de los elementos del vector es: " + suma);

        scanner.close();
    }
}
