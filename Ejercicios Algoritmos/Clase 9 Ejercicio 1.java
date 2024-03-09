import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int partidoGanado;
        int partidoEmpatado;
        int partidoPerdido;

        int puntosGanado = 3;
        int puntosEmpatado = 1;
        int puntosPerdido = 0;

        System.out.println("Ingrese la cantidad de partidos ganados: ");
        partidoGanado = scanner.nextInt();
        System.out.println("Los partidos ganados son: "+partidoGanado);
        int resultadoGanado = partidoGanado * puntosGanado;
        System.out.println("El puntaje de los partidos ganados es de: "+resultadoGanado);

        System.out.println("**************************************************************");
        System.out.println("Ingrese la cantidad de partidos empatados: ");
        partidoEmpatado = scanner.nextInt();
        System.out.println("Los partidos empatados son: "+partidoEmpatado);
        int resultadoEmpatado = partidoEmpatado * puntosEmpatado;
        System.out.println("El puntaje de los partidos empatados es de: "+resultadoEmpatado);

        System.out.println("**************************************************************");
        System.out.println("Ingrese la cantidad de partidos perdidos: ");
        partidoPerdido = scanner.nextInt();
        System.out.println("Los partidos perdidos son: "+partidoPerdido);
        System.out.println("El puntaje de los partidos perdidos es de: "+puntosPerdido);

        System.out.println("**************************************************************");
        int puntajeTotal = resultadoGanado + resultadoEmpatado;
        System.out.println("El puntaje total de los partidos es de: "+puntajeTotal);
    }
}