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
		Command command = null;
		ByteCode instruction = null; // Initializes to null
		String[] arrayOfStrings = line.split(" "); // Splits the big string into
													// an array of strings
													// divided by white spaces
		String secondaryRawInput = "";

		if (arrayOfStrings.length >= 2) {
			secondaryRawInput = arrayOfStrings[1];
			for (int i = 2; i < arrayOfStrings.length; i++) {
				secondaryRawInput = secondaryRawInput + " " + arrayOfStrings[i];
			}
		}
		if (arrayOfStrings[0].equalsIgnoreCase("help")) {
			command = new Command(Command.ENUM_COMMAND.help);
		} else if (arrayOfStrings[0].equalsIgnoreCase("quit")) {
			command = new Command(Command.ENUM_COMMAND.quit);
		} else if (arrayOfStrings[0].equalsIgnoreCase("bytecode")) {
			command = new Command(Command.ENUM_COMMAND.bytecode);
			instruction = ByteCodeParser.parse(secondaryRawInput);
			command.setByteCodeInstruction(instruction);
		} else if (arrayOfStrings[0].equalsIgnoreCase("run")) {
			command = new Command(Command.ENUM_COMMAND.run);
		} else if (arrayOfStrings[0].equalsIgnoreCase("reset")) {
			command = new Command(Command.ENUM_COMMAND.reset);
		} else if (arrayOfStrings[0].equalsIgnoreCase("replace")) {
			try {
				command = new Command(Command.ENUM_COMMAND.replace);
				command.setReplaceNumber(Integer.parseInt(arrayOfStrings[1]));
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: replace <number>");
			}
		}
		return command;
	}
}
