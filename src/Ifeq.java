
public class Ifeq extends JumpOps {

	public Ifeq() {
	}

	public Ifeq(int n) {
		param = n;
	}

	@Override
	public ByteCode parse(String[] s) {
		Ifeq newCommand;
		if (s.length == 2 && s[0].equalsIgnoreCase("ifeq")) {
			try {
				int aux = Integer.parseInt(s[1]);
				newCommand = new Ifeq(aux);
				return newCommand;
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: ifeq <number>");
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
		if (aux == aux2) {
			condition = true;
		}
		return condition;
	}

	public String toString() {
		return "IFEQ " + param;
	}
}
