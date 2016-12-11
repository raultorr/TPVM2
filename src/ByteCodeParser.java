/**
 * This class is the ByteCode analyzer
 */
public class ByteCodeParser {

	private final static Command[] bytecodeins = { new Help(), new Quit(), new Reset(), new Replace(), new Run(),
			new AddByteCodeProgram() };

}

	/**
	 * It's the main method of the class. It parsers a raw line and generates a
	 * corresponding ByteCode object
	 * 
	 * @param s
	 *            The raw string line
	 * @return A ByteCode object or "null" if it failed to parse
	 */
	public static ByteCode parse(String s) {
		ByteCode instruction = null;
		String[] arrayOfStrings = s.split(" ");

		if (arrayOfStrings[0].equalsIgnoreCase("push")) {
			try {
				instruction = new ByteCode(ByteCode.ENUM_BYTECODE.push, Integer.parseInt(arrayOfStrings[1]));
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: newinst push <number>\n");
			}
		} else if (arrayOfStrings[0].equalsIgnoreCase("load")) {
			try {
				instruction = new ByteCode(ByteCode.ENUM_BYTECODE.load, Integer.parseInt(arrayOfStrings[1]));
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: newinst load <number>\n");
			}
		} else if (arrayOfStrings[0].equalsIgnoreCase("store")) {
			try {
				instruction = new ByteCode(ByteCode.ENUM_BYTECODE.store, Integer.parseInt(arrayOfStrings[1]));
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: newinst store <number>\n");
			}
		} else if (arrayOfStrings[0].equalsIgnoreCase("add")) {
			instruction = new ByteCode(ByteCode.ENUM_BYTECODE.add);
		} else if (arrayOfStrings[0].equalsIgnoreCase("sub")) {
			instruction = new ByteCode(ByteCode.ENUM_BYTECODE.sub);
		} else if (arrayOfStrings[0].equalsIgnoreCase("div")) {
			instruction = new ByteCode(ByteCode.ENUM_BYTECODE.div);
		} else if (arrayOfStrings[0].equalsIgnoreCase("mul")) {
			instruction = new ByteCode(ByteCode.ENUM_BYTECODE.mul);
		} else if (arrayOfStrings[0].equalsIgnoreCase("out")) {
			instruction = new ByteCode(ByteCode.ENUM_BYTECODE.out);
		} else if (arrayOfStrings[0].equalsIgnoreCase("halt")) {
			instruction = new ByteCode(ByteCode.ENUM_BYTECODE.halt);
		}
		return instruction;
	}

	public static ByteCode parse(String s) {
		boolean found = false;
		int i = 0;
		Command c = null;
		String[] words = s.split(" ");

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
