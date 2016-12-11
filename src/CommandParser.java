/**
 * This class is the command analyzer
 */
public class CommandParser {

	private final static Command[] commands = { new Help(), new Quit(), new Reset(), new Replace(), new Run(),
			new AddByteCodeProgram() };

	/**
	 * It's the main method of the class. It parsers a raw line and generates a
	 * corresponding command object
	 * 
	 * @param line
	 *            The raw line
	 * @return A command object or "null" if it failed to parse
	 */
	public static Command parse(String line) {
		boolean found = false;
		int i = 0;
		Command c = null;
		String[] words = line.split(" ");

		while (i < commands.length && !found) {
			c = commands[i].parse(words);
			if (c != null) {
				found = true;
			} else {
				i++;
			}

		}
		return c;
	}

	/**
	 * Shows the text help of all the commands
	 */
	public static void showHelp() {
		for (int i = 0; i < CommandParser.commands.length; i++) {
			System.out.print(CommandParser.commands[i].textHelp());
		}
	}

}
