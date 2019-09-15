public class Knight extends Brawler{
	public Knight() {
		super();
	}
	public Knight(String code, double attack, double defend, boolean equipment, int strength) {
		super();
		if(equipment) {
			this.m_Attack = attack*3;
			this.m_Defend = defend*3;
		}
	}
	
	public String getName() {
		return "K";
	}
}
