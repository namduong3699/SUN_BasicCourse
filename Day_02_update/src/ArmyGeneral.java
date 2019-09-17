import java.util.ArrayList;

public class ArmyGeneral extends Solider{
	private double experience;
	
	public ArmyGeneral(String code, double attack, double defend, boolean equipment, int strength, double experience) {
		super(code, attack, defend, equipment, strength);
		equipment = true;
		this.experience = experience;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}
	
	@Override
	public String toString() {
		return "AG " + super.toString() + " " + this.experience;
	}
	
	public void buff(ArrayList<Solider> army) {
		double buffRange = 0;
		if(experience == 0) buffRange = 1/2;
		else if(experience <= 2) buffRange = (double) 1/1.2;
		else if(experience <= 5) buffRange = 1.5;
		else buffRange = 2;
		for (Solider solider : army) {
				solider.setAttack(solider.getAttack() * buffRange);
				solider.setDefend(solider.getDefend() * buffRange);	
		}
	}
}
