
public class Div extends ArithmeticOps {

	@Override
	public boolean operation(CPU cpu) {
		boolean success = false;
		if (readyToOperate(cpu)) {
			success = true;
			int aux = cpu.takeValue();
			cpu.deleteValue();
			int aux2 = cpu.takeValue();
			cpu.deleteValue();
			int result = aux2 / aux;
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
		if (s.length == 1 && s[0].equalsIgnoreCase("div")) {
			return new Div();
		} else {
			return null;
		}
	}

	public boolean readyToOperate(CPU cpu) {
		boolean valid = false;
		if (cpu.takeValue() != '0' && cpu.atLeastTwoNumsOnStack()) {
			valid = true;
		}
		return valid;
	}

	public String toString() {
		return "DIV ";
	}
}
