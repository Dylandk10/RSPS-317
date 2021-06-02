/**

	This was written and authored by K3LLY
	please give credit 
	
	
	This is for all the file handling for last man standing mini game. 
	This file will also handle the bugs and illegal operations of the game
**/


package server.model.minigames;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import server.Server;
import server.util.Misc;
import server.model.players.Client;

public class LastManStandingHandler {
	boolean saved = false;
	private Client c;
	
	public LastManStandingHandler(Client c) {
		this.c = c;
	}
	
	
	//save the current stats for the player in a file located in the data/lms directory 
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
	
	//read the stats from file and reassign the to the player 
	public void getStatsFromFile() {
		String line = "";
		String token = "";
		String token2 = "";
		String[] token3 = new String[3];
		boolean EndOfFile = false;
		BufferedReader characterfile = null;
		try {	
			characterfile = new BufferedReader(new FileReader("./Data/lms/"+c.playerName+".txt"));
			
			
			while(EndOfFile == false && line != null) {
				line = line.trim();
				int spot = line.indexOf("=");
				if (spot > -1) {
					token = line.substring(0, spot);
					token = token.trim();
					token2 = line.substring(spot + 1);
					token2 = token2.trim();
					token3 = token2.split("\t");
					c.playerLevel[Integer.parseInt(token3[0])] = Integer.parseInt(token3[1]);
					c.playerXP[Integer.parseInt(token3[0])] = Integer.parseInt(token3[2]);
					c.getPA().refreshSkill(Integer.parseInt(token3[0]));
					c.updateRequired = true;
				}
				try {
					line = characterfile.readLine();
				} catch(IOException ioexception1) { 
					EndOfFile = true; 
				}
			}
		} catch (FileNotFoundException e) {
			Misc.println("Character file is not found");
		}
		try { characterfile.close(); } catch(IOException ioexception) { Misc.println("Error closing character file."); }
	}
	
}