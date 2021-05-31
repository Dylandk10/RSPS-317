/**

	This was written and authored by K3LLY
	please give credit 
	
	This is the lms logic of the game how the stats deaths, teleports, equipment etc is handled. 
**/


package server.model.minigames;


import java.util.ArrayList;

import server.Server;
import server.model.players.Client;
import server.util.Misc;

public class LastManStanding {
	///list to hold players 
	public ArrayList<Integer> playerList = new ArrayList<Integer>();
	private LastManStandingHandler lmsH;
	private Client c;
	
	public LastManStanding(Client c) {
		this.c = c;
		this.lmsH = new LastManStandingHandler(this.c);
	}
	
	//add play inits the play for the game 
	public void addPlayer() {
		playerList.add(c.playerId);
		//lmsH.savePlayerStats();
		boostStats();
		//revertStats();
		c.inLMS = true;
		startingGear();
	}
	
	//remove player means they are no longer in the game 
	public void removePlayer() {
		playerList.remove(playerList.indexOf(c.playerId));
	}
	
	//make sure the players inventory is empty before joining the game 
	public boolean checkPlayerInvenory() {
		return c.getItems().playerHasEmptyInv();
	}
	
	
	//make sure the player is bring no equipment into the game 
	public boolean checkIfPlayerIsWearingItems() {
		if(c.playerEquipment[c.playerHat] > 0 || c.playerEquipment[c.playerCape] > 0 || c.playerEquipment[c.playerHat] > 0 || c.playerEquipment[c.playerAmulet] > 0 || c.playerEquipment[c.playerArrows] > 0 || c.playerEquipment[c.playerChest] > 0 || c.playerEquipment[c.playerShield] > 0 || c.playerEquipment[c.playerLegs] > 0 || c.playerEquipment[c.playerHands] > 0 || c.playerEquipment[c.playerFeet] > 0 || c.playerEquipment[c.playerRing] > 0 || c.playerEquipment[c.playerWeapon] > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//give the starting gear to a player entering the areana 
	public void startingGear() {
		//c.getItems.addItem(4091, 1);
		//c.getItems.addItem(4093, 1);
		//c.getItems.addItem(4095, 1);
		//c.getItems.addItem(3105, 1);
		
		//to set equipment 
		//getItems().setEquipment(playerEquipment[playerRing],1,playerRing);
	}
	
	//boost the players stats to 99 
	public void boostStats() {
		c.playerXP[0] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[0] = c.getPA().getLevelForXP(c.playerXP[0]);
		c.getPA().refreshSkill(0);
		c.playerXP[1] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[1] = c.getPA().getLevelForXP(c.playerXP[1]);
		c.getPA().refreshSkill(1);
		c.playerXP[2] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[2] = c.getPA().getLevelForXP(c.playerXP[2]);
		c.getPA().refreshSkill(2);
		c.playerXP[3] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[3] = c.getPA().getLevelForXP(c.playerXP[3]);
		c.getPA().refreshSkill(3);
		c.playerXP[4] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[4] = c.getPA().getLevelForXP(c.playerXP[4]);
		c.getPA().refreshSkill(4);
		c.playerXP[5] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[5] = c.getPA().getLevelForXP(c.playerXP[5]);
		c.getPA().refreshSkill(5);
		c.playerXP[6] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[6] = c.getPA().getLevelForXP(c.playerXP[6]);
		c.getPA().refreshSkill(6);
		c.playerXP[7] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[7] = c.getPA().getLevelForXP(c.playerXP[7]);
		c.getPA().refreshSkill(7);
		c.playerXP[8] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[8] = c.getPA().getLevelForXP(c.playerXP[8]);
		c.getPA().refreshSkill(8);
		c.playerXP[9] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[9] = c.getPA().getLevelForXP(c.playerXP[9]);
		c.getPA().refreshSkill(9);
		c.playerXP[10] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[10] = c.getPA().getLevelForXP(c.playerXP[10]);
		c.getPA().refreshSkill(10);
		c.playerXP[11] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[11] = c.getPA().getLevelForXP(c.playerXP[11]);
		c.getPA().refreshSkill(11);
		c.playerXP[12] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[12] = c.getPA().getLevelForXP(c.playerXP[12]);
		c.getPA().refreshSkill(12);
		c.playerXP[13] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[13] = c.getPA().getLevelForXP(c.playerXP[13]);
		c.getPA().refreshSkill(13);
		c.playerXP[14] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[14] = c.getPA().getLevelForXP(c.playerXP[14]);
		c.getPA().refreshSkill(14);
		c.playerXP[15] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[15] = c.getPA().getLevelForXP(c.playerXP[15]);
		c.getPA().refreshSkill(15);
		c.playerXP[16] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[16] = c.getPA().getLevelForXP(c.playerXP[16]);
		c.getPA().refreshSkill(16);
		c.playerXP[17] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[17] = c.getPA().getLevelForXP(c.playerXP[17]);
		c.getPA().refreshSkill(17);
		c.playerXP[18] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[18] = c.getPA().getLevelForXP(c.playerXP[18]);
		c.getPA().refreshSkill(18);
		c.playerXP[19] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[19] = c.getPA().getLevelForXP(c.playerXP[19]);
		c.getPA().refreshSkill(19);
		c.playerXP[20] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[20] = c.getPA().getLevelForXP(c.playerXP[20]);
		c.getPA().refreshSkill(20);
		c.playerXP[21] = c.getPA().getXPForLevel(99)+5;
		c.playerLevel[21] = c.getPA().getLevelForXP(c.playerXP[21]);
		c.getPA().refreshSkill(21);
		c.updateRequired = true;
		c.setAppearanceUpdateRequired(true);
	}
	
	//revert the players stats to what they were before the game 
	public void revertStats() {
		lmsH.getStatsFromFile();
	}
}