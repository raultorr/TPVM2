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
	 * Provides the value of the "finish" attribute
	 * 
	 * @return A boolean which indicates if the execution flow must be stopped
	 */
	public boolean getFinish() {
		return finish;
	}

	/**
	 * It's the main method of the class. This method executes a ByteCode
	 * instruction and modifies the OperandStack and Memory values
	 * 
	 * @param instr
	 *            The next ByteCode instruction to be executed
	 * @return If the ByteCode instruction was successfully executed
	 */
	public boolean execute(ByteCode instr) {
		boolean execution = true;
		ByteCode.ENUM_BYTECODE i = instr.getName();
		int n = instr.getParam();
		int aux, result;

		switch (i) {
		case push:
			execution = op.addValue(n);
			break;
		case load:
			aux = memory.read(n);
			op.addValue(aux);
			break;
		case store:
			aux = op.takeValue();
			execution = memory.write(n, aux);
			op.deleteValue();
			break;
		case add:
			if (op.getOccupied() < 2) {
				execution = false;
			} else {
				aux = op.takeValue();
				op.deleteValue();
				n = op.takeValue();
				op.deleteValue();
				result = aux + n;
				op.addValue(result);
			}
			break;
		case sub:
			if (op.getOccupied() < 2) {
				execution = false;
			} else {
				aux = op.takeValue();
				op.deleteValue();
				n = op.takeValue();
				op.deleteValue();
				result = n - aux;
				op.addValue(result);
			}
			break;
		case mul:
			if (op.getOccupied() < 2) {
				execution = false;
			} else {
				aux = op.takeValue();
				op.deleteValue();
				n = op.takeValue();
				op.deleteValue();
				result = aux * n;
				op.addValue(result);
			}
			break;
		case div:
			if (op.getOccupied() < 2) {
				execution = false;
			} else {
				aux = op.takeValue();
				if (aux != 0) {
					op.deleteValue();
					n = op.takeValue();
					op.deleteValue();
					result = n / aux;
					op.addValue(result);
				} else {
					execution = false;
				}
			}
			break;
		case out:
			System.out.println("\nOutput: <<" + op.takeValue() + ">>\n");
			break;
		case halt:
			finish = true;
			break;
		}

		System.out.println(this.toString(instr));

		return execution;
	}

	/**
	 * Generates a String ready to be printed on the screen
	 * 
	 * @param instr
	 *            The ByteCode instruction
	 * @return The String generated
	 */
	public String toString(ByteCode instr) {
		return "\nState of virtual machine after execution of " + instr.toString() + ":\n   " + memory.toString()
				+ "\n   " + op.toString();
	}

	public boolean run() {

	}

	public boolean halt() {
		finish = true;
		return true;
	}

	public String out() {
		return "\nOutput: <<" + op.takeValue() + ">>\n";
	}
	
	public 

}