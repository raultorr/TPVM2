
public class Halt extends ByteCode {

	/**
	 * Executes the halt instruction
	 * 
	 * @param cpu
	 *            The actual cpu
	 */
	public boolean execute(CPU cpu) {
		return cpu.halt();
	}

	/**
	 * Parses the string and checks if the command is the one of the class
	 * 
	 * @param s
	 *            Array of strings to be parsed
	 */
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("halt")) {
			return new Halt();
		} else {
			return null;
		}
	}

	/**
	 * Regular translation of the object type to a String
	 */
	public String toString() {
		return "HALT ";
	}
}
