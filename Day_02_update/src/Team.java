import java.util.ArrayList;

public class Team {
	private String name;
	private ArmyGeneral leader;
	private ArrayList<Solider> army;
	
	public Team(String name, ArmyGeneral armyGeneral, ArrayList<Solider> army) {
		this.name = name;
		this.leader = armyGeneral; 
		this.army = army;
		leader.buff(army);
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArmyGeneral getLeader() {
		return leader;
	}


	public void setLeader(ArmyGeneral leader) {
		this.leader = leader;
	}


	public ArrayList<Solider> getArmy() {
		return army;
	}


	public void setArmy(ArrayList<Solider> army) {
		this.army = army;
	}

	@Override
	public String toString() {
		String result = leader.toString() + "\n";
		for(Solider brawler: army) {
			result += brawler.toString() + "\n";
		}
		return result;
	}
	
	public boolean isLose() {
		if(leader.isDead()) return true;
		else return false;
	}
	
	public Solider getSoliderToFight() {;
		for (Solider solider : army) {
			if(!solider.isDead()) return solider;
		}
		return leader;
	}
	
	public ArrayList<Solider> getAlive() {
		ArrayList<Solider> alive = new ArrayList<>();
		if(!leader.isDead()) alive.add(leader);
		for (Solider solider : army) {
			if(!solider.isDead()) alive.add(solider);
		}
		return alive;
	}
	
	public String getAliveString() {
		String result = "";
		for (Solider solider : getAlive()) {
			if(!solider.isDead()) result += solider + "\n";
		}
		return result;
	}
}
