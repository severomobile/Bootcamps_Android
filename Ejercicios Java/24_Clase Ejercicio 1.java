import java.util.Scanner;

public class mathAlgo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int entero;

        System.out.println("ingrese un numero entero : ");

        entero = scanner.nextInt();

        int doble = entero * 2;

        int triple = entero * 3;

        double raiz = Math.sqrt(entero);

        double potencia = Math.pow(entero, 7);


        System.out.println("el doble es : " +doble);

        System.out.println("el triple es : " +triple);

        System.out.println("la raiz es : " +raiz);

        System.out.println("la potencia es : " +potencia);
    }
}
