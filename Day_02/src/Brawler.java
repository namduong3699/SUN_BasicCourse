import java.util.Scanner;

public abstract class Brawler {
	protected String m_Code;
	protected double m_Attack;
	protected double m_Defend;
	protected boolean m_Equipment;
	protected int m_Strength;
	protected boolean m_Buff = false;
	
	public Brawler() {
		m_Code = "000";
		m_Attack = 0.0;
		m_Defend = 0.0;
		m_Equipment = false;
		m_Strength = 0;
	}
	
	public Brawler(String code, double attack, double defend, boolean equipment, int strength) {
		this.m_Code = code;
		this.m_Attack = attack;
		this.m_Defend = defend;
		this.m_Equipment = equipment;
		this.m_Strength = strength;
	}
	
	public void input(Scanner in) {
		this.m_Code = in.next();
		this.m_Attack = Double.parseDouble(in.next());
		this.m_Defend = Double.parseDouble(in.next());
		if(in.next().equals("YES")) {
			this.m_Equipment = true;
		} else {
			this.m_Equipment = false;
		}
		this.m_Strength = Integer.parseInt(in.next());
	}
	
	public abstract String getName();
	public void getInfo() {
		System.out.println(this.getName() + " " + this.m_Code + " " + this.m_Attack + " " 
				+ this.m_Defend + " " + ((this.m_Equipment) ? "YES" : "NO") + " " + this.m_Strength); 
	}

	protected void damage() {
		this.m_Attack -= 20;
		this.m_Defend -= 20;
	}
	
	public double getM_Attack() {
		return m_Attack;
	}

	public double getM_Defend() {
		return m_Defend;
	}

	public int getM_Strength() {
		return m_Strength;
	}
	
	public boolean getM_Buff() {
		return m_Buff;
	}

	public void setM_Attack(double m_Attack) {
		this.m_Attack = m_Attack;
	}

	public void setM_Defend(double m_Defend) {
		this.m_Defend = m_Defend;
	}

	public void setM_Strength(int m_Strength) {
		this.m_Strength = m_Strength;
	}

	public void setM_Buff(boolean m_Buff) {
		this.m_Buff = m_Buff;
	};
}
