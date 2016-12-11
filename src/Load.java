
public class Load extends ByteCode {

	private int param;

	public boolean execute(CPU cpu) {
		return cpu.load(param);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("load")) {
			try {
				param = Integer.parseInt(s[1]);
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: load <number>");
			}
			return new Load();
		} else {
			return null;
		}
	}

	public String toString() {
		return "Load";
	}

}
