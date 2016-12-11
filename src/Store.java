/**
 * Encloses the store command
 */
public class Store extends ByteCode {

	private int param;

	/**
	 * Executes the store command
	 * 
	 * @param cpu
	 *            The actual cpu
	 */
	public boolean execute(CPU cpu) {
		return cpu.store(param);
	}

	public Store() {
	}

	/**
	 * One argument constructor of the store class
	 * 
	 * @param n
	 *            the position in the memory
	 */
	public Store(int n) {
		param = n;
	}

	/**
	 * Parses the string and checks if the command is the one of the class
	 * 
	 * @param s
	 *            Array of strings to be parsed
	 */
	public ByteCode parse(String[] s) {
		Store newCommand;
		if (s.length == 2 && s[0].equalsIgnoreCase("store")) {
			try {
				int aux = Integer.parseInt(s[1]);
				newCommand = new Store(aux);
				return newCommand;
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: store <number>");
			}
			return null;
		} else {
			return null;
		}
	}

	/**
	 * Regular translation of the object type to a String
	 */
	public String toString() {
		return "STORE " + param;
	}

}
