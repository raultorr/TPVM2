
public class Push extends ByteCode {

	private int param;

	/**
	 * Executes the push command
	 * 
	 * @param cpu
	 *            The actual cpu
	 */
	public boolean execute(CPU cpu) {
		return cpu.push(param);
	}

	public Push() {
	}

	/**
	 * One argument constructor of the push class
	 * 
	 * @param n
	 *            the position in the memory
	 */
	public Push(int n) {
		param = n;
	}

	/**
	 * Parses the string and checks if the command is the one of the class
	 * 
	 * @param s
	 *            Array of strings to be parsed
	 */
	public ByteCode parse(String[] s) {
		Push newCommand;
		if (s.length == 2 && s[0].equalsIgnoreCase("push")) {
			try {
				int aux = Integer.parseInt(s[1]);
				newCommand = new Push(aux);
				return newCommand;
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: push <number>");
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
		return "PUSH " + param;
	}
}
