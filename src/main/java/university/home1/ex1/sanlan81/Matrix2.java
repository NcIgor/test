package university.home1.ex1.sanlan81;

class Matrix2 {
	public static void main(String args[]) {

		int mas[][] = new int[6][6];
		int matrix = 6 * 6, 
				x1 = 0, 
				x2 = 6 - 1, 
				y1 = 0, 
				y2 = 6 - 1;

		while (matrix >= 1) {
			for (int i = x1; i <= x2; i++) {
				mas[y1][i] = matrix--;
			}
			print(mas);

			for (int j = y1 + 1; j <= y2; j++) {
				mas[j][x2] = matrix--;
			}
			print(mas);

			for (int i = x2 - 1; i >= x1; i--) {
				mas[y2][i] = matrix--;
			}
			print(mas);

			for (int j = y2 - 1; j >= y1 + 1; j--) {
				mas[j][x1] = matrix--;
			}
			print(mas);

			x1++;
			x2--;
			y1++;
			y2--;
		}

		print(mas);
	}

	private static void print(int[][] mas) {
		System.out.println();
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				System.out.print(mas[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
