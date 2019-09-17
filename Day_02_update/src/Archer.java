public class Archer extends Solider{
	public Archer(String code, double attack, double defend, boolean equipment, int strength) {
		super(code, attack, defend, equipment, strength);
		if(equipment) {
			this.setAttack(attack*1.5); 
		}
	}
	
	@Override
	public String toString() {
		return "A " + super.toString();
	}
}
