import java.io.File;
import java.util.Scanner;

public class War {
	private Team A;
	private Team B;
	
	public War() {
		A = new Team();
		B = new Team();
	}
	
	public War(Team A, Team B) {
		this.A = A;
		this.B = B;
	}
	
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
		while(!A.isLose() && !B.isLose()) {
			Brawler A_B = this.A.getBrawler();
			Brawler B_B = this.B.getBrawler();
			leaderBuff(A_B, A.getLeaderExp());
			leaderBuff(B_B, B.getLeaderExp());
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
	
	private void leaderBuff(Brawler brawler, double leaderExp) {
		if(!brawler.getM_Buff() && !(brawler instanceof ArmyGeneral)) {
			if(leaderExp == 0) {
				brawler.setM_Attack((double)brawler.getM_Attack()/2);
				brawler.setM_Defend((double)brawler.getM_Defend()/2);
			} else if(leaderExp <= 2) {
				brawler.setM_Attack((double)brawler.getM_Attack()/1.2);
				brawler.setM_Defend((double)brawler.getM_Defend()/1.2);
			} else if(leaderExp <= 5) {
				brawler.setM_Attack(brawler.getM_Attack()*1.5);
				brawler.setM_Defend(brawler.getM_Defend()*1.5);
			} else if(leaderExp > 5) {
				brawler.setM_Attack(brawler.getM_Attack()*2);
				brawler.setM_Defend(brawler.getM_Defend()*2);
			}
			brawler.setM_Buff(true);
		}
	}
	
	public void result() {
		if(A.isLose()) {
			System.out.println("Team " + B.getName() + " Win");
			B.getInfo();
		} else if(B.isLose()) {
			System.out.println("Team " + A.getName() + " Win");
			A.getInfo();
		}
	}
}
