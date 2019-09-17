import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class fileOpen {
	public static Team loadTeam(String path) {
		try {
			File file = new File(path);
			Scanner in = new Scanner(file);		
			in.next();
			String name = in.next();
			int quantity = Integer.parseInt(in.next()); 
			ArmyGeneral leader = null;
			ArrayList<Solider> army = new ArrayList<>();
			String type, code = "";
			Double attack, defend;
			int strength;
			boolean equipment;
			for(int i = 0; i < quantity; i++) {
				type = in.next();
				code = in.next();
				attack = Double.parseDouble(in.next());
				defend = Double.parseDouble(in.next());
				if(in.next().equals("YES")) {
					equipment = true;
				} else {
					equipment = false;
				}
				strength = Integer.parseInt(in.next());
				
				if(type.equals("AG")) {
					leader = new ArmyGeneral(code, attack, defend, true, strength, Double.parseDouble(in.next()));
				} else if(type.equals("V")) {
					Valiant V = new Valiant(code, attack, defend, equipment, strength);
					army.add(V);
				} else if(type.equals("A")) {
					Archer A = new Archer(code, attack, defend, equipment, strength);
					army.add(A);
				} else if(type.equals("K")) {
					Knight K = new Knight(code, attack, defend, equipment, strength);
					army.add(K);
				}
			}		
			in.close();
			return new Team(name, leader, army);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void warResultToFile(War war, String path) {
		try {
			Path filePath = Paths.get(path);
			Files.writeString(filePath, war.result(), StandardOpenOption.TRUNCATE_EXISTING);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
