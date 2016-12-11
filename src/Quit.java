
public class Quit extends Command {

	@Override
	public boolean execute(Engine engine) {
		return engine.executeQuit();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Quit")) {
			return new Quit();
		} else {
			return null;
		}
	}

	@Override
	public String textHelp() {
		return "QUIT: Close the application " + System.getProperty("line.separator");
	}

	public String toString() {
		return "QUIT ";
	}
}
