/**
 * Encloses the help command
 */
public class Help extends Command {

	/**
	 * Executes the help command
	 * 
	 * @param engine
	 *            The actual engine
	 */
	public boolean execute(Engine engine) {
		return engine.executeHelp();
	}

	/**
	 * Parses the string and checks if the command is the one of the class
	 * 
	 * @param s
	 *            Array of strings to be parsed
	 */
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Help")) {
			return new Help();
		} else {
			return null;
		}
	}

	/**
	 * Generates a single string with the help of this command
	 */
	public String textHelp() {
		return "\nHELP: Show this help " + System.getProperty("line.separator");
	}

	/**
	 * Regular translation of the object type to a String
	 */
	public String toString() {
		return "HELP ";
	}
}
