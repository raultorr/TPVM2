/**
 * Encloses the quit command
 */
public class Quit extends Command {

	/**
	 * Stops the application
	 * 
	 * @param cpu
	 *            The actual cpu
	 */
	public boolean execute(Engine engine) {
		return engine.executeQuit();
	}

	/**
	 * Parses the string and checks if the command is the one of the class
	 * 
	 * @param s
	 *            Array of strings to be parsed
	 */
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Quit")) {
			return new Quit();
		} else {
			return null;
		}
	}

	/**
	 * Generates a single string with the help of this command
	 */
	public String textHelp() {
		return "QUIT: Close the application " + System.getProperty("line.separator");
	}

	/**
	 * Regular translation of the object type to a String
	 */
	public String toString() {
		return "QUIT ";
	}
}
