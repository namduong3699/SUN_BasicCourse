import java.io.FileNotFoundException;

public class Main {
	public static void main(String args[]) throws FileNotFoundException {
		Team team_A = fileOpen.loadTeam("team_A.txt");
		Team team_B = fileOpen.loadTeam("team_B.txt");
		War war = new War("AB", team_A, team_B);
		war.fight();
		fileOpen.warResultToFile(war, "output.txt");
	}
}
	