import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        double num1 = scanner.nextDouble();

        System.out.println("Enter the second number:");
        double num2 = scanner.nextDouble();

        Operations operations = new Operations();

        System.out.println("Select the operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("The result of the add is: " + operations.add(num1, num2));
                break;
            case 2:
                System.out.println("The result of the subtract is: " + operations.subtract(num1, num2));
                break;
            case 3:
                System.out.println("The result of the multiply is: " + operations.multiply(num1, num2));
                break;
            case 4:
                System.out.println("The result of the divide is: " + operations.divide(num1, num2));
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}

class Operations {
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Can't be divided by zero.");
        }
        return num1 / num2;
    }
}