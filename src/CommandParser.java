/**
 * This class is the command analyzer
 */
public class CommandParser {
	/**
	 * It's the main method of the class. It parsers a raw line and generates a
	 * corresponding command object
	 * 
	 * @param line
	 *            The raw line
	 * @return A command object or "null" if it failed to parse
	 */
	public static Command parse(String line) {
		private final static Command[] commands = {
				new Help(), new Quit(), new Reset(),
				new Replace(), new Run(), new AddByteCodeProgram()}
	}
}
