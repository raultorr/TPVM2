/**
 * This class encloses the ByteCode command
 */
public class AddByteCodeProgram extends Command {

	/**
	 * Calls the corresponding method of the engine
	 * 
	 * @param cpu
	 *            The actual cpu
	 */
	public boolean execute(Engine engine) {
		return engine.doByteCode();
	}

	/**
	 * Parses the string and checks if the command is the one of the class
	 * 
	 * @param s
	 *            Array of strings to be parsed
	 */
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("ByteCode")) {
			return new AddByteCodeProgram();
		} else {
			return null;
		}
	}

	/**
	 * Text help to be collected by the command HELP
	 */
	public String textHelp() {
		return "BYTECODE: Load an entire bytecode program, one instruction at a time, from the command line "
				+ System.getProperty("line.separator");
	}

	/**
	 * Regular translation of the object type to a String
	 */
	public String toString() {
		return "ByteCode ";
	}
}
