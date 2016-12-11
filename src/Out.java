/**
 * Encloses the out command
 */
public class Out extends ByteCode {
	/**
	 * Executes the out command
	 * 
	 * @param cpu
	 *            The actual cpu
	 */
	public boolean execute(CPU cpu) {
		System.out.println(cpu.out());
		return true;
	}

	/**
	 * Parses the string and checks if the command is the one of the class
	 * 
	 * @param s
	 *            Array of strings to be parsed
	 */
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("out")) {
			return new Out();
		} else {
			return null;
		}
	}

	/**
	 * Regular translation of the object type to a String
	 */
	public String toString() {
		return "OUT ";
	}
}
