
public class Ifle extends JumpOps {

	public Ifle() {
	}

	public Ifle(int n) {
		param = n;
	}

	@Override
	public ByteCode parse(String[] s) {
		Ifle newCommand;
		if (s.length == 1 && s[0].equalsIgnoreCase("ifle")) {
			try {
				int aux = Integer.parseInt(s[1]);
				newCommand = new Ifle(aux);
				return newCommand;
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: ifle <number>");
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
		if (aux > aux2) {
			condition = true;
		}
		return condition;
	}

	public String toString() {
		return "Ifle";
	}
}
