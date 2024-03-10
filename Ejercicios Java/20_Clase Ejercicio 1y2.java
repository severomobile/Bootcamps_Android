public class Main {
    public static void main(String[] args) {

        int [] numbers = new int[13];

        for (int i = 0; i < 13; i++) {
            numbers [i] = i;

            switch (numbers[i]) {

                case 1:
                    System.out.println("enero");
                    break;

                case 2:
                    System.out.println("febrero");
                    break;

                case 3:
                    if (numbers[i] == 3) {
                        System.out.println("*****marzo es primavera*****");
                        break;
                    }

                case 4:
                    System.out.println("abril");
                    break;

                case 5:
                    System.out.println("mayo");
                    break;

                case 6:
                    if (numbers[i] == 6){
                        System.out.println("*****junio es invierno*****");
                        break;
                    }

                case 7:
                    System.out.println("julio");
                    break;

                case 8:
                    System.out.println("agosto");
                    break;

                case 9:
                    System.out.println("septiembre");
                    break;

                case 10:
                    System.out.println("octubre");
                    break;

                case 11:
                    System.out.println("noviembre");
                    break;

                case 12:
                    if (numbers[i] == 12) {
                        System.out.println("*****diciembre es verano*****");
                        break;
                    }
            }
        }

        System.out.println("--------------------------------");
        System.out.println("--------------------------------");

        System.out.println("Numeros a evaluar si son positivos, 0, par o impar");

        for (int item : numbers) {
            System.out.println(item);
        }
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        for (int item : numbers) {
            if (item == 0) {

                System.out.println("ingrese un numero distinto a 0");

            } else if (item % 2 == 0 & item > 0) {

                System.out.println("Es par y positivo");

            } else if (item > 0) {
                System.out.println("Es impar y positivo");
            }
        }
    }
}