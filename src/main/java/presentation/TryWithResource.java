package presentation;

public class TryWithResource {
	public static void main(String[] args) throws Exception {
		assert false : 3;
		try{ 
			try(A a = new A(); 
					B b = new B()){
				System.out.println();
				throw new RuntimeException("Inner error");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Throwable[] suppressed = e.getSuppressed();
			if (suppressed != null){
				for (Throwable throwable : suppressed) {
					System.out.println("Suppressed: "
							+ throwable.getMessage());
				}
			}
		}
	}
	
	static class A implements AutoCloseable {

		@Override
		public void close() throws Exception {
			System.out.println("Try to close resoure A");
			throw new RuntimeException("A");
		}
		
	}

	static class B implements AutoCloseable {
		
		@Override
		public void close() throws Exception {
			System.out.println("Try to close resoure B");
			throw new RuntimeException("B");
		}
		
	}
}
