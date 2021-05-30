/**

	This was written and authored by K3LLY
	please give credit 
**/


package server.model.minigames;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import server.Server;
import server.util.Misc;
import server.model.players.Client;

public class LastManStandingHandler {
	boolean saved = false;
	private Client c;
	
	public LastManStandingHandler(Client c) {
		this.c = c;
		Misc.println("LastManStandingHandler Running...");
	}
	
	public void savePlayerStats() {
		BufferedWriter characterfileR;
		File characterFile ;
		try {
			characterFile = new File("./Data/lms/"+c.playerName+".txt");
		
			if(characterFile.createNewFile()) {
				Misc.println("creating new lms file");
				characterfileR = new BufferedWriter(new FileWriter("./Data/lms/"+c.playerName+".txt"));
				for (int i = 0; i < c.playerLevel.length; i++) {
					characterfileR.write("character-skill = ", 0, 18);
					characterfileR.write(Integer.toString(i), 0, Integer.toString(i).length());
					characterfileR.write("	", 0, 1);
					characterfileR.write(Integer.toString(c.playerLevel[i]), 0, Integer.toString(c.playerLevel[i]).length());
					characterfileR.write("	", 0, 1);
					characterfileR.write(Integer.toString(c.playerXP[i]), 0, Integer.toString(c.playerXP[i]).length());
					characterfileR.newLine();
				}
			
			} else {
				Misc.println("lms files already exist");
				characterfileR = new BufferedWriter(new FileWriter("./Data/lms/"+c.playerName+".txt"));
			
				for (int i = 0; i < c.playerLevel.length; i++) {
					characterfileR.write("character-skill = ", 0, 18);
					characterfileR.write(Integer.toString(i), 0, Integer.toString(i).length());
					characterfileR.write("	", 0, 1);
					characterfileR.write(Integer.toString(c.playerLevel[i]), 0, Integer.toString(c.playerLevel[i]).length());
					characterfileR.write("	", 0, 1);
					characterfileR.write(Integer.toString(c.playerXP[i]), 0, Integer.toString(c.playerXP[i]).length());
					characterfileR.newLine();
				}
			}
			
			characterfileR.close();
			
		} catch (IOException e) {
			Misc.println("Fatal Error: file for lms is broken.");
		}
	}
	
	
}