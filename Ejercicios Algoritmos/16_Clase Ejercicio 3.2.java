public class Main {
    public static void main(String[] args) {

        int[] arreglo = {1, 2, 3, 4, 5};

        mostrarArreglo(arreglo);
    }
    public static void mostrarArreglo(int[] arreglo) {

        System.out.println("Valores del arreglo:");

        for (int i = 0; i < arreglo.length; i++) {

            System.out.println(arreglo[i]);
        }
    }

}
