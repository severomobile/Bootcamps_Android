import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su edad: ");

        int edadUsuario = scanner.nextInt();

        System.out.println("Ingrese su peso: ");

        int pesoUsuario = scanner.nextInt();

        if (edadUsuario >= 18 && edadUsuario < 65 && pesoUsuario >= 50) {
            System.out.println("Puede donar");
        } else {
            System.out.println("No puede donar");
        }
    }
}