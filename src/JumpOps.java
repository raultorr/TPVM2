
public abstract class JumpOps extends ByteCode {
	protected int param;

	public boolean execute(CPU cpu) {
		boolean success = false;
		if (readyToOperate(cpu)) {
			if (!compare(cpu)) {
				if (param <= cpu.getProgramCounterLength()) {
					cpu.setProgramCounter(param);
					success = true;
				}
			}
		}
		return success;
	}

	abstract public boolean compare(CPU cpu);

	public boolean readyToOperate(CPU cpu) {
		return cpu.atLeastTwoNumsOnStack();
	}
}
