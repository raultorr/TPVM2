
public class Out extends ByteCode {

	public boolean execute(CPU cpu) {
		System.out.println(cpu.out());
		return true;
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("out")) {
			return new Out();
		} else {
			return null;
		}
	}

	public String toString() {
		return "OUT ";
	}
}
