
public class AddByteCodeProgram extends Command {

	@Override
	public boolean execute(Engine engine) {
		return engine.doByteCode();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("ByteCode")) {
			return new AddByteCodeProgram();
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
	
	public String toString() {
		return "ByteCode ";
	}
}
