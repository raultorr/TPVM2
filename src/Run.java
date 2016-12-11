/**
 * Encloses the run command
 */
public class Run extends Command {

	/**
	 * Executes the instructions on the program
	 * 
	 * @param engine
	 *            The actual engine
	 */
	public boolean execute(Engine engine) {
		return engine.executeRun();
	}

	/**
	 * Parses the string and checks if the command is the one of the class
	 * 
	 * @param s
	 *            Array of strings to be parsed
	 */
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Run")) {
			return new Run();
		} else {
			return null;
		}
	}

	/**
	 * Generates a single string with the help of this command
	 */
	public String textHelp() {
		return "RUN: Execute the program " + System.getProperty("line.separator");
	}

	/**
	 * Regular translation of the object type to a String
	 */
	public String toString() {
		return "RUN ";
	}
}
