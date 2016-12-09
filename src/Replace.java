
public class Replace extends Command {
	private int replace;
	
	public Replace() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.executeReplace(replace);
	}

	@Override
	public Command parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("Replace")) {
			replace = Integer.parseInt(s[1]);
			return new Replace();
		}
		else {
			return null;
		}
	}

	@Override
	public String textHelp() {
		return "REPLACE N: Replace insruction no. N with an instruction to be provided" +
				System.getProperty("line.separator");
	}

}
