/**
 * This class encloses the sub operation
 */
public class Sub extends ArithmeticOps {

	/**
	 * Performs the operation
	 * 
	 * @param cpu
	 *            The actual cpu
	 */
	public boolean operation(CPU cpu) {
		boolean success = false;
		if (readyToOperate(cpu)) {
			success = true;
			int aux = cpu.takeValue();
			cpu.deleteValue();
			int aux2 = cpu.takeValue();
			cpu.deleteValue();
			int result = aux2 - aux;
			cpu.addValue(result);
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
		if (s.length == 1 && s[0].equalsIgnoreCase("sub")) {
			return new Sub();
		} else {
			return null;
		}
	}

	/**
	 * Regular translation of the object type to a String
	 */
	public String toString() {
		return "SUB ";
	}
}
