import java.util.Scanner;
public class p5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        
        int numberOfDiv = 0;
        
        for(int i = 1; i <= a; i++) {
            if(a % i == 0)
                numberOfDiv++;
        }
        if(numberOfDiv == 2)
            System.out.println("Numarul este prim");
        else 
            System.out.println("Numarul nu este prim");
    }
}
