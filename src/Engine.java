import java.util.Scanner;

/**
 * Core of the application
 */
public class Engine {

	private ByteCodeProgram program;
	private boolean end;
	private CPU cpu;
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * The engine constructor. It generates a new engine with a new program and
	 * a new CPU
	 */
	public Engine() {
		program = new ByteCodeProgram();
		cpu = new CPU();
		end = false;
	}

	/**
	 * Main loop of the engine
	 */
	public void start() {
		String rawInput;
		Command command;

		while (!end) {
			System.out.print("> ");
			rawInput = scanner.nextLine();
			command = CommandParser.parse(rawInput);
			if (command == null) {
				System.err.println("Error: incorrect command");
			} else {
				System.out.println("Starting execution of " + rawInput.toUpperCase());
				if (command.execute(this) == false) {
					System.err.println("Error: incorrect execution of the command");
				} else { // Execution was successful
					if (command.getCommandType() != Command.ENUM_COMMAND.quit)
						System.out.println(program.toString());

				}
			}
		}
		scanner.close();
	}

	/**
	 * Shows a help message
	 * 
	 * @return If the method was successfully executed
	 */
	public boolean executeHelp() {

		System.out.println(
				"\n  HELP: Show this help \n" + "  QUIT: Close the application \n" + "  RUN: Execute the program \n"
						+ "  NEWINST BYTECODE: Add a new instruction to the current program \n"
						+ "  RESET: Delete the current program \n"
						+ "  REPLACE N: Replace insruction no. N with an instruction to be provided");

		return true;
	}

	/**
	 * Tags the application ready to be closed
	 * 
	 * @return If the method was successfully executed
	 */
	public boolean executeQuit() {
		end = true;

		System.out.println("Closing the application...");

		return end;
	}

	/**
	 * Executes a ByteCode instruction passed as parameter
	 * 
	 * @param bc
	 *            Next ByteCode instruction to execute
	 * @return If the method was successfully executed
	 */
	public boolean executeNewInst(ByteCode bc) {

		boolean success = false;

		if (bc != null) {
			program.setNextByteCodeInstruction(bc);
			success = true;
		}
		return success;
	}

	/**
	 * Executes the current instructions on the actual program
	 * 
	 * @return If the method was successfully executed
	 */
	public boolean executeRun() {

		cpu = new CPU();
		boolean success = true;
		if (program.getByteCodeProgramLength() == 0) {
		} else {
			for (int i = 0; i < (program.getByteCodeProgramLength()); i++) {
				if (program.getByteCodeInstructionOnPosition(i).getName() == ByteCode.ENUM_BYTECODE.halt) {
					System.out.println("\nHALT: Stopping VM...");
					break;
				} else {
					if (!cpu.execute(program.getByteCodeInstructionOnPosition(i))) {
						success = false;
					}
				}
			}

		}

		return success;
	}

	/**
	 * Replace a instruction of the current program by another one provided by
	 * the user
	 * 
	 * @param replace
	 *            The position of the instruction to be replaced on the current
	 *            program
	 * @return If the method was successfully executed
	 */
	public boolean executeReplace(int replace) {
		boolean success = false;
		String rawInput;

		if (replace >= 0 && replace < program.getByteCodeProgramLength()) {
			System.out.print("Please enter replacement instruction: ");
			rawInput = scanner.nextLine();
			ByteCode aux = ByteCodeParser.parse(rawInput);
			if (aux != null) {
				program.placeByteCodeInstruction(aux, replace);
				success = true;
			}
		} else
			System.err.println("Error: \"" + replace + "\" is not a valid position.");

		return success;
	}

	/**
	 * Resets the current program
	 * 
	 * @return If the method was successfully executed
	 */
	public boolean executeReset() {
		program = new ByteCodeProgram();
		return true;
	}

}
