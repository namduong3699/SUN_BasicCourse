public class Knight extends Solider{
	public Knight(String code, double attack, double defend, boolean equipment, int strength) {
		super(code, attack, defend, equipment, strength);
		if(equipment) {
			this.setAttack(attack*3);
			this.setDefend(defend*3);
		}
	}
	
	@Override
	public String toString() {
		return "K " + super.toString();
	}
}
