
public class ByteCode1 extends Command {

	public ByteCode1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.doByteCode();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("ByteCode")) {
			return new ByteCode1();
		}
		else {
			return null;
		}
	}

	@Override
	public String textHelp() {
		return "BYTECODE: Load an entire bytecode program, one instruction at a time, from the command line " +
				System.getProperty("line.separator");
	}

}
