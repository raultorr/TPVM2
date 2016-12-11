
public class Help extends Command {

	@Override
	public boolean execute(Engine engine) {
		return engine.executeHelp();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Help")) {
			return new Help();
		} else {
			return null;
		}
	}

	@Override
	public String textHelp() {
		return " Show this help " + System.getProperty("line.separator");
	}

	public String toString() {
		return "Help";
	}
}
