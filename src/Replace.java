/**
 * Encloses the replace command
 */
public class Replace extends Command {
	private int replace;

	/**
	 * Executes the replace command
	 * 
	 * @param cpu
	 *            The actual cpu
	 */
	public boolean execute(Engine engine) {
		return engine.executeReplace(replace);
	}

	public Replace() {
	}

	/**
	 * One argument constructor of the replace class
	 * 
	 * @param n
	 *            The command identifier
	 */
	public Replace(int n) {
		replace = n;
	}

	/**
	 * Parses the string and checks if the command is the one of the class
	 * 
	 * @param s
	 *            Array of strings to be parsed
	 */
	public Command parse(String[] s) {
		Replace newCommand;
		if (s.length == 2 && s[0].equalsIgnoreCase("replace")) {
			try {
				int aux = Integer.parseInt(s[1]);
				newCommand = new Replace(aux);
				return newCommand;
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: replace <number>");
			}
			return null;
		} else {
			return null;
		}
	}

	/**
	 * Generates a single string with the help of this command
	 */
	public String textHelp() {
		return "REPLACE N: Replace insruction no. N with an instruction to be provided"
				+ System.getProperty("line.separator");
	}

	/**
	 * Regular translation of the object type to a String
	 */
	public String toString() {
		return "Replace" + replace;
	}

	/**
	 * Provides the value of the replace attribute
	 * 
	 * @return the actual value inside the replace attribute
	 */
	public int getReplace() {
		return replace;
	}
}
