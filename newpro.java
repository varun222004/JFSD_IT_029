import java.util.Scanner;

public class newpro {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
   
        for (int j = 0; j < 100; j++) {
            if ((j % 3) == 0 && (j % 5) == 0) {
                System.out.println(j); // Print j instead of i
            }
        }
    }
}
