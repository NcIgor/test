package university.home1.ex1.sanlan81;
import java.util.Arrays;


public class VampireNumber {

    public static void main(String[] args) {

        for (int i = 10; i < 100; i++) {
            for (int j = i; j < 100; j++) {

                String result = i * j + "";

                char l[] = result.toCharArray();
                Arrays.sort(l);

                String z = i + (j + "");

                char m[] = z.toCharArray();
                Arrays.sort(m);

                if (Arrays.equals(l, m)) {
                    System.out.println(result + " = " + "" + i + " * " + j);

                }
            }
        }
    }
}
