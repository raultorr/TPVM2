/**
 * This class encloses the OperandStack
 */
public class OperandStack {
	private static final int SIZE_STACK = 1000;
	private int[] stack;
	private int occupied;

	/**
	 * OperandStack constructor. Initializes the stack to the default size
	 * "SIZE_STACK"
	 */
	public OperandStack() {
		stack = new int[SIZE_STACK];
		occupied = 0;
	}

	/**
	 * Sets a value to the stack on a given position
	 * 
	 * @param num
	 *            The value
	 * @param pos
	 *            The position
	 */
	public void setValue(int num, int pos) {
		this.stack[pos] = num;
	}

	/**
	 * Provides a value of the stack of a given position
	 * 
	 * @param pos
	 *            The position
	 * @return The value
	 */
	public int getValue(int pos) {
		return this.stack[pos];
	}

	/**
	 * Provides the length of the stack
	 * 
	 * @return The length
	 */
	public int getSize() {
		return stack.length;
	}

	/**
	 * Adds a value at the end of the stack
	 * 
	 * @param n
	 *            The number to be added at the end of the stack
	 * @return If the method had success
	 */
	public boolean addValue(int n) {
		boolean success;

		if (occupied < (stack.length - 1)) {
			success = true;
			stack[occupied] = n;
			occupied++;
		} else {
			success = false;
		}
		return success;
	}

	/**
	 * Provides the current top value of the stack
	 * 
	 * @return The top value of the stack
	 */
	public int takeValue() {
		int value;

		value = stack[occupied - 1];

		return value;
	}

	/**
	 * Deletes the last value of the stack
	 * 
	 * @return If the method had success
	 */
	public boolean deleteValue() {
		boolean success = true;

		if (occupied < 0) {
			success = false;
		} else {
			occupied--;
		}
		return success;
	}

	/**
	 * Generates a String ready to be printed on the screen
	 * 
	 * @return The String generated
	 */
	public String toString() {
		String resp = "Stack: ";
		if (occupied == 0) {
			resp += "<empty> ";
		} else {
			for (int i = 0; i < occupied; i++) {
				resp = resp + stack[i] + " ";
			}
		}
		return resp;
	}

	/**
	 * Provides the value of the "Occupied" attribute
	 * 
	 * @return The value of "Occupied"
	 */
	public int getOccupied() {
		return occupied;
	}

}
