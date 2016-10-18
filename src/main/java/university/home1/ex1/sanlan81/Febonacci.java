package university.home1.ex1.sanlan81;
public class Febonacci {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        for (int i = 0; i < 10; i++) {
        	System.out.println(i);
            System.out.println(a + "  " );
            System.out.println(b  + "  " );

            a = a + b;
            b = b + a;
        }
    }
}