import java.util.Scanner;

public class Archer extends Brawler{
	public Archer() {
		super();
	}
	public Archer(String code, double attack, double defend, boolean equipment, int strength) {
		super();
		if(equipment) {
			this.m_Attack = attack*1.5;
		}
	}
	
	@Override
	public void input(Scanner in) {
		super.input(in);
		if(m_Equipment) {
			this.m_Attack = m_Attack*1.5;
		}
	}
	
	public String getName() {
		return "A";
	}
}
