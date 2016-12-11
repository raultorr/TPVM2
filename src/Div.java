/**
 * This class encloses the div operation
 */

public class Div extends ArithmeticOps {

	/**
	 * Performs the operation
	 * 
	 * @param cpu
	 *            The actual cpu
	 */
	public boolean operation(CPU cpu) {
		boolean success = false;
		int result;
		if (readyToOperate(cpu)) {
			success = true;
			int aux = cpu.takeValue();
			cpu.deleteValue();
			int aux2 = cpu.takeValue();
			cpu.deleteValue();
			if (aux != 0) {
				result = aux2 / aux;
				cpu.addValue(result);
			} else {
				success = false;
			}

		}
		return success;
	}

	/**
	 * Calls operation
	 * 
	 * @param cpu
	 *            The actual cpu
	 */
	public boolean execute(CPU cpu) {
		return operation(cpu);
	}

	/**
	 * Parses the string and checks if the command is the one of the class
	 * 
	 * @param s
	 *            Array of strings to be parsed
	 */
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("div")) {
			return new Div();
		} else {
			return null;
		}
	}

	/**
	 * Overrides the general method to check if the second value is a 0
	 */
	public boolean readyToOperate(CPU cpu) {
		boolean valid = false;
		if (cpu.takeValue() != '0' && cpu.atLeastTwoNumsOnStack()) {
			valid = true;
		}
		return valid;
	}

	/**
	 * Regular translation of the object type to a String
	 */
	public String toString() {
		return "DIV ";
	}
}
