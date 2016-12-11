/**
 * Encloses the reset command
 */
public class Reset extends Command {

	/**
	 * Resets the program, cpu, stack and the memory
	 * 
	 * @param cpu
	 *            The actual cpu
	 */
	public boolean execute(Engine engine) {
		return engine.executeReset();
	}

	/**
	 * Parses the string and checks if the command is the one of the class
	 * 
	 * @param s
	 *            Array of strings to be parsed
	 */
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("RESET")) {
			return new Reset();
		} else {
			return null;
		}
	}

	/**
	 * Generates a single string with the help of this command
	 */
	public String textHelp() {
		return "RESET: Delete the current program " + System.getProperty("line.separator");
	}

	/**
	 * Regular translation of the object type to a String
	 */
	public String toString() {
		return "RESET ";
	}
}
