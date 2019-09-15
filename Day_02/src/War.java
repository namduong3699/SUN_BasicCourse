import java.io.File;
import java.util.Scanner;

public class War {
	private Team A = new Team();
	private Team B = new Team();
	
	public void input() {	
		try {
			String path = "input.txt";
			File file = new File(path);	
			Scanner in = new Scanner(file);
			A.input(in);
			B.input(in);
		} catch (Exception e) {
			System.out.println("War-input: " + e);
		}
	}
	
	public void getInfo() {
		A.getInfo();
		B.getInfo();
	}
	
	public void fight() {
		while(!A.isLose() || !B.isLose()) {
			Brawler A_B = this.A.getBrawler();
			Brawler B_B = this.B.getBrawler();
			if(A_B.getM_Defend() > B_B.getM_Defend() && A_B.getM_Attack() >= B_B.getM_Defend()) {  //	A_B thắng B_B
				B.remove(B_B);
				A.damage(A_B);
			} else if (B_B.getM_Defend() > A_B.getM_Defend() && B_B.getM_Attack() >= A_B.getM_Defend()) {  //	A_B thua B_B
				A.remove(A_B);
				B.damage(B_B);
			} else if(A_B.getM_Strength() > B_B.getM_Strength()) {
				B.remove(B_B);
				A.damage(A_B);
			} else if(B_B.getM_Strength() > A_B.getM_Strength()) {
				A.remove(A_B);
				B.damage(B_B);
			} else {
				A.remove(A_B);
				B.remove(B_B);
			}
		}
	}
}
