/**

	This was written and authored by K3LLY
	please give credit 
	
	This is the lms logic of the game how the stats deaths, teleports, equipment etc is handled. 
**/


package server.model.minigames;


import java.util.ArrayList;

import server.Server;
import server.model.players.Client;
import server.model.players.Player;
import server.util.Misc;

public class LastManStanding {
	//in game player list 
	protected static ArrayList<Player> playerList = new ArrayList<Player>();
	//waiting area list 
	protected static ArrayList<Player> holdLMSList = new ArrayList<Player>();
	private LastManStandingHandler lmsH;
	private Client c;
	private Player player;
	
	//items in chest for players with key
	private final int[] chestWeapons = {14484, 13899, 13902, 15001, 15038, 15037, 11694};
	private final int[] chestArmor = {13736, 13740, 13742, 13744, 11726, 11720, 11732};
	
	public LastManStanding(Client c) {
		this.c = c;
		this.lmsH = new LastManStandingHandler(this.c);
		this.player = (Player) c;
	}
	
	//add play inits the play for the game 
	public void addPlayer() {
		holdLMSList.add(player);
		lmsH.savePlayerStats();
		boostStats();
		c.inLMS = true;
		c.specAmount = 10;
		c.playerMagicBook = 1;
		c.setSidebarInterface(6, 12855);
		startingGear();
		this.lmsH.init(holdLMSList, playerList);
	}
	
	//remove player means they are no longer in the game 
	public void removePlayer() {
		playerList.remove(playerList.indexOf(player));
		c.inLMS = false;
	}
	
	//remove player from hold list 
	public void removePlayerHold() {
		holdLMSList.remove(holdLMSList.indexOf(player));
	}
	
	//make sure the players inventory is empty before joining the game 
	public boolean checkPlayerInvenory() {
		return c.getItems().playerHasEmptyInv();
	}
	
	public void handleLogOut() {
		if(c.inLMSWaiting()) {
			removePlayerHold();
			this.lmsH.updatePlayersWaiting(this.holdLMSList, "Left");
		} else {
			removePlayer();
		}
		removeItems();
		revertStats();
		c.inLMS = false;
		c.setabsX(3088);
		c.setabsY(3497);
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
		//add items to inventory
		c.getItems().addItem(385, 1);
		c.getItems().addItem(385, 1);
		c.getItems().addItem(385, 1);
		c.getItems().addItem(9739, 1);
		c.getItems().addItem(385, 1);
		c.getItems().addItem(385, 1);
		c.getItems().addItem(385, 1);
		c.getItems().addItem(139, 1);
		c.getItems().addItem(385, 1);
		c.getItems().addItem(385, 1);
		c.getItems().addItem(385, 1);
		c.getItems().addItem(3024, 1);
		c.getItems().addItem(1215, 1);
		c.getItems().addItem(2503, 1);
		c.getItems().addItem(2617, 1);
		c.getItems().addItem(6685, 1);
		c.getItems().addItem(9185, 1);
		c.getItems().addItem(385, 1);
		c.getItems().addItem(385, 1);
		c.getItems().addItem(385, 1);
		c.getItems().addItem(385, 1);
		c.getItems().addItem(385, 1);
		c.getItems().addItem(385, 1);
		c.getItems().addItem(560, 10000);
		c.getItems().addItem(555, 10000);
		c.getItems().addItem(565, 10000);
		
		
		
		
		//to set equipment: 0 = head. 1 = cape 2 = neckless slot, 3= weapon, 4 = body, 5 = shield, 6 = null, 
		//7 = legs, 8 = ring, 9 = gloves, 10 = boots, 11 = null, 12 = ring, 13 = arrows
		c.getItems().setEquipment(10828, 1, 0);
		c.getItems().setEquipment(13734, 1, 5);
		c.getItems().setEquipment(1704, 1, 2);
		c.getItems().setEquipment(4710, 1, 3);
		c.getItems().setEquipment(4091, 1, 4);
		c.getItems().setEquipment(4093, 1, 7);
		c.getItems().setEquipment(7462, 1, 9);
		c.getItems().setEquipment(3105, 1, 10);
		c.getItems().setEquipment(2414, 1, 1);
		c.getItems().setEquipment(6737, 1, 12);
		c.getItems().setEquipment(9244, 5000, 13);
		c.getItems().getBonus();
		c.getItems().resetBonus();
		c.getItems().getBonus();
		c.getItems().writeBonus();
		c.getCombat().getPlayerAnimIndex(c.getItems().getItemName(c.playerEquipment[c.playerWeapon]).toLowerCase());
		c.getPA().requestUpdates();
	}
	
	//remove all the items 
	public void removeItems() {
		c.getItems().deleteAllItems();
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
	
	public void giveKey() {
		c.getItems().addItem(601, 1);
	}
	
	//revert the players stats to what they were before the game 
	public void revertStats() {
		lmsH.getStatsFromFile();
	}
	
	//test to make sure they get something will make array with all items for chest later 
	public void getItemFromChest() {
		int randomWeapon = (int) Math.floor(Math.random()*chestWeapons.length);
		int randomArmor = (int) Math.floor(Math.random()*chestArmor.length);
		c.getItems().deleteItem(601, 1);
		c.getItems().addItem(chestWeapons[randomWeapon], 1);
		c.getItems().addItem(chestArmor[randomArmor], 1);
		c.startAnimation(832);
		
	}
	
	public void resetHealth() {
		c.getPA().resetDamageDone();
		c.specAmount = 10;
		c.getItems().addSpecialBar(c.playerEquipment[c.playerWeapon]);
		c.attackTimer = 10;
	}
	
	public void checkWin() {
		if(this.playerList.size() == 1) {
			c.forcedText = "I HAVE WON LMS!! I CAN'T BE STOPPED!";
			c.forcedChatUpdateRequired = true;
			c.updateRequired = true;
			this.removeItems();
			this.removePlayer();
			c.getPA().movePlayer(3095, 3486, 0);
			c.faceUpdate(-1);
			c.getPA().resetAnimation();
			c.isSkulled = false;
			c.headIconPk = -1; 
			c.skullTimer = -1;
			this.resetHealth();
			this.lmsH.setCurrentGame(false);
			c.lmsScore += 1;
		}
	}
	
	public ArrayList<Player> getGameList() {
		return this.playerList;
	}
}