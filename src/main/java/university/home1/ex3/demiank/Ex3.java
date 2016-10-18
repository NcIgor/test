package university.home1.ex3.demiank;


public class Ex3 {
    public static void main(String[] args) {
        createTable(variantOne(6));
//        createTable(variantTwo(5));
//        createTable(variantThird(6));


    }

    private static int[][] createTable(int[][] view) {
        for (int i = 0; i < view.length; i++) {
            System.out.println();
            for (int j = 0; j < view.length; j++) {
                if (view[i][j] < 10) {
                    System.out.print(" " + view[i][j] + " ");
                } else {
                    System.out.print(view[i][j] + " ");
                }

            }
        }
        return view;
    }

    private static int[][] variantOne(int n) {
        int x = 0;
        int y = 0;
        int z = 1;
        int w = 0;
        int[][] variant = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    variant[i][j] = x;
                    x += 2;
                    w = variant[0][n - 1];
                }
                if (i == n - 1) {
                    variant[i][j] = y;
                    y += 2;

                } else {
                    if (j == 0) {
                        variant[i][0] = z;
                        z += 2;
                        y = variant[0][n - 1] + 1;
                    }
                    if (j == n - 1) {
                        variant[i][n - 1] = w;
                        w += 2;
                    }
                }
            }
        }
        variant[0][0] = 1;
        variant[n - 1][n - 1] = y - 3;
        return variant;

    }
    private static int[][] variantTwo(int n) {
        int z = n - 1;
        int square = (n * n) ;
        int inc = square ;
        int i = 0;
        int j = 0;
        int x = 0;
        int[][] variant = new int[n][n];
        while (inc > 1 ) {
            while (j < z) {
                variant[i][j] = inc--;
                j++;
            }
            while (i < z) {
                variant[i][j] = inc--;
                i++;
            }
            while (j > x) {
                variant[i][j] = inc--;
                j--;
            }
            z--;
            x++;
            while (i > x) {
                variant[i][j] = inc--;
                i--;
            }
        }
        variant[i][j] = inc ;
        return variant;
    }
    private static int[][] variantThird(int n) {
        int z = n - 1;
        int square = (n * n) ;
        int inc = 1;
        int i = 0;
        int j = 0;
        int x = 0;
        int[][] variant = new int[n][n];
        while (inc < square ) {
            while (j < z) {
                variant[i][j] = inc++;
                j++;
            }
            while (i < z) {
                variant[i][j] = inc++;
                i++;
            }
            while (j > x) {
                variant[i][j] = inc++;
                j--;
            }
            z--;
            x++;
            while (i > x) {
                variant[i][j] = inc++;
                i--;
            }
        }
        variant[i][j] = square ;
        return variant;
    }
}

