public   class Main {
    public static void main(String[] args) {

        int cuenta = 1;

        while (cuenta <= 10) {
            System.out.println(cuenta);
            cuenta++;
        }

        System.out.println("**********************");

        int cuenta2 = 1;

        do {
            System.out.println(cuenta2);
            cuenta2++;

        }while (cuenta2 <= 10);

        System.out.println("**********************");

        for (int i = 0; i <= 10 ; i++) {

            System.out.println(i);
        }
    }
}