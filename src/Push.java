
public class Push extends ByteCode {

	private int param;

	public boolean execute(CPU cpu) {
		System.out.println(cpu.out());
		return true;
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("push")) {
			try {
				param = Integer.parseInt(s[1]);
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: push <number>");
			}
			return new Push();
		} else {
			return null;
		}
	}

	public String toString() {
		return "Push";
	}
}
