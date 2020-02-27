import java.util.Scanner;
import java.lang.Math;
public class p7{
 public static void main(String[] args)
 {
     Scanner input = new Scanner(System.in);
     int n = input.nextInt();
     int maxim = 0;
     for(int i = 2; i <= n; i++)
     {
         if(n % i == 0)
         {
             int ok = 1;
             for(int d = 2; d <= Math.sqrt(i);d ++)
             {
                 if(i % d == 0)
                    ok = 0;
                 
             }
             if(ok == 1)
             {
                 maxim = i;
             }
                
            }
           
 }
 System.out.print(maxim);
}
}
