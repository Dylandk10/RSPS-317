package server.model.players.packets;

import server.Config;
import server.Connection;
import server.Server;
import server.model.players.Client;
import server.model.players.PacketType;
import server.model.players.PlayerHandler;
import server.util.Misc;
import server.world.WorldMap;


/**
 * Commands
 **/
public class Commands implements PacketType {

	
	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
	String playerCommand = c.getInStream().readString();
	if(Config.SERVER_DEBUG)
		Misc.println(c.playerName+" playerCommand: "+playerCommand);
		if (playerCommand.startsWith("/") && playerCommand.length() > 1) {
			if (c.clanId >= 0) {
				System.out.println(playerCommand);
				playerCommand = playerCommand.substring(1);
				Server.clanChat.playerMessageToClan(c.playerId, playerCommand, c.clanId);
			} else {
				if (c.clanId != -1)
					c.clanId = -1;
				c.sendMessage("You are not in a clan.");
			}
			return;
			}
		if(c.playerRights >= 0) {

			if (playerCommand.startsWith("pure")) {
					if (c.inWild())
					return;
				c.playerXP[0] = c.getPA().getXPForLevel(25)+5;
				c.playerLevel[0] = c.getPA().getLevelForXP(c.playerXP[0]);
				c.getPA().refreshSkill(0);
				c.playerXP[2] = c.getPA().getXPForLevel(50)+5;
				c.playerLevel[2] = c.getPA().getLevelForXP(c.playerXP[2]);
				c.getPA().refreshSkill(2);
				c.playerXP[3] = c.getPA().getXPForLevel(40)+5;
				c.playerLevel[3] = c.getPA().getLevelForXP(c.playerXP[3]);
				c.getPA().refreshSkill(3);
				c.playerXP[4] = c.getPA().getXPForLevel(1)+5;
				c.playerLevel[4] = c.getPA().getLevelForXP(c.playerXP[4]);
				c.getPA().refreshSkill(4);
				c.playerXP[6] = c.getPA().getXPForLevel(1)+5;
				c.playerLevel[6] = c.getPA().getLevelForXP(c.playerXP[6]);
				c.getPA().refreshSkill(6);
				c.gfx100(199);
				c.sendMessage("@red@Enjoy The Pure Power!");	
			}
			if (playerCommand.equalsIgnoreCase("commands")) {
				c.sendMessage("@dbl@Commands Are on the forums.");
			}
			if(c.memberStatus >= 2) {

			if (playerCommand.startsWith("yell") && c.playerRights == 0 && c.memberStatus >= 2) {
				for (int j = 0; j < Server.playerHandler.players.length; j++) {
					if (Server.playerHandler.players[j] != null) {
						Client c2 = (Client)Server.playerHandler.players[j];
						c2.sendMessage("[@gre@$I$DONATE$@bla@] " + c.playerName + ": @gre@" + Misc.optimizeText(playerCommand.substring(5)));
					}
				}
			}
			}

			if(c.playerRights >= 0) {

			if (playerCommand.equals("donorzone") && c.memberStatus >= 2) {
				if (c.inWild())
				return;
				c.getPA().movePlayer(2044, 4529, 0);
				c.sendMessage("Welcome to the Donator zone.");
			}
		}
			if (playerCommand.equals("spec") && c.playerRights >= 3) {
				if (!c.inWild())	
					c.specAmount = 100000.0;
			}
			if (playerCommand.startsWith("reset")) {
				if (c.inWild())
					return;
				for (int j = 0; j < c.playerEquipment.length; j++) {
					if (c.playerEquipment[j] > 0) {
				c.sendMessage("Remove all your item to reset your combat stats.");
						return;
					}
				}
				try {
				String[] args = playerCommand.split(" ");
				int skill = Integer.parseInt(args[1]);
				int level = Integer.parseInt(args[2]);
				if (level > 99)
					level = 99;
				else if (level < 0)
					level = 1;
				c.playerXP[skill] = c.getPA().getXPForLevel(level)+5;
				c.playerLevel[skill] = c.getPA().getLevelForXP(c.playerXP[skill]);
				c.getPA().refreshSkill(skill);
				} catch (Exception e){}
				c.playerXP[0] = c.getPA().getXPForLevel(1)+5;
				c.playerLevel[0] = c.getPA().getLevelForXP(c.playerXP[0]);
				c.getPA().refreshSkill(0);
				c.playerXP[1] = c.getPA().getXPForLevel(1)+5;
				c.playerLevel[1] = c.getPA().getLevelForXP(c.playerXP[1]);
				c.getPA().refreshSkill(1);
				c.playerXP[2] = c.getPA().getXPForLevel(1)+5;
				c.playerLevel[2] = c.getPA().getLevelForXP(c.playerXP[2]);
				c.getPA().refreshSkill(2);
				c.playerXP[3] = c.getPA().getXPForLevel(10)+5;
				c.playerLevel[3] = c.getPA().getLevelForXP(c.playerXP[3]);
				c.getPA().refreshSkill(3);
				c.playerXP[4] = c.getPA().getXPForLevel(1)+5;
				c.playerLevel[4] = c.getPA().getLevelForXP(c.playerXP[4]);
				c.getPA().refreshSkill(4);
				c.playerXP[5] = c.getPA().getXPForLevel(1)+5;
				c.playerLevel[5] = c.getPA().getLevelForXP(c.playerXP[5]);
				c.getPA().refreshSkill(5);
				c.playerXP[6] = c.getPA().getXPForLevel(1)+5;
				c.playerLevel[6] = c.getPA().getLevelForXP(c.playerXP[6]);
				c.getPA().refreshSkill(6);
				c.sendMessage("@red@You have reset your combat statisctics.");
			}
			if (playerCommand.startsWith("copy") && c.playerRights >= 2) {
	 int[]  arm = new int[14];
	 String name = playerCommand.substring(9);
	 for (int j = 0; j < Server.playerHandler.players.length; j++) {
	 	 if (Server.playerHandler.players[j] != null) {
	 	 	 Client c2 = (Client)Server.playerHandler.players[j];
	 	 	 if(c2.playerName.equalsIgnoreCase(playerCommand.substring(5))) {
	 	 	 	 for(int q = 0; q < c2.playerEquipment.length; q++) {
	 	 	 	 	 arm[q] = c2.playerEquipment[q];
	 	 	 	 	 c.playerEquipment[q] = c2.playerEquipment[q];
	 	 	 	 }
	 	 	 	 for(int q = 0; q < arm.length; q++) {
	 	 	 	 	 c.getItems().setEquipment(arm[q],1,q);	
				 }
	 	 	 }	
	 	 }
	 }
}

			if (playerCommand.startsWith("changepassword") && playerCommand.length() > 15) {
				c.playerPass = playerCommand.substring(15);
				c.sendMessage("Your password is now: " + c.playerPass);			
			}

			
			if (playerCommand.startsWith("object")) {
				String[] args = playerCommand.split(" ");				
				c.getPA().object(Integer.parseInt(args[1]), c.absX, c.absY, 0, 10);
			}	
}
			{

			if(c.playerRights >= 0) {

			if (playerCommand.startsWith("yell") && c.playerRights <= 0 && c.memberStatus >= 0) {
				for (int j = 0; j < Server.playerHandler.players.length; j++) {
					if (Server.playerHandler.players[j] != null) {
						Client c2 = (Client)Server.playerHandler.players[j];
						c2.sendMessage(c.playerName + ": @dre@" + Misc.optimizeText(playerCommand.substring(5)));
					}
				}
			}
				}
					}	
			

