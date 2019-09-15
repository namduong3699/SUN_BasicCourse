import java.util.ArrayList;
import java.util.Scanner;

public class Team {
	private String name;
	private ArmyGeneral leader;
	private ArrayList<Brawler> army = new ArrayList<>();
	
	public Team() {
		
	}
	
	public Team(String name, ArmyGeneral armyGeneral, ArrayList<Brawler> army) {
		this.setName(name);
		this.leader = armyGeneral;
		this.army = army;
	}
	
	public void input(Scanner in) {
//		try {
//			Scanner in = new Scanner(file);
//			System.out.println(file.getName());
			in.next();
			this.setName(in.next());
			int quantity = Integer.parseInt(in.next()); 
			String temp = "";
			for(int i = 0; i < quantity; i++) {
				temp = in.next();
				if(temp.equals("AG")) {
					ArmyGeneral AG = new ArmyGeneral();
					AG.input(in);
					leader = AG;
					army.add(AG);
				} else if(temp.equals("V")) {
					Valiant V = new Valiant();
					V.input(in);
					army.add(V);
				} else if(temp.equals("A")) {
					Archer A = new Archer();
					A.input(in);
					army.add(A);
				} else if(temp.equals("K")) {
					Knight K = new Knight();
					K.input(in);
					army.add(K);
				}
			}
//		} catch (Exception e) {
//			System.out.println("Team-input: " + e);
//		}
		//Nhập tên, số lượng
		//for (số lượng) 
//		army.add(new Brawler)
//		army.get(i).input()
	}
	
	public void getInfo() {
//		leader.getInfo();
		for(Brawler brawler: army) {
			brawler.getInfo();
		}
	}
	
	public boolean isLose() {
		if(army.isEmpty()) return true;
		else return false;
	}
	
	public Brawler getBrawler() {
		return (army.size() > 0) ? army.get(army.size() - 1) : null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void remove(Brawler brawler) {
		army.remove(brawler);
	}
	
	public void damage(Brawler brawler) {
		army.get(army.indexOf(brawler)).damage();
	}
}
