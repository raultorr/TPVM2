/**
 * This class encloses a single command
 */
abstract public class Command {
	
	 abstract public boolean execute(Engine engine);
	 abstract public Command parse(String[] s);
	 abstract public String textHelp();
	 
}
