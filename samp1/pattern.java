import java.util.Scanner;

public class pattern {
    public static void main(String[] args) {
        try (@SuppressWarnings("unused")
Scanner in = new Scanner(System.in)) { // Use try-with-resources to ensure closure
            int i, j;
            for (i = 0; i < 5; i++) {  // Outer loop for rows
                for (j = 5; j > 0; j--) {  // Inner loop for columns
                    System.out.print("x");  // Print "x" on the same line
                }
                System.out.println();  // Move to the next line after each row
            }
        }
    }
}
