package university.home1.ex1.ktulhu;


import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operatedNumber = scanner.nextInt();
        int next = 1;
        int prev = 0;
        int temp;

        if (operatedNumber == 0) {
            System.out.println("Enter another number");
        } else {
            System.out.print(" 1");
            for (int i = 1; i < operatedNumber; i++) {
                temp = next;
                next = prev + next;
                prev = temp;
                System.out.print(" " + next);
            }
        }
    }
}