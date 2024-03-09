import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su edad: ");

        int edadUsuario = scanner.nextInt();

        if (edadUsuario >= 18) {
            System.out.println("Usted es mayor de edad");
        }else {
            System.out.println("Usted es menor de edad");
        }
    }
}