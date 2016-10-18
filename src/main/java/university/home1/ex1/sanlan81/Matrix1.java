package university.home1.ex1.sanlan81;

class Matrix1 {
    public static void main(String[] args) {
        v1();
        v2();
    }

	private static void v1() {
		int mas[][] = new int[5][5];

        int  count = 1;

        for (int i = 0; i < mas.length; i++){
            for (int j = 0; j <= i ; j++){
                mas[j][i - j] = count++;
                print(mas);
            }
        }
        for (int j = 1; j < mas.length; j++){
            for (int k = 0; k <= 4 - j; k++){
                mas[4 - k][j + k] = count++;
                print(mas);
            }
        }

        print(mas);
	}
    
	private static void v2() {
		int mas[][] = new int[5][5];

        int  count = 1;

        for (int i = 0; i < mas.length; i++){
            for (int j = 0; j <= i ; j++){
                mas[j][i - j] = count++;
            }
        }
        for (int j = 1; j < mas.length; j++){
            for (int k = 0; k <= 4 - j; k++){
                mas[j + k][4 - k] = count++;
            }
        }
        
        print(mas);
	}

	private static void print(int[][] mas) {
		System.out.println();
		for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(mas[i][j] + "\t");
            }
            System.out.println();
        }
	}
}

