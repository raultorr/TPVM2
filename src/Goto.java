
public class Goto extends ByteCode {

	private int param;

	public boolean execute(CPU cpu) {
		boolean success = false;
		if (param <= cpu.getProgramCounterLength()) {
			cpu.setProgramCounter(param);
			success = true;
		}
		return success;
	}

	public Goto() {
	}

	public Goto(int n) {
		param = n;
	}

	@Override
	public ByteCode parse(String[] s) {
		Goto newCommand;
		if (s.length == 2 && s[0].equalsIgnoreCase("goto")) {
			try {
				int aux = Integer.parseInt(s[1]);
				newCommand = new Goto(aux);
				return newCommand;
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: Goto <number>");
			}
			return null;
		} else {
			return null;
		}
	}

	@Override

	public String toString() {
		return "GOTO " + param;
	}
}
