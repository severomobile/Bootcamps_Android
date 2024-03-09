public class Main {
    public static void main(String[] args) {
        int suma = 0;
        String expresion = "";
        for (int i = 1; i <= 10; i++) {
            suma += i;
            expresion += (i == 1) ? "" : " + ";
            expresion += i;
            System.out.println("suma = " + expresion + " = " + suma);
        }
    }
}
