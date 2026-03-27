import java.util.Scanner;

public class exercise225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        String strNum1 = sc.nextLine();

        System.out.print("Enter second number: ");
        String strNum2 = sc.nextLine();

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        System.out.println("Sum: " + (num1 + num2));
        System.out.println("Difference: " + (num1 - num2));
        System.out.println("Product: " + (num1 * num2));

        if (num2 != 0) {
            System.out.println("Quotient: " + (num1 / num2));
        } else {
            System.out.println("Cannot divide by zero.");
        }

        sc.close();
    }
}
