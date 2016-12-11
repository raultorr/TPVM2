
public abstract class ArithmeticOps extends ByteCode {
	abstract public boolean operation(CPU cpu);

	public boolean readyToOperate(CPU cpu) {
		return cpu.atLeastTwoNumsOnStack();
	}
}