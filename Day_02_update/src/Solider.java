public abstract class Solider {
	private String code;
	private double attack;
	private double defend;
	private boolean equipment;
	private int strength; //chỉ số sức mạnh, nếu bằng 0 thì tương đương với đã hy sinh
	
	public Solider(String code, double attack, double defend, boolean equipment, int strength) {
		this.code = code;
		this.attack = attack;
		this.defend = defend;
		this.equipment = equipment;
		this.strength = strength;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		this.attack = attack;
	}

	public double getDefend() {
		return defend;
	}

	public void setDefend(double defend) {
		this.defend = defend;
	}

	public boolean isEquipment() {
		return equipment;
	}

	public void setEquipment(boolean equipment) {
		this.equipment = equipment;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	@Override
	public String toString() {
		return 	this.code + " " + this.attack + " " +
				this.defend + " " + ((this.equipment) ? "YES" : "NO") + " " + this.strength; 
	}
	
	public boolean isDead() {
		if(this.strength == 0) return true;
		else return false;
	}
	
	public void dead() {
		this.strength = 0;
	}
	
	public void damage(int damage) {
		this.attack -= damage;
		this.defend -= damage;
	}
}
