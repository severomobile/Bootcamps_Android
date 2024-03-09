import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double resultado = 0;

        System.out.println("Menu de calculadora: ");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");

        System.out.println("Elija una operacion: ");
        int operacion = scanner.nextInt();

        switch (operacion) {
            case 1:
                System.out.println("Ingrese el primer numero: ");
                double num1 = scanner.nextInt();
                System.out.println("Ingrese el segundo numero: ");
                double num2 = scanner.nextInt();
                resultado = num1 + num2;
                System.out.println("El resultado de la suma es: "+resultado);
                break;

            case 2:
                System.out.println("Ingrese el primer numero: ");
                num1 = scanner.nextInt();
                System.out.println("Ingrese el segundo numero: ");
                num2 = scanner.nextInt();
                resultado = num1 - num2;
                System.out.println("El resultado de la resta es: "+resultado);
                break;

            case 3:
                System.out.println("Ingrese el primer numero: ");
                num1 = scanner.nextInt();
                System.out.println("Ingrese el segundo numero: ");
                num2 = scanner.nextInt();
                resultado = num1 * num2;
                System.out.println("El resultado de la multiplicacion es: "+resultado);
                break;

            case 4:
                System.out.println("Ingrese el primer numero: ");
                num1 = scanner.nextInt();
                System.out.println("Ingrese el segundo numero: ");
                num2 = scanner.nextInt();
                resultado = num1 / num2;
                System.out.println("El resultado de la division es: "+resultado);
                break;
        }
        scanner.close();
    }
}