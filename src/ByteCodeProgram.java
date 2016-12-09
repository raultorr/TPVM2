import java.util.Arrays;

/**
 * This class envolves a ByteCode program, i.e: A ByteCode instructions array
 */
public class ByteCodeProgram {

	private ByteCode[] program;

	/**
	 * ByteCodeProgram constructor, It initializes the length to 0 by default
	 */
	public ByteCodeProgram() {
		program = new ByteCode[0];
	}

	/**
	 * It appends a new ByteCode instruction at the end of the current program
	 * 
	 * @param nextInstruction
	 *            The next ByteCode instruction
	 */
	public void setNextByteCodeInstruction(ByteCode nextInstruction) {
		extendByteCodeArrayLength(1);
		program[program.length - 1] = nextInstruction;
	}

	/**
	 * Removes the last ByteCode instruction by reducing the array length on '1'
	 */
	public void removeLastByteCodeInstruction() {
		reduceByteCodeArrayLength(1);
	}

	/**
	 * Provides the ByteCode instruction on a certain position "n"
	 * 
	 * @param n
	 *            The position of the instruction on the program
	 * @return A reference to the ByteCode object
	 */
	public ByteCode getByteCodeInstructionOnPosition(int n) {
		return program[n];
	}

	/**
	 * Sets a new ByteCode instruction on a specific position of the program
	 * 
	 * @param newInstruction
	 *            The next ByteCode instruction
	 * @param n
	 *            The position of the instruction to be set on the program
	 */
	public void placeByteCodeInstruction(ByteCode newInstruction, int n) {
		program[n] = newInstruction;
	}

	/**
	 * Extends the program array on "n" positions
	 * 
	 * @param n
	 *            The number of positions to increase the program length
	 */
	private void extendByteCodeArrayLength(int n) {
		program = Arrays.copyOf(program, program.length + n);
	}

	/**
	 * Reduces the program array on "n" positions
	 * 
	 * @param n
	 *            The number of positions to reduce the program length
	 */
	private void reduceByteCodeArrayLength(int n) {
		program = Arrays.copyOf(program, program.length - n);
	}

	/**
	 * Provides the current length of the program
	 * 
	 * @return The length
	 */
	public int getByteCodeProgramLength() {
		return program.length;
	}

	/**
	 * Generates a String ready to be printed on the screen
	 * 
	 * @return The String generated
	 */
	public String toString() {
		String result = "";
		if (program.length != 0) {
			result = "\nCurrent program:\n";
			for (int i = 0; i < program.length; i++) {
				result = result + i + ": " + program[i].toString() + "\n";
			}
		}
		return result;
	}
}
