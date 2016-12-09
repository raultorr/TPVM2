
public class Run extends Command{

	public Run() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.executeRun();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("Run")) {
			return new Run();
		}
		else {
			return null;
		}
	}

	@Override
	public String textHelp() {
		return "RUN: Execute the program " +
				System.getProperty("line.separator");
	}

}
