
public class Push extends ByteCode {

	private int param;

	public boolean execute(CPU cpu) {
		return cpu.push(param);
	}

	public Push() {
	}

	public Push(int n) {
		param = n;
	}

	@Override
	public ByteCode parse(String[] s) {
		Push newCommand;
		if (s.length == 1 && s[0].equalsIgnoreCase("push")) {
			try {
				int aux = Integer.parseInt(s[1]);
				newCommand = new Push(aux);
				return newCommand;
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: push <number>");
			}
			return null;
		} else {
			return null;
		}
	}

	public String toString() {
		return "Push";
	}
}
