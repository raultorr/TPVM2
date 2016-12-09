/**
 * This class encloses a single ByteCode instruction
 */
abstract public class ByteCode {
	abstract public boolean execute(CPU cpu);
	abstract public ByteCode parse(String[] words);
}
