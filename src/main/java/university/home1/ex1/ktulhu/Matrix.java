package university.home1.ex1.ktulhu;

public class Matrix {
	public static void main(String[] args) {
		System.out.println("first matrix:");
		case1(5);
		System.out.println("second matrix:");
		case2(6);
		System.out.println("third matrix:");
		case3(7);
	}

	private static void case1(int size) {
		int tempVal = 1;
		int matrix[][] = new int[size][size];
		int jCurent = 1, iCurent = 0, i, j;
		matrix[0][0] = tempVal++;
		while (tempVal != size * size) {
			j = jCurent;
			for (i = iCurent; i < size; i++) {
				if (matrix[i][j] == 0)
					matrix[i][j] = tempVal++;
				if (j == 0)
					break;
				j--;
			}
			if (i == size - 1)
				break;
			jCurent++;
		}
		iCurent = 1;
		jCurent = size - 1;
		while (tempVal != size * size) {
			i = iCurent;
			for (j = jCurent; j < size; j--) {
				if (matrix[i][j] == 0)
					matrix[i][j] = tempVal++;
				if (i == size - 1)
					break;
				i++;
			}
			if (i == size - 1 && j == size - 2)
				break;
			iCurent++;
		}
		matrix[size - 1][size - 1] = tempVal;
		printMatrix(matrix);
	}

	private static void case2(int size) {
		int tempVal = 1;
		int matrix[][] = new int[size][size];
		int iCentr;
		int jCentr;
		if (size % 2 == 0) {
			iCentr = size / 2;
			jCentr = size / 2 - 1;
		} else {
			iCentr = size / 2;
			jCentr = size / 2;
		}

		int j = 0;
		int i = 0;
		int jCurent = 0;
		int iCurent = 0;
		matrix[iCentr][jCentr] = tempVal;
		tempVal++;
		matrix[iCentr][jCentr + 1] = tempVal;
		tempVal++;
		jCurent = jCentr + 1;
		iCurent = iCentr;

		while (tempVal != (size * size) + 1) {

			for (i = iCurent; i < size; i--) {
				if (matrix[i][jCurent] == 0)
					matrix[i][jCurent] = tempVal++;
				if (iCurent == 0)
					break;
				if (jCurent == 0 || jCurent + 1 == size || iCurent == 0 || iCurent + 1 == size) {
				} else {
					if (matrix[iCurent][jCurent - 1] == 0 && matrix[iCurent][jCurent + 1] == 0
							&& matrix[iCurent - 1][jCurent] == 0) {
						break;
					}
				}
				iCurent--;
			}

			for (j = jCurent; j < size; j--) {
				if (matrix[iCurent][jCurent] == 0)
					matrix[iCurent][jCurent] = tempVal++;
				if (jCurent == 0)
					break;
				if (jCurent == 0 || jCurent + 1 == size || iCurent == 0 || iCurent + 1 == size) {
				} else {
					if (matrix[iCurent + 1][jCurent] == 0 && matrix[iCurent - 1][jCurent] == 0
							&& matrix[iCurent][jCurent - 1] == 0) {
						break;
					}
				}
				jCurent--;
			}
			for (i = iCurent; i < size; i++) {
				if (matrix[i][jCurent] == 0)
					matrix[i][jCurent] = tempVal++;
				if (iCurent + 1 == size)
					break;
				if (jCurent == 0 || jCurent + 1 == size || iCurent == 0 || iCurent + 1 == size) {
				} else {
					if (matrix[iCurent + 1][jCurent] == 0 && matrix[iCurent][jCurent + 1] == 0
							&& matrix[iCurent][jCurent - 1] == 0) {
						break;
					}
				}
				iCurent++;
			}

			for (j = jCurent; j < size; j++) {
				if (matrix[iCurent][jCurent] == 0)
					matrix[iCurent][jCurent] = tempVal++;
				if (jCurent + 1 == size)
					break;
				if (jCurent == 0 || jCurent + 1 == size || iCurent == 0 || iCurent + 1 == size) {
				} else {
					if (matrix[iCurent + 1][jCurent] == 0 && matrix[iCurent - 1][jCurent] == 0
							&& matrix[iCurent][jCurent + 1] == 0) {
						break;
					}
				}
				jCurent++;
			}
		}

		printMatrix(matrix);
	}

	private static void case3(int size) {
		int tempVal = 1;
		int matrix[][] = new int[size][size];
		int jI = 0;
		int iJ = 0;
		int jSec = -1;
		int iSec = size;
		int iFir = -1;
		int jFir = size;
		while (tempVal != (size * size) + 1) {
			iFir++;
			for (jI = 0; jI < size; jI++) {
				if (matrix[iFir][jI] == 0)
					matrix[iFir][jI] = tempVal++;
			}

			jFir--;
			for (iJ = 0; iJ < size; iJ++) {
				if (matrix[iJ][jFir] == 0)
					matrix[iJ][jFir] = tempVal++;
			}

			iSec--;
			for (jI = size - 1; jI >= 0; jI--) {
				if (matrix[iSec][jI] == 0)
					matrix[iSec][jI] = tempVal++;
			}
			jSec++;
			for (iJ = size - 1; iJ >= 0; iJ--) {
				if (matrix[iJ][jSec] == 0)
					matrix[iJ][jSec] = tempVal++;
			}
		}
		printMatrix(matrix);
	}

	private static void printMatrix(int[][] matrix) {
		for (int q = 0; q < matrix.length; q++) {
			for (int w = 0; w < matrix.length; w++) {
				System.out.print(matrix[q][w] + "\t");
			}
			System.out.println("");
		}
	}
}