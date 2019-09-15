import java.util.Scanner;

public class Valiant extends Brawler{
	public Valiant() {
		super();
	}
	public Valiant(String code, double attack, double defend, boolean equipment, int strength) {
		super();
		if(equipment) {
			this.m_Defend = defend*2;
		}
	}
	
	@Override
	public void input(Scanner in) {
		super.input(in);
		if(m_Equipment) {
			this.m_Defend = m_Defend*2;
		}
	}
	
	public String getName() {
		return "V";
	}
}
