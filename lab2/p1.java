import java.util.Scanner;
public class p1 {
    public static void main(String[] args) {
        int []myArray = new int[20];
        Scanner input = new Scanner(System.in);
        int i = 0;
        double sum = 0;
        while (i < 20) {
            int value = input.nextInt();
            if (value == -1) {
                break;
            } else {
                myArray[i] = value;
                sum += value;
            }
            i++;
        }
        System.out.println("The average of the grades is: " + sum / i);
    }
}
