/**
 * This class encloses the ifneq jump
 */

public class Ifneq extends JumpOps {

	public Ifneq() {
	}

	/**
	 * One argument constructor of the Ifneq class
	 * 
	 * @param n
	 *            Represents the next instruction to be placed on the Program
	 *            Counter if the condition is not meet
	 */
	public Ifneq(int n) {
		param = n;
	}

	/**
	 * Parses the string and checks if the command is the one of the class
	 * 
	 * @param s
	 *            Array of strings to be parsed
	 */
	public ByteCode parse(String[] s) {
		Ifneq newCommand;
		if (s.length == 2 && s[0].equalsIgnoreCase("ifneq")) {
			try {
				int aux = Integer.parseInt(s[1]);
				newCommand = new Ifneq(aux);
				return newCommand;
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: ifneq <number>");
			}
			return null;
		} else {
			return null;
		}
	}

	/**
	 * Performs the comparison between the top-2 values of the stack
	 */
	public boolean compare(CPU cpu) {
		boolean condition = false;

		int aux = cpu.takeValue();
		cpu.deleteValue();
		int aux2 = cpu.takeValue();
		cpu.deleteValue();
		if (aux != aux2) {
			condition = true;
		}
		return condition;
	}

	/**
	 * Regular translation of the object type to a String
	 */
	public String toString() {
		return "IFNEQ " + param;
	}
}
