/**
 * This class encloses the Goto inconditional jump
 */
public class Goto extends ByteCode {

	private int param;

	/**
	 * Changes the program counter to the one of the param
	 * 
	 * @param cpu
	 *            The actual cpu
	 */
	public boolean execute(CPU cpu) {
		boolean success = false;
		if (param <= cpu.getProgramLength()) {
			cpu.setProgramCounter(param);
			success = true;
		}
		return success;
	}

	public Goto() {
	}

	/**
	 * One argument constructor of the Goto class
	 * 
	 * @param n
	 *            Represents the next instruction to be placed on the Program
	 *            Counter
	 */
	public Goto(int n) {
		param = n;
	}

	/**
	 * Parses the string and checks if the command is the one of the class
	 * 
	 * @param s
	 *            Array of strings to be parsed
	 */
	public ByteCode parse(String[] s) {
		Goto newCommand;
		if (s.length == 2 && s[0].equalsIgnoreCase("goto")) {
			try {
				int aux = Integer.parseInt(s[1]);
				newCommand = new Goto(aux);
				return newCommand;
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: Goto <number>");
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
		return "GOTO " + param;
	}
}
