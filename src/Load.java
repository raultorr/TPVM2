
public class Load extends ByteCode {

	private int param;

	public boolean execute(CPU cpu) {
		return cpu.load(param);
	}

	public Load() {
	}

	public Load(int n) {
		param = n;
	}

	@Override
	public ByteCode parse(String[] s) {
		Load newCommand;
		if (s.length == 1 && s[0].equalsIgnoreCase("load")) {
			try {
				int aux = Integer.parseInt(s[1]);
				newCommand = new Load(aux);
				return newCommand;
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: load <number>");
			}
			return null;
		} else {
			return null;
		}
	}

	public String toString() {
		return "Load";
	}

}
