public class SinCadenas {

    public static void main(String[] args) {

        String cad = "hola tu";

        int valorIndice = 0;

        int contarVocales = 0;

        System.out.println(cad.substring(3, 4));

        System.out.println(cad.substring(5, 6));

        System.out.println("Cantidad de vocales que tiene " + cad + " : ");

        for (int i = 0; i < cad.length(); i++) {

            char letra = cad.charAt(i);

            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {

                contarVocales +=1;
            }
        }
        System.out.println(contarVocales);
    }
}



