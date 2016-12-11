
public class Halt extends ByteCode {

	@Override
	public boolean execute(CPU cpu) {
		return cpu.halt();
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("halt")) {
			return new Halt();
		} else {
			return null;
		}
	}

	public String toString() {
		return "Halt";
	}
}
