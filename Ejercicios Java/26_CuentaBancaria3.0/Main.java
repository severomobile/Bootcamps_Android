import cl.Billetera.clases.Cuenta;
import cl.Billetera.clases.Operaciones;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Cuenta cuentaCorriente = new Cuenta();

        System.out.println("Ingrese el número de cuenta:");
        int numeroCuenta = scanner.nextInt();
        cuentaCorriente.setNumeroCuenta(numeroCuenta);

        System.out.println("Ingrese el nombre del titular de cuenta:");
        String titularCuenta = scanner.next();
        cuentaCorriente.setTitularCuenta(titularCuenta);

        cuentaCorriente.mostrarInformacionCuentaCorriente();

        System.out.println("Ingrese la cantidad que desea depositar:");

        double cantidadDeposito = scanner.nextDouble();

        Operaciones operaciones = new Operaciones();
        operaciones.depositar(cuentaCorriente, cantidadDeposito);

        cuentaCorriente.mostrarInformacionCuentaCorriente();
    }
}

