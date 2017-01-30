package autoclosable;

public class Turkey {

	public static void main(String[] args) {
		/*try (*/Turkey t = new Turkey();/*)*/ { // DOES NOT COMPILE
			System.out.println(t);
		}
	}

}
