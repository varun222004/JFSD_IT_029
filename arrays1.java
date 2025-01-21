import java.util.Scanner;
public class arrays1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[5];
        System.out.println("Enter the elements in array");
        for(int i=0; i<5; i++){
            a[i]= in.nextInt();
            System.out.println(a[i]);
        }
        
    }
}
