package university.home1.ex1.shurman;
/**
 * Created by ash on 10/7/2016.
 */

public class matrixFilling {

    private static final int N = 14;

    private static void diagonalFilling(int[][] array){
        int i;
        int j;
        int count = 0;

        // заполнение массива выше главноей диагонали (включительно)
        for (i = 0; i < N; i++){
            for (j = i; j > -1; j--){
                array[i - j][j] = ++count;
            }
        }

        // заполнение массива ниже главной диагонали
        for (i = 0; i < N; i++){
            for (j = N - 1; j > i; j--){
                array[N + i - j][j] = ++count;
            }
        }
    }



    private static void spiralFilling(int[][] array){
        int count = 1;
        int j;
        int i;
        int p = N / 2;

        //÷икл по номеру витка
        for(i = 1; i <= p; i++){
            // значени€ верхнего горизонтального столбца (двигаемс€ вправо)
            for (j = i - 1; j < N - i + 1; j++){
                array[i - 1][j] = count++;
            }
            // значени€ правого вертикального столбца (двигаемс€ вниз)
            for (j = i; j < N - i + 1; j++){
                array[j][N - i] = count++;
            }
            // значени€ нижнего горизонтального столбца (двигаемс€ влево)
            for (j = N - i - 1; j >= i - 1; --j){
                array[N - i][j] = count++;
            }
            // значени€ левого вертикального столбца (двигаемс€ вверх)
            for (j = N - i - 1; j >= i; j--){
                array[j][i - 1] = count++;
            }
        }
    }

    private static void centralSpiralFilling(int[][] array){

        // середина матрицы
        int i = N / 2;
        int j = N / 2;

        // границы движени€
        int minimalI = i;
        int maximalI = i; // горизонталь
        int minimalJ = j;
        int maximalJ = j; // вертикаль

        int d = 0; // двигаемс€ влево
        for (int k = 1; k <= N * N; k++) {
            array[i][j] = k;
            switch (d) {
                case 0:
                    i--;
                    if (i < minimalI) { // проверка выхода за заполненную центральную часть слева
                        d = 1; // смена направление
                        minimalI = i; // увеличиваем заполненную часть влево
                    }
                    break;
                case 1:  // двигаемс€ вверх, проверка сверху
                    j--;
                    if (j < minimalJ) {
                        d = 2;
                        minimalJ = j;
                    }
                    break;
                case 2:  // двигаемс€ вправо, проверка справа
                    i++;
                    if (i > maximalI) {
                        d = 3;
                        maximalI = i;
                    }
                    break;
                case 3:  // двигаемс€ вниз, проверка снизу
                    j++;
                    if (j > maximalJ) {
                        d = 0;
                        maximalJ = j;
                    }
            }
        }
    }



    public static void main(String[] args) {
        int i;
        int j;
        int[][] A = new int[N][N];
        int[][] B = new int[N][N];
        int[][] C = new int[N][N];

        diagonalFilling(A);
        spiralFilling(B);
        centralSpiralFilling(C);

        for(i = 0; i < N; i++){
            for(j = 0; j < N; j++)
                System.out.print("\t"+A[i][j]);
            System.out.print("\n");
        }

        System.out.print("\n");

        for(i = 0; i < N; i++){
            for(j = 0; j < N; j++)
                System.out.print("\t"+B[i][j]);
            System.out.print("\n");
        }

        System.out.print("\n");

        for(i = 0; i < N; i++){
            for(j = 0; j < N; j++)
                System.out.print("\t"+C[i][j]);
            System.out.print("\n");
        }
    }
}