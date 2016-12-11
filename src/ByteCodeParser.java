/**
 * This class is the ByteCode analyzer
 */
public class ByteCodeParser {

	private final static ByteCode[] bytecodeins = { new Add(), new Sub(), new Mul(), new Div(), new Ifeq(), new Ifneq(),
			new Ifle(), new Ifleq(), new Push(), new Store(), new Load(), new Halt(), new Out(), new Goto() };

	/**
	 * Analyzes the string introduced by the user
	 * 
	 * @param s
	 *            Is the string to be analyzed
	 * @return A ByteCode object corresponding to the one on the string or
	 *         'null'
	 */
	public static ByteCode parse(String s) {
		boolean found = false;
		int i = 0;
		ByteCode b = null;
		String[] words = s.split(" ");

		while (i < bytecodeins.length && !found) {

			b = bytecodeins[i].parse(words);
			if (b != null) {
				found = true;
			} else {
				i++;
			}

		}
		return b;
	}
}
