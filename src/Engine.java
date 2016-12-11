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
					if (!(command instanceof Quit)) {
						System.out.println(program.toString());
					}
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

		CommandParser.showHelp();

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
	 * This method allows the user to introduce a ByteCode program in a row
	 * 
	 * @return If it had success
	 */
	public boolean doByteCode() {
		boolean execution = true;
		String instruction;
		ByteCode inst;

		System.out.println("Please enter the bytecode program," + " one instruction per line:");
		instruction = scanner.nextLine();
		while (!instruction.equalsIgnoreCase("end") && execution) {
			inst = ByteCodeParser.parse(instruction);
			if (inst == null) {
				execution = false;
			} else {
				program.setNextByteCodeInstruction(inst);
				instruction = scanner.nextLine();
			}
		}
		return execution;
	}

	/**
	 * Executes the current instructions on the actual program
	 * 
	 * @return If the method was successfully executed
	 */
	public boolean executeRun() {

		cpu = new CPU(program);
		boolean success = true;
		if (program.getByteCodeProgramLength() == 0) {
			success = false;
		} else {
			if (!cpu.run()) {
				System.out.println("Error");
				System.out.println(cpu);
			} else {
				System.out.println(cpu);
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
