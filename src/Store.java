
public class Store extends ByteCode {

	private int param;

	public boolean execute(CPU cpu) {
		return cpu.store(param);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("store")) {
			try {
				param = Integer.parseInt(s[1]);
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: store <number>");
			}
			return new Store();
		} else {
			return null;
		}
	}

	public String toString() {
		return "Store";
	}

}
