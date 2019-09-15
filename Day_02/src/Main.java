import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {
	public static void main(String args[]) throws FileNotFoundException {
		PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
		System.setOut(out);
		War war = new War();
		war.input();
		war.fight();
		war.result();
	}
}
	