public class Valiant extends Solider{
	public Valiant(String code, double attack, double defend, boolean equipment, int strength) {
		super(code,attack, defend, equipment, strength);
		if(equipment) {
			this.setDefend(defend*2); 
		}
	}
	
	@Override
	public String toString() {
		return "V " + super.toString();
	}
}
