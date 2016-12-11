/**
 * This class encloses the virtual CPU, which has a memory and a operand stack
 */
public class CPU {

	private OperandStack op;
	private boolean finish;
	private Memory memory;
	private int programCounter;
	private ByteCodeProgram bcProgram;

	/**
	 * CPU class constructor. It assigns a new OperandStack and a new Memory
	 */
	public CPU() {
		op = new OperandStack();
		finish = false;
		memory = new Memory();
		programCounter = 0;
	}

	/**
	 * CPU class 1 argument constructor. It assigns a new OperandStack, a new
	 * Memory and a ByteCodeProgram
	 */
	public CPU(ByteCodeProgram bcnew) {
		op = new OperandStack();
		finish = false;
		memory = new Memory();
		programCounter = 0;
		bcProgram = bcnew;
	}

	/**
	 * Provides the value of the "finish" attribute
	 * 
	 * @return A boolean which indicates if the execution flow must be stopped
	 */
	public boolean getFinish() {
		return finish;
	}

	/**
	 * Generates a String ready to be printed on the screen
	 * 
	 * @param instr
	 *            The ByteCode instruction
	 * @return The String generated
	 */
	public String toString() {
		return "\nState of virtual machine after execution of the program:\n   " + memory.toString() + "\n   "
				+ op.toString();
	}

	/**
	 * The main loop for executing the current ByteCode program
	 * 
	 * @return If it had success
	 */
	public boolean run() {
		boolean errorOnExecution = false;
		while ((programCounter < bcProgram.getByteCodeProgramLength())
				&& !(bcProgram.getByteCodeInstructionOnPosition(programCounter) instanceof Halt) && !errorOnExecution) {
			increaseProgramCounter();
			if (bcProgram.getByteCodeInstructionOnPosition(programCounter - 1).execute(this) == false) {
				errorOnExecution = true;
			}
		}

		return !errorOnExecution;
	}

	/**
	 * Provides the program length
	 * 
	 * @return The Program length
	 */
	public int getProgramLength() {
		return bcProgram.getByteCodeProgramLength();
	}

	/**
	 * Provides the next instruction to be executed
	 * 
	 * @return The next instruction to be executed by the CPU
	 */
	public int getProgramCounter() {
		return programCounter;
	}

	/**
	 * Sets a number as the new program counter position
	 * 
	 * @param n
	 *            The new position
	 */
	public void setProgramCounter(int n) {
		programCounter = n;
	}

	/**
	 * Increases the program counter by 1
	 */
	public void increaseProgramCounter() {
		programCounter++;
	}

	/**
	 * It freezes the CPU
	 * 
	 * @return If it had success
	 */
	public boolean halt() {
		finish = true;
		return true;
	}

	/**
	 * Generates a string with the value of the top of the stack
	 * 
	 * @return The generated string
	 */
	public String out() {
		return "\nOutput: <<" + op.takeValue() + ">>\n";
	}

	/**
	 * Method that adds a value to the stack
	 * 
	 * @param n
	 *            The parameter of the push command
	 * @return If it had success
	 */
	public boolean push(int n) {
		return op.addValue(n);
	}

	/**
	 * Method that stores a value of the stack
	 * 
	 * @param n
	 *            The memory position
	 * @return If it had success
	 */
	public boolean store(int n) {
		int aux = op.takeValue();
		boolean execution = memory.write(n, aux);
		op.deleteValue();
		return execution;
	}

	/**
	 * Method that loads a value of the memory to the stack
	 * 
	 * @param n
	 *            The memory position
	 * @return If it had success
	 */
	public boolean load(int n) {
		int aux = memory.read(n);
		op.addValue(aux);
		return true;
	}

	/**
	 * Checks if there is at least two numbers on the stack
	 * 
	 * @return If it is ready or not
	 */
	public boolean atLeastTwoNumsOnStack() {
		boolean ready = true;
		if (op.getOccupied() < 2) {
			ready = false;
		}
		return ready;
	}

	/**
	 * Takes the value of the top of the stack
	 * 
	 * @return The integer value
	 */
	public int takeValue() {
		return op.takeValue();
	}

	/**
	 * Deletes the value of the top of the stack
	 */
	public void deleteValue() {
		op.deleteValue();
	}

	/**
	 * Adds a value to the top of the stack
	 */
	public void addValue(int n) {
		op.addValue(n);
	}
}