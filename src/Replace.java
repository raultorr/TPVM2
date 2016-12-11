
public class Replace extends Command {
	private int replace;

	@Override
	public boolean execute(Engine engine) {
		return engine.executeReplace(replace);
	}

	public Replace() {
	}

	public Replace(int n) {
		replace = n;
	}

	@Override
	public Command parse(String[] s) {
		Replace newCommand;
		if (s.length == 1 && s[0].equalsIgnoreCase("replace")) {
			try {
				int aux = Integer.parseInt(s[1]);
				newCommand = new Replace(aux);
				return newCommand;
			} catch (Exception e) {
				System.err.println("Invalid syntax. Usage: replace <number>");
			}
			return null;
		} else {
			return null;
		}
	}

	@Override
	public String textHelp() {
		return "REPLACE N: Replace insruction no. N with an instruction to be provided"
				+ System.getProperty("line.separator");
	}

	public String toString() {
		return "Replace";
	}

	public int getReplace() {
		return replace;
	}
}
