import java.util.Scanner;
public class P6 {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int fib1= 1, fib2= 1;
        int aux = 2;
        if (x == 1 || x == 2) {
            System.out.println("1");
        }
        else {
            x = x - 2;
            while (x > 0) {
                aux = fib1 + fib2;
                fib1 = fib2;
                fib2 = aux;
                x--;
            }
            System.out.println(aux);
        }
    }
}
