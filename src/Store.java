
public class Store extends ByteCode {

	private int param;

	public boolean execute(CPU cpu) {
		return cpu.store(param);
	}

	public Store() {
	}

	public Store(int n) {
		param = n;
	}

	@Override
	public ByteCode parse(String[] s) {
		Store newCommand;
		if (s.length == 1 && s[0].equalsIgnoreCase("store")) {
			try {
				int aux = Integer.parseInt(s[1]);
				newCommand = new Store(aux);
				return newCommand;
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: store <number>");
			}
			return null;
		} else {
			return null;
		}
	}

	public String toString() {
		return "Store";
	}

}
