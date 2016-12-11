/**
 * Abstract class which encloses the conditional jump operations
 */
public abstract class JumpOps extends ByteCode {
	protected int param;

	/**
	 * Executes the conditional jump
	 * 
	 * @param cpu
	 *            The actual cpu
	 */
	public boolean execute(CPU cpu) {
		boolean success = true;
		if (readyToOperate(cpu)) {
			if (!compare(cpu)) {
				if (param < cpu.getProgramLength()) {
					cpu.setProgramCounter(param);
				} else {
					success = false;
				}
			}
		} else {
			success = false;
		}
		return success;
	}

	abstract public boolean compare(CPU cpu);

	/**
	 * Provides a boolean which indiicates if it is ready to operate
	 * 
	 * @param cpu
	 *            The actual cpu
	 * @return If it is ready to operate
	 */
	public boolean readyToOperate(CPU cpu) {
		return cpu.atLeastTwoNumsOnStack();
	}
}
