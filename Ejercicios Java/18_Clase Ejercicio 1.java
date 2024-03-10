import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("************************");
        System.out.println("Sumando");
        System.out.println("Ingrese el primer numero: ");
        int num1 = scanner.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        int num2 = scanner.nextInt();
        System.out.println("El resultado es: "+(num1 + num2));

        System.out.println("************************");
        System.out.println("Elever un numero");
        System.out.println("ingrese un numero");
        double num3 = scanner.nextInt();
        System.out.println("El resultado es: "+(Math.pow(num3, 2)));

        System.out.println("************************");
        System.out.println("Juntando palabras");
        System.out.println("Ingrese una palabra");
        String palabra = scanner.next();
        System.out.println("Ingrese otra palabra");
        String palabra2 = scanner.next();
        System.out.println("El resultado de junta palabras es: "+palabra+" "+palabra2);

        System.out.println("************************");
        System.out.println("Comparando");
        System.out.println("Ingrese el primer numero: ");
        int num4 = scanner.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        int num5 = scanner.nextInt();
        System.out.println("El resultado es: "+(num4 == num5));
    }
}