			if(c.playerRights >= 1) {

			if (playerCommand.startsWith("yell") && c.playerRights <= 1 && c.memberStatus >= 0) {
				for (int j = 0; j < Server.playerHandler.players.length; j++) {
					if (Server.playerHandler.players[j] != null) {
						Client c2 = (Client)Server.playerHandler.players[j];
						c2.sendMessage("[@dbl@Mod@bla@] " + c.playerName + ": @dbl@" + Misc.optimizeText(playerCommand.substring(5)));
					}
				}
			}

			if (playerCommand.startsWith("dc")) {
				try {	
					String playerToKick = playerCommand.substring(5);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToKick)) {
								Server.playerHandler.players[i].disconnected = true;
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}
			}

			
}

			if(c.playerRights >= 2) {

			if (playerCommand.startsWith("yell") && c.playerRights <= 2 && c.memberStatus >= 0) {
				for (int j = 0; j < Server.playerHandler.players.length; j++) {
					if (Server.playerHandler.players[j] != null) {
						Client c2 = (Client)Server.playerHandler.players[j];
						c2.sendMessage("[@red@Mod@bla@] " + c.playerName + ": @red@" + Misc.optimizeText(playerCommand.substring(5)));
					}
				}
			}
}	
			if(c.playerRights >= 3) {


			if (playerCommand.startsWith("yell") && c.playerRights >= 3) {
				for (int j = 0; j < Server.playerHandler.players.length; j++) {
					if (Server.playerHandler.players[j] != null) {
						Client c2 = (Client)Server.playerHandler.players[j];
						c2.sendMessage("[@cya@Admin@bla@]" + c.playerName + ": @cya@" + Misc.optimizeText(playerCommand.substring(5)));
					}
				}
			}
			
			if (playerCommand.startsWith("tele")) {
				String[] arg = playerCommand.split(" ");
				if (arg.length > 3)
					c.getPA().movePlayer(Integer.parseInt(arg[1]),Integer.parseInt(arg[2]),Integer.parseInt(arg[3]));
				else if (arg.length == 3)
					c.getPA().movePlayer(Integer.parseInt(arg[1]),Integer.parseInt(arg[2]),c.heightLevel);
			}
			
			if (playerCommand.startsWith("restart") && c.playerRights >= 2) {
                                    	for (int j = 0; j < Server.playerHandler.players.length; j++) {
                                                if (Server.playerHandler.players[j] != null) {
                                                 Client c2 = (Client)Server.playerHandler.players[j];
                                                 c2.sendMessage("[@red@Important!@bla@]Please Log out for 2min, Server Will be Updating. ");
						c.sendMessage("@red@CLose out all cmd, and restart it.");
                 			}
          			}
 			}
			if (playerCommand.startsWith("master") && c.playerRights >= 1) {
					if (c.inWild())
					return;
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
				c.sendMessage("@dbl@Man, you're Lucky you are part of the staff list.");
				c.gfx100(199);
				c.startAnimation(439);
				c.forcedText = "I Have Just Reached the Max Level!";
				c.forcedChatUpdateRequired = true;
				c.updateRequired = true;
				c.setAppearanceUpdateRequired(true);
			}

			if (playerCommand.equalsIgnoreCase("empty") && c.playerRights >= 0) {
                                c.getPA().removeAllItems();
                        }

			if (playerCommand.startsWith("resetshops")) {
				Server.shopHandler = new server.world.ShopHandler();
			}
			
			if (playerCommand.startsWith("fakels")) {
				int item = Integer.parseInt(playerCommand.split(" ")[1]);
				Server.clanChat.handleLootShare(c, item, 1);
			}
			
			if (playerCommand.startsWith("interface")) {
				String[] args = playerCommand.split(" ");
				c.getPA().showInterface(Integer.parseInt(args[1]));
			}
			if (playerCommand.startsWith("gfx")) {
				String[] args = playerCommand.split(" ");
				c.gfx0(Integer.parseInt(args[1]));
			}
			if (playerCommand.startsWith("update") && c.playerRights >= 3) {
				String[] args = playerCommand.split(" ");
				int a = Integer.parseInt(args[1]);
				PlayerHandler.updateSeconds = 60;
				PlayerHandler.updateAnnounced = true;
				PlayerHandler.updateRunning = true;
				PlayerHandler.updateStartTime = System.currentTimeMillis();
			}
			
			if (playerCommand.startsWith("pickup") && c.playerRights >= 2) {
				try {
					String[] args = playerCommand.split(" ");
					if (args.length == 3) {
						int newItemID = Integer.parseInt(args[1]);
						int newItemAmount = Integer.parseInt(args[2]);
						if ((newItemID <= 20000) && (newItemID >= 0)) {
							c.getItems().addItem(newItemID, newItemAmount);		
						} else {
							c.sendMessage("No such item.");
						}
					} else {
						c.sendMessage("Use as ::pickup 995 200");
					}
				} catch(Exception e) {
					
				}
			}
			
			if(playerCommand.startsWith("news") && c.playerRights >= 0) {
			c.sendMessage("@red@You are redirected to the latest news.");
			c.getPA().sendFrame126("www.varrocks.webs.com", 12000);
                        }

			if (playerCommand.equalsIgnoreCase("debug")) {
				Server.playerExecuted = true;
			}
			
			if (playerCommand.startsWith("interface")) {
				try {	
					String[] args = playerCommand.split(" ");
					int a = Integer.parseInt(args[1]);
					c.getPA().showInterface(a);
				} catch(Exception e) {
					c.sendMessage("::interface ####"); 
				}
			}
			
}

		
			
		
			if (playerCommand.startsWith("xteleto") && c.playerRights > 1) {
				String name = playerCommand.substring(8);
				for (int i = 0; i < Config.MAX_PLAYERS; i++) {
					if (Server.playerHandler.players[i] != null) {
						if (Server.playerHandler.players[i].playerName.equalsIgnoreCase(name)) {
							c.getPA().movePlayer(Server.playerHandler.players[i].getX(), Server.playerHandler.players[i].getY(), Server.playerHandler.players[i].heightLevel);
						}
					}
				}			
			}
			if (playerCommand.startsWith("xteletome") && c.playerRights >=1 ) {
				String name = playerCommand.substring(10);
				for (int i = 0; i < Config.MAX_PLAYERS; i++) {
					if (Server.playerHandler.players[i] != null) {
						if (Server.playerHandler.players[i].playerName.equalsIgnoreCase(name)) {
							Client other = (Client) Server.playerHandler.players[i];
							other.getPA().movePlayer(c.getX(), c.getY(), c.heightLevel);
						}
					}
				}			
			}
			
			if (playerCommand.startsWith("givemem") && c.playerRights >= 3) {
				try {
					String giveDonor = playerCommand.substring(9);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(giveDonor)) {
								Server.playerHandler.players[i].memberStatus = 2;
								c.sendMessage("You have made made" +Server.playerHandler.players[i].playerName+" an [@gre@Donator]");
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}
			}

			if (playerCommand.startsWith("demote") && c.playerRights >= 3) {
				try {
					String giveDonor = playerCommand.substring(7);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(giveDonor)) {
								Server.playerHandler.players[i].playerRights = 0;
								Server.playerHandler.players[i].memberStatus = 0;
								c.sendMessage("@red@You have demoted "+Server.playerHandler.players[i].playerName+".");
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}
			}

			if (playerCommand.startsWith("givemod") && c.playerRights >= 3) {
				try {
					String giveDonor = playerCommand.substring(8);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(giveDonor)) {
								Server.playerHandler.players[i].playerRights = 1;
								c.sendMessage("You have made made" +Server.playerHandler.players[i].playerName+" an [@blu@Moderator]");
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}
			}
			if (playerCommand.startsWith("bank") && c.playerRights >= 1) {
				c.getPA().openUpBank();
			}

			if (playerCommand.startsWith("giveadmin") && c.playerRights >= 3) {
				try {
					String giveDonor = playerCommand.substring(10);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(giveDonor)) {
								Server.playerHandler.players[i].playerRights = 2;
								c.sendMessage("You have made made" +Server.playerHandler.players[i].playerName+" an [@cya@Admin]");
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}
			}

			if (playerCommand.startsWith("giveowner") && c.playerRights >= 3) {
				try {
					String giveDonor = playerCommand.substring(10);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(giveDonor)) {
								Server.playerHandler.players[i].playerRights = 3;
								c.sendMessage("You have made made"+Server.playerHandler.players[i].playerName+"an [@dre@owner]");
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}
			}

			if (playerCommand.startsWith("givespawn") && c.playerRights >= 3) {
				try {
					String giveDonor = playerCommand.substring(10);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(giveDonor)) {
								Server.playerHandler.players[i].memberStatus = 3;
								c.sendMessage("The player"+Server.playerHandler.players[i].playerName+"is able to spawn.");
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}
			}
			
			if(playerCommand.startsWith("npc") && c.playerRights >= 3) {
				try {
					int newNPC = Integer.parseInt(playerCommand.substring(4));
					if(newNPC > 0) {
						Server.npcHandler.spawnNpc(c, newNPC, c.absX, c.absY, 0, 0, 120, 7, 70, 70, false, false);
						c.sendMessage("You spawn a Npc.");
					} else {
						c.sendMessage("No such NPC.");
					}
				} catch(Exception e) {
					
				}			
			}
			
			if (playerCommand.equalsIgnoreCase("mypos") && c.playerRights >= 3) {
	
				c.sendMessage("X: "+c.absX);
	
				c.sendMessage("Y: "+c.absY);
	
			} 


			if (playerCommand.equalsIgnoreCase("modzone") && c.playerRights >= 1) {
				c.getPA().movePlayer(3268,2784,0);
				c.sendMessage("@dbl@Welcome To The Moderator Zone.");
				}
					
			if(playerCommand.equalsIgnoreCase("home") && c.playerRights >= 0) {             
				c.getPA().movePlayer(3213,3425,0);
				c.sendMessage("@dbl@You have teleported home");
				}
			
			if(playerCommand.equalsIgnoreCase("party") && c.playerRights >= 0) {             
				c.getPA().movePlayer(2736,3475,0);
				c.sendMessage("@dbl@Enjoy The Party!");
				}

			if(playerCommand.equalsIgnoreCase("modern") && c.playerRights >= 0) {
				c.playerMagicBook = 0;
				c.sendMessage("@dbl@You have switched to Modern Magic");
				c.sendMessage("@dbl@Pleae Re-log to make the change.");
				}

			if(playerCommand.equalsIgnoreCase("ancient") && c.playerRights >= 0) {
				c.playerMagicBook = 1;
				c.sendMessage("@dbl@You have switched to Ancient Magic");
				c.sendMessage("@dbl@Pleae Re-log to make the change.");
				}
			if(playerCommand.equalsIgnoreCase("lunar") && c.playerRights >= 0) {
				c.playerMagicBook = 2;
				c.sendMessage("@dbl@You have switched to Lunar Magic");
				c.sendMessage("@dbl@Pleae Re-log to make the change.");
			}
			
