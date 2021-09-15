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
import java.util.ArrayList;
import java.util.List;
import server.Server;
import server.util.Misc;
import server.model.players.Client;
import server.model.players.Player;

public class LastManStandingHandler {
	final public int MAX_GAME_SIZE = 4; //ho wmany plays you want in the game max = 12!!!
	boolean saved = false;
	private Client c;
	private static boolean currentGame = false;
	//top 5 players for lms scores 
	private static int[] hPlayerScore = new int[5];
	private static String[] hPlayerName = new String[5];
	
	private int[][] spawnPoints = {{2816, 3347},{2822, 3349}, {2816, 3333}, {2822, 3337}, {2848, 3337}, {2854, 3335}, {2866, 3383}, 
									{2861, 3384}, {2847, 3387}, {2839, 3392}, {2808, 3378}, {2809, 3372}};
	
	public LastManStandingHandler(Client c) {
		this.c = c;
	}
	
	//for manager initalized right at the start of the server 
	public LastManStandingHandler() {
		this.getLMSHighScores();
	}
	
	//get the highscores for all lms players and save them into the hPlayerScore array and the hPlayerName array 
	private void getLMSHighScores() {
		String line = "";
		String token = "";
		String token2 = "";
		String[] token3 = new String[3];
		boolean EndOfFile = false;
		BufferedReader characterfile = null;
		try {	
			characterfile = new BufferedReader(new FileReader("./Data/lms/HighScores/highscores.txt"));
			
			int i = 0;
			while(EndOfFile == false && line != null && i < this.hPlayerName.length) {
				
				//try to read the file line by line 
				try {
					line = characterfile.readLine();
				} catch(IOException ioexception1) { 
					EndOfFile = true; 
				}
				
				
				line = line.trim();
				int spot = line.indexOf("=");
				if (spot > -1) {
					token = line.substring(0, spot);
					token = token.trim();
					token2 = line.substring(spot + 1);
					token2 = token2.trim();
					this.hPlayerName[i] = token;
					this.hPlayerScore[i] = Integer.parseInt(token2);
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			Misc.println("Character file is not found");
		}
		try { characterfile.close(); } catch(IOException ioexception) { Misc.println("Error closing character file."); }
	}
	
	//check if its a highscore for lms scores 
	public void isHighScore(int score, String name) {
		//if it does not beat the lowest score its not a highscore 
		if(score < this.hPlayerScore[4]) {
			return;
		} else {
			this.addToHighScore(score, name);
		}
	}
	
	//add name to highscores arrays 
	private void addToHighScore(int score, String name) {
		this.hPlayerName[4] = name;
		this.hPlayerScore[4] = score;
		this.sortHighScores();
		this.printHighLMSHighScores();
		this.saveLMSHighScores();
	}
	
	//save the highscores to file 
	private void saveLMSHighScores() {
		BufferedWriter lmsFile = null;
		try {
			lmsFile = new BufferedWriter(new FileWriter("./Data/lms/HighScores/highscores.txt"));
			for(int i = this.hPlayerScore.length-1; i >= 0 ; i--) {
				lmsFile.write(this.hPlayerName[i] + " = " + this.hPlayerScore[i]);
				lmsFile.newLine();
			}
			lmsFile.close();
		} catch(IOException e) {
			Misc.println("Error saving LMS HighScores.");
		}
	}
	
	//bubble sort to sort the top names no longer then length =5 so bubble is fine
	private void sortHighScores() {
		int n = this.hPlayerScore.length;
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n-i-1; j++) {
				if(this.hPlayerScore[j] > this.hPlayerScore[j+1]) {
					int tempScore = this.hPlayerScore[j];
					String tempName = this.hPlayerName[j];
					this.hPlayerScore[j] = this.hPlayerScore[j+1];
					this.hPlayerScore[j+1] = tempScore;
					this.hPlayerName[j] = this.hPlayerName[j+1];
					this.hPlayerName[j+1] = tempName;
				}
			}
		}
	}
	
	//for printing all the highscores to the consol 
	private void printHighLMSHighScores() {
		for(int i = 0; i < this.hPlayerScore.length; i++) {
			Misc.println(this.hPlayerName[i] +" : " +this.hPlayerScore[i]);
		}
	}
	
	
	//save the current stats for the player in a file located in the data/lms directory 
	public void savePlayerStats() {
		BufferedWriter characterfileR;
		File characterFile ;
		try {
			characterFile = new File("./Data/lms/"+c.playerName+".txt");
		
			if(characterFile.createNewFile()) {
				Misc.println("[LMS FILE] creating new lms file");
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
	
	//init the match when ready main controller for handling the start of the game 
	public void init(ArrayList<Player> list, ArrayList<Player> gameList) {
		this.updatePlayersWaiting(list, "Added");
	}
	
	//to start the game called from the process in lmsManager
	public void process(ArrayList<Player> list, ArrayList<Player> gameList) {
		if (list.size() >= MAX_GAME_SIZE && !currentGame) {
			this.addPlayersToGameList(list, gameList);
			this.setSpawnLocation(gameList);
			this.updatePlayersWaiting(list, "Removed");
			this.currentGame = true;
		}
	}
	
	//update all the players waiting
	public void updatePlayersWaiting(ArrayList<Player> list, String str) {
		for(int i = 0; i < list.size(); i++) {
			Client client = (Client) list.get(i);
			int length = list.size();
			int playersRemaining = MAX_GAME_SIZE - length;
			if (playersRemaining > 0) {
				client.sendMessage("@blu@Player " + str + length + "/" + MAX_GAME_SIZE + " players ready");
				client.sendMessage("@blu@Still need " + playersRemaining + " players");
			} else {
				client.sendMessage("@blu@Waiting for game to finish, players get Ready!");
			}
		}
	}
	
	
	//remove players from waiting lsit and add them to the game list 
	private void addPlayersToGameList(ArrayList<Player> list, ArrayList<Player> gameList) {
		
		//add players to game list 
		for(int i = 0; i < MAX_GAME_SIZE; i++) {
			Player p = list.get(i);
			gameList.add(p);
		}
		
		List<Player> subList = list.subList(0, MAX_GAME_SIZE);
		subList.clear();
		
	}
	
	
	//spawn the players to their starting locations 
	private void setSpawnLocation(ArrayList<Player> gameList) {
		for(int i = 0; i < gameList.size(); i++) {
			Client c = (Client) gameList.get(i);
			c.getPA().movePlayer(spawnPoints[i][0], spawnPoints[i][1], 0);
		}
	}
	
	public void setCurrentGame(boolean state) {
		this.currentGame = state;
	}
}




