/**
 * This class encloses a single command
 */
public class Command {

	public static enum ENUM_COMMAND {
		help, quit, run, reset, replace, bytecode
	}

	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;

	/**
	 * Constructor of the command
	 * 
	 * @param commandType
	 *            Is the type of the new command to be constructed
	 */
	public Command(ENUM_COMMAND commandType) {
		this.command = commandType;
	}

	/**
	 * Provides the command type (help, quit, newinst, run, reset, replace)
	 * 
	 * @return The command type
	 */
	public ENUM_COMMAND getCommandType() {
		return command;
	}

	/**
	 * Sets a reference to a ByteCode instruction on the class "instruction"
	 * attribute
	 * 
	 * @param inst
	 *            Is the new ByteCode instruction to be linked with the current
	 *            command
	 */
	public void setByteCodeInstruction(ByteCode inst) {
		this.instruction = inst;
	}

	/**
	 * Provides the current ByteCode instruction currently associated with the
	 * command
	 * 
	 * @return The assocciated ByteCode instruction
	 */
	public ByteCode getByteCodeInstruction() {
		return instruction;
	}

	/**
	 * Sets a number on the integer attribute "replace"
	 * 
	 * @param n
	 *            The number to be set
	 */
	public void setReplaceNumber(int n) {
		this.replace = n;
	}

	/**
	 * Gets the current number on the attribute "replace"
	 * 
	 * @return The current integer number
	 */
	public int getReplaceNumber() {
		return replace;
	}

	/**
	 * The command executes itself over the engine
	 * 
	 * @param engine
	 *            Is the current engine in which we are working on
	 * @return If the execution had success
	 */
	public boolean execute(Engine engine) {
		boolean success = false;

		switch (command) {
		case help:
			success = engine.executeHelp();
			break;
		case quit:
			success = engine.executeQuit();
			break;
		case bytecode:
			success = engine.doByteCode();
			break;
		case run:
			success = engine.executeRun();
			break;
		case reset:
			success = engine.executeReset();
			break;
		case replace:
			success = engine.executeReplace(replace);
		}
		return success;
	}
}
