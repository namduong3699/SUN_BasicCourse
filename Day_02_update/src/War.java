public class War {
	private String name;
	private Team teamA;
	private Team teamB;
	private static int warDame = 20;
	
	public War(String name, Team teamA, Team B) {
		this.name = name;
		this.teamA = teamA;
		this.teamB = B;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeamA() {
		return teamA;
	}

	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}

	public Team getTeamB() {
		return teamB;
	}

	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}

	public String toString() {
		return teamA.toString() + "\n" + teamB.toString();
	}
	
	public void fight() {
		while(!teamA.isLose() || !teamA.isLose()) {
			Solider soliderA = this.teamA.getSoliderToFight();
			Solider soliderB = this.teamB.getSoliderToFight();
			soliderFight(soliderA, soliderB);
		}
		
	}
	
	public void soliderFight(Solider soliderA, Solider soliderB) {
		if(soliderA.getDefend() > soliderB.getAttack() && soliderA.getAttack() >= soliderB.getDefend()) {  //	soliderA thắng soliderB
			soliderB.dead();
			soliderA.damage(warDame);
		} else if (soliderB.getDefend() > soliderA.getAttack() && soliderB.getAttack() >= soliderA.getDefend()) {  //	soliderA thua soliderB
			soliderA.dead();
			soliderB.damage(warDame);
		} else if(soliderA.getStrength() > soliderB.getStrength()) {
			soliderB.dead();
			soliderA.damage(warDame);
		} else if(soliderB.getStrength() > soliderA.getStrength()) {
			soliderA.dead();
			soliderB.damage(warDame);
		} else {
			soliderA.dead();
			soliderB.dead();
		}
	}
	
	public String result() {
		if(teamA.isLose()) {
			return "Team " + teamB.getName() + " Win" + "\n" + teamB.getAliveString();
		} else if(teamB.isLose()) {
			return "Team " + teamA.getName() + " Win" + "\n" + teamA.getAliveString();
		}
		return "";
	}
}
