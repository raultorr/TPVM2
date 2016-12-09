
public class Reset extends Command {

	public Reset() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.executeReset();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("RESET")) {
			return new Reset();
		}
		else {
			return null;
		}
	}

	@Override
	public String textHelp() {
		return " RESET: Delete the current program " +
				System.getProperty("line.separator");
	}

}