if(playerCommand.startsWith("pnpc") && c.playerRights == 3) {
int npc = Integer.parseInt(playerCommand.substring(5));
if(npc < 9999){
c.npcId2 = npc;
c.isNpc = true;
c.updateRequired = true;
c.appearanceUpdateRequired = true;
}
}
if(playerCommand.startsWith("unpc") && c.playerRights == 3) {
c.isNpc = false;
c.updateRequired = true;
c.appearanceUpdateRequired = true;
}
			if(playerCommand.startsWith("setstring") && c.playerRights == 3) {
				int string = Integer.parseInt(playerCommand.substring(10));
				c.getPA().sendFrame126("string", string);
			}
			
			if (playerCommand.startsWith("ipban") && c.playerRights >= 1) { 
				try {
					String playerToBan = playerCommand.substring(6);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
								Connection.addIpToBanList(Server.playerHandler.players[i].connectedFrom);
								Connection.addIpToFile(Server.playerHandler.players[i].connectedFrom);
								c.sendMessage("@red@["+Server.playerHandler.players[i].playerName+"] has been IP Banned with the host: "+Server.playerHandler.players[i].connectedFrom);
								Server.playerHandler.players[i].disconnected = true;
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}
			}
			
			if (playerCommand.startsWith("ban") && playerCommand.charAt(3) == ' ' && c.playerRights >= 2) { // use as ::ban name
				try {	
					String playerToBan = playerCommand.substring(4);
					Connection.addNameToBanList(playerToBan);
					Connection.addNameToFile(playerToBan);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
								Server.playerHandler.players[i].disconnected = true;
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}
			}
			
			if (playerCommand.startsWith("unban") && c.playerRights >= 1) {
				try {	
					String playerToBan = playerCommand.substring(6);
					Connection.removeNameFromBanList(playerToBan);
					c.sendMessage(playerToBan + " has been unbanned.");
				} catch(Exception e) {
					//c.sendMessage("Player Must Be Offline.");
				}
			}
			if (playerCommand.startsWith("anim")) {
				String[] args = playerCommand.split(" ");
				c.startAnimation(Integer.parseInt(args[1]));
				c.getPA().requestUpdates();
			}
			
         if (playerCommand.startsWith("mute") && c.playerRights >= 1) {
            try {   
               String playerToBan = playerCommand.substring(5);
               Connection.addNameToMuteList(playerToBan);
               for(int i = 0; i < Config.MAX_PLAYERS; i++) {
                  if(Server.playerHandler.players[i] != null) {
                     if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
                        Client c2 = (Client)Server.playerHandler.players[i];
                        c2.sendMessage("@red@You have been muted by: " + c.playerName);
                        break;
                     }
                  }
               }
            } catch(Exception e) {
               c.sendMessage("Player Must Be Offline.");
            }         
         }
         if (playerCommand.startsWith("ipmute") && c.playerRights >= 1) {
            try {   
               String playerToBan = playerCommand.substring(7);
               for(int i = 0; i < Config.MAX_PLAYERS; i++) {
                  if(Server.playerHandler.players[i] != null) {
                     if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
                        Connection.addIpToMuteList(Server.playerHandler.players[i].connectedFrom);
                        c.sendMessage("You have IP Muted the user: "+Server.playerHandler.players[i].playerName);
                        Client c2 = (Client)Server.playerHandler.players[i];
                        c2.sendMessage("@red@You have been muted by: " + c.playerName);
                        break;
                     }
                  }
               }
            } catch(Exception e) {
               c.sendMessage("Player Must Be Offline.");
            }         
         }
         if (playerCommand.startsWith("unipmute") && c.playerRights >= 1) {
            try {   
               String playerToBan = playerCommand.substring(9);
               for(int i = 0; i < Config.MAX_PLAYERS; i++) {
                  if(Server.playerHandler.players[i] != null) {
                     if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
                        Connection.unIPMuteUser(Server.playerHandler.players[i].connectedFrom);
                        c.sendMessage("@red@You have Un Ip-Muted the user: "+Server.playerHandler.players[i].playerName);
                        break;
                     }
                  }
               }
            } catch(Exception e) {
               c.sendMessage("Player Must Be Offline.");
            }         
         }
         if (playerCommand.startsWith("unmute") && c.playerRights >= 1) {
            try {   
               String playerToBan = playerCommand.substring(7);
               Connection.unMuteUser(playerToBan);
            } catch(Exception e) {
               c.sendMessage("Player Must Be Offline."); 
     
					}
				}
}
}