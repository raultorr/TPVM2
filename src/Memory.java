/**
 * This class encloses the virtual memory of the TPVM
 */
public class Memory {

	private Integer[] memory;
	private int size = 1;

	/**
	 * Memory constructor. By default the size of the memory is "1"
	 */
	public Memory() {
		memory = new Integer[size];
	}

	/**
	 * Writes a value to a specific memory position
	 * 
	 * @param pos
	 *            The position of the memory to write the value into
	 * @param value
	 *            The value to be written on the specific position of the memory
	 * @return If the method had success
	 */
	public boolean write(int pos, int value) {
		int aux;
		boolean success = true;

		if (pos < 0) {
			success = false;
		} else {
			if (pos > (memory.length - 1)) {
				aux = pos - (memory.length - 1);
				resize(aux);
			}
			memory[pos] = value;
		}
		return success;
	}

	/**
	 * Increases the size of the memory on "n" slots
	 * 
	 * @param n
	 *            The total value of new memory positions
	 */
	private void resize(int n) {
		Integer[] aux;
		int size;

		size = n + memory.length;
		aux = new Integer[size];
		for (int i = 0; i < memory.length; i++) {
			aux[i] = memory[i];
		}
		memory = aux;
	}

	/**
	 * Provides the value inside a specefic memory cell
	 * 
	 * @param pos
	 *            The position on the memory (the memory cell we want to read
	 *            from)
	 * @return The value inside the memory cell
	 */
	public int read(int pos) {
		int num = 0;
		int aux;

		if (pos > (memory.length - 1)) {
			aux = pos - (memory.length - 1);
			resize(aux);
		}
		if (memory[pos] == null) {
			memory[pos] = 0;
		} else {
			num = memory[pos];
		}
		return num;
	}

	/**
	 * Generates a String ready to be printed on the screen
	 * 
	 * @return The String generated
	 */
	public String toString() {
		String resp = "Memory:";
		boolean empty = true;

		for (int i = 0; i < memory.length; i++) {
			if (memory[i] != null) {
				empty = false;
				resp = resp + " [" + i + "]:" + memory[i];
			}
		}
		if (empty) {
			resp = resp + " <empty>";
		}

		return resp;
	}
}
