package etc_MAR.book;

class page130_GenericClassTester {
	static class GenericClass<T>{
		private T xyz;

		GenericClass(T t) {
			this.xyz = t;
		}
		
		T getXyz() {
			return xyz;
		}
	}
	
	public static void main(String[] args) {
		GenericClass<String> gs = new GenericClass<String>("ABC");
		GenericClass<Integer> gi = new GenericClass<Integer>(15);
		
		System.out.println(gs.getXyz());
		System.out.println(gi.getXyz());
	}
}
