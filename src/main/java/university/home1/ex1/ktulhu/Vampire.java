package university.home1.ex1.ktulhu;

import java.util.HashSet;
import java.util.Set;

public class Vampire {

	public static void main(String[] args) {
		int result, iTemp1, iTemp2, jTemp1, jTemp2;
		StringBuilder iTemp1C = new StringBuilder(), 
				iTemp2C = new StringBuilder(), 
				jTemp2C = new StringBuilder(),
				jTemp1C = new StringBuilder();
		StringBuilder resultC = new StringBuilder();
		Set<Integer> resultSet = new HashSet<>();
		for (int i = 10; i < 100; i++) {
			iTemp2 = i % 10;
			iTemp1 = (i - iTemp2) / 10;
			iTemp1C.append(iTemp1);
			iTemp2C.append(iTemp2);
			for (int j = 10; j < 100; j++) {
				result = i * j;
				jTemp2 = j % 10;
				jTemp1 = (j - jTemp2) / 10;
				jTemp1C.append(jTemp1);
				jTemp2C.append(jTemp2);
				resultC.append(result);
				if ((resultC.indexOf(jTemp1C.toString()) != -1)) {
					resultC.deleteCharAt(resultC.indexOf(jTemp1C.toString()));
					if ((resultC.indexOf(jTemp2C.toString()) != -1)) {
						resultC.deleteCharAt(resultC.indexOf(jTemp2C.toString()));
						if ((resultC.indexOf(iTemp2C.toString()) != -1)) {
							resultC.deleteCharAt(resultC.indexOf(iTemp2C.toString()));
							if ((resultC.indexOf(iTemp1C.toString()) != -1)) {
								resultC.deleteCharAt(resultC.indexOf(iTemp1C.toString()));
								resultSet.add(result);
							}
						}
					}
				}
				jTemp1C.delete(0, 1);
				jTemp2C.delete(0, 1);
				resultC.delete(0, 4);
			}
			iTemp1C.delete(0, 1);
			iTemp2C.delete(0, 1);
		}
		for (Integer val : resultSet) {
			System.out.println(val);
		}
	}
}
