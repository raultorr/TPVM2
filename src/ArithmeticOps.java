/**
 * 
 * Abstract class which encloses the arithmetic bytecode operations
 *
 */
public abstract class ArithmeticOps extends ByteCode {
	abstract public boolean operation(CPU cpu);

	/**
	 * Checks if the operation can be done
	 * 
	 * @param cpu
	 *            The actual cpu
	 * @return If its able to operate
	 */
	public boolean readyToOperate(CPU cpu) {
		return cpu.atLeastTwoNumsOnStack();
	}
}