import java.util.Scanner;

public class ArmyGeneral extends Brawler{
	private double m_Experience;
	
	public ArmyGeneral() {
		super();
	}
	
	public ArmyGeneral(String code, double attack, double defend, boolean equipment, int strength, double experience) {
		super();
		m_Equipment = true;
		this.m_Experience = experience;
	}
	
	
	@Override
	public void input(Scanner in) {
		super.input(in);
		this.m_Experience = Double.parseDouble(in.next());
	}
	
	public String getName() {
		return "AG";
	}
	
	public void getInfo() {
		System.out.println(this.getName() + " " + this.m_Code + " " + this.m_Attack + " " 
				+ this.m_Defend + " " + this.m_Equipment + " " + this.m_Strength + " " + this.m_Experience); 
	}
	
	
}
