import java.util.Scanner;
public class problema5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        if (x == 0) {
            System.out.print("0");
        } else {
            int fac = 1, i = 2;
            for (i = 2; i <= x; i++) {
                fac = fac * i;
            }
            System.out.print(fac);
        } 
    }
}
