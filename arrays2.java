import java.util.Scanner;
public class arrays2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] a = new int[5][5];
        for(int i=0;i<5;i++){
            for(int j=0; j<5;j++){
                System.out.println("Enter the "+i+"th value");
                a[i][j] = in.nextInt();

            }
            

        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.println(a[i][j]);
            }
        }
    }
}
