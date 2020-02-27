import java.util.Scanner;
public class p2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input Data:");
        System.out.print("Input first integer: ");
        int a = input.nextInt();
        
        System.out.print("Input second integer: ");
        int b = input.nextInt();
        
        System.out.println("Expected output: ");
        if(a < b)
            System.out.println(a + " < " + b);
        if(a > b)
            System.out.println(a + " > " + b);
        if(a == b) 
            System.out.println(a + " == " + b);
        if(a != b)
            System.out.println(a + " != " + b);
        if(a <= b)
            System.out.println(a + " <= " + b);
        if(a >= b)
            System.out.println(a + " < " + b);      
        
    }
}
