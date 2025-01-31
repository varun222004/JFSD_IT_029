import java.util.Scanner;
import java.util.InputMismatchException;

public class exceptioHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numerator = 10;

        try {
            System.out.print("Enter a divisor: ");
            int divisor = scanner.nextInt();
            int result = numerator / divisor;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid integer.");
        } finally {
            scanner.close();
        }
    }
}
