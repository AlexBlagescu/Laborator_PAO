import java.util.Scanner;
public class p3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int sum = 0;
        
        for(int i = 3; i <= a; i++)
            if(i % 3 == 0 || i % 5 == 0)
                sum += i;
                
        System.out.println("Sum = " + sum);
    }
}
