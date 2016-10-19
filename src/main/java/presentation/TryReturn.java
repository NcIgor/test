package presentation;

public class TryReturn {
	public static void main(String[] args) {
		System.out.println(method());
	}

	private static int method() {
		try {
			System.out.println("try");
			if(true)
				throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("catch");
			return -1;
		} finally {
			System.out.println("finally");
		}
		return 0;
	}
}
