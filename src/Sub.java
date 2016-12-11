
public class Sub extends ArithmeticOps {

	@Override
	public boolean operation(CPU cpu) {
		boolean success = false;
		if (readyToOperate(cpu)) {
			success = true;
			int aux = cpu.takeValue();
			cpu.deleteValue();
			int aux2 = cpu.takeValue();
			cpu.deleteValue();
			int result = aux2 - aux;
			cpu.addValue(result);
		}
		return success;
	}

	@Override
	public boolean execute(CPU cpu) {
		return operation(cpu);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("sub")) {
			return new Sub();
		} else {
			return null;
		}
	}

	public String toString() {
		return "SUB ";
	}
}
