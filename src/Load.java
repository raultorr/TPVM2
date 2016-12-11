/**
 * Encloses the load command
 */
public class Load extends ByteCode {

	private int param;

	/**
	 * Executes the load command
	 * 
	 * @param cpu
	 *            The actual cpu
	 */
	public boolean execute(CPU cpu) {
		return cpu.load(param);
	}

	public Load() {
	}

	/**
	 * One argument constructor of the load class
	 * 
	 * @param n
	 *            the position in the memory
	 */
	public Load(int n) {
		param = n;
	}

	@Override
	public ByteCode parse(String[] s) {
		Load newCommand;
		if (s.length == 2 && s[0].equalsIgnoreCase("load")) {
			try {
				int aux = Integer.parseInt(s[1]);
				newCommand = new Load(aux);
				return newCommand;
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: load <number>");
			}
			return null;
		} else {
			return null;
		}
	}

	public String toString() {
		return "LOAD " + param;
	}

}
