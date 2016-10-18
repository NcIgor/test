package university.home1.ex1.shurman;
import java.io.IOException;

/**
 * Created by ash on 10/7/2016.
 */
public class FibonacciNumbers {
    //рекурсивное вычилсение n-го числа в ряде Фибоначчи
    private static int fibonacci(int n){
        if(n == 0 || n == 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) throws IOException {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        for(i = 1; i <= 46; i++) {
        	long currentTimeMillis1 = System.currentTimeMillis();
            System.out.print(i+" = "+fibonacci(i));
            System.out.print("  ---  ");
            System.out.println(System.currentTimeMillis() - currentTimeMillis1);
        }
        
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }
}