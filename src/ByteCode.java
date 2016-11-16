/**
 * This class encloses a single ByteCode instruction
 */
public class ByteCode {

	public static enum ENUM_BYTECODE {
		push, load, store, add, sub, mul, div, out, halt
	}

	private ENUM_BYTECODE name;
	private int param; // Used with instructions: push, store and load

	/**
	 * ByteCode constructor used for the ByteCode instruction which doens't
	 * require an integer parameter
	 * 
	 * @param instructionType
	 *            The type of the instruction
	 */
	public ByteCode(ENUM_BYTECODE instructionType) {
		this.name = instructionType;
	}

	/**
	 * ByteCode constructor used for the PUSH, STORE and LOAD ByteCode
	 * instructions
	 * 
	 * @param instructionType
	 *            The type of the instuction
	 * @param num
	 *            The integer paramater
	 */
	public ByteCode(ENUM_BYTECODE instructionType, int num) {
		this.name = instructionType;
		this.setParam(num);
	}

	/**
	 * Sets a parameter for the current ByteCode instruction
	 * 
	 * @param num
	 *            The integer to be set as the paramater of the ByteCode
	 *            instruction
	 */
	public void setParam(int num) {
		this.param = num;
	}

	/**
	 * Returns the "param" attribute current value
	 * 
	 * @return The integer currently stored as the ByteCode instruction
	 *         parameter
	 */
	public int getParam() {
		return this.param;
	}

	/**
	 * Provides the name (enumerated type) of the ByteCode instruction
	 * 
	 * @return The name (type) of the current ByteCode instruction
	 */
	public ENUM_BYTECODE getName() {
		return name;
	}

	/**
	 * Generates a String ready to be printed on the screen
	 * 
	 * @return The String generated
	 */
	public String toString() {
		String output;
		output = name.toString().toUpperCase();
		if (name == ENUM_BYTECODE.push || name == ENUM_BYTECODE.load || name == ENUM_BYTECODE.store)
			output = output + " " + param;
		return output;
	}
}
