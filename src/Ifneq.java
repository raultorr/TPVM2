
public class Ifneq extends JumpOps {

	public Ifneq() {
	}

	public Ifneq(int n) {
		param = n;
	}

	@Override
	public ByteCode parse(String[] s) {
		Ifneq newCommand;
		if (s.length == 2 && s[0].equalsIgnoreCase("ifneq")) {
			try {
				int aux = Integer.parseInt(s[1]);
				newCommand = new Ifneq(aux);
				return newCommand;
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: ifneq <number>");
			}
			return null;
		} else {
			return null;
		}
	}

	@Override
	public boolean compare(CPU cpu) {
		boolean condition = false;

		int aux = cpu.takeValue();
		cpu.deleteValue();
		int aux2 = cpu.takeValue();
		cpu.deleteValue();
		if (aux != aux2) {
			condition = true;
		}
		return condition;
	}

	public String toString() {
		return "IFNEQ " + param;
	}
}
