package server.model.players;

import server.Config;
import server.Server;
import server.model.objects.Object;
import server.util.Misc;


public class ActionHandler {
	
	private Client c;
	
	public ActionHandler(Client Client) {
		this.c = Client;
	}
	
	
	public void firstClickObject(int objectType, int obX, int obY) {
		c.clickObjectType = 0;
		//c.sendMessage("Object type: " + objectType);
		switch(objectType) {

		case 9299:
			if (c.absY <= 3190) {
					c.getPA().walkTo(0, 1);
				} else {
					c.getPA().walkTo(0, -1);
				}
			break;
		case 11844:
			if (c.absX == 2936) {
			c.getPA().walkTo(-1, 0);
			} else if (c.absX == 2935) {
			c.getPA().walkTo(1, 0);
			}
		break;
		case 4577:
			if (c.absY == 3635) {
				c.getPA().walkTo(0,1);
			} else {
				c.getPA().walkTo(0,-1);
			}
		break;
		case 4031:
			if (c.absY == 3117) {
			if (c.getItems().playerHasItem(995,5)) {
				c.getItems().deleteItem(995,c.getItems().getItemSlot(995), 5);
				c.getPA().walkTo(0, -2);
			} else {
				c.sendMessage("You need 5 coins to go through here.");
				}
			}
			if (c.absY == 3115) {
				c.getPA().walkTo(0, 2);
			}
		break;
		case 2406:
			if (c.absX > 3201) {
				c.getPA().walkTo(-1,0);
			} else {
				c.getPA().walkTo(1,0);
			}
		break;
		case 3725:
		case 3726:
			if (c.absX > 2824) {
				c.getPA().walkTo(-1,0);
			} else {
				c.getPA().walkTo(1,0);
			}
		break;
		case 3745:
			if (c.absX >= 2823) {
				c.getPA().walkTo(-1,0);
			} else {
				c.getPA().walkTo(1,0);
			}
		break;
		case 6282:
		c.getPA().startTeleport(3429, 3538, 0, "modern");
		c.sendMessage("You were teleported to Slayer Tower.");
		break;
		case 6481:
			if (c.objectX == 3233 && c.objectY == 2888) {
				c.getPA().movePlayer(3234, 9312, 0);
			}
		break;
		case 2492:
			if (c.killCount >= 20) {
				c.getDH().sendOption4("Armadyl", "Bandos", "Saradomin", "Zamorak");
				c.dialogueAction = 20;
			} else {
				c.sendMessage("You need 20 kill count before teleporting to a boss chamber.");
			}
		break;
		case 2882:
		case 2883:
			if (c.objectX == 3268) {
				if (c.absX < c.objectX) {
					c.getPA().walkTo(1,0);
				} else {
					c.getPA().walkTo(-1,0);
				}
			}
		break;
		case 272:
			c.getPA().movePlayer(c.absX, c.absY, 1);
		break;
		case 37:
			if (c.objectX == 2085) {
				if (c.absX < c.objectX) {
					c.getPA().walkTo(1,0);
				} else {
					c.getPA().walkTo(-1,0);
				}
			}
		break;
		case 273:
			c.getPA().movePlayer(c.absX, c.absY, 0);
		break;
		case 245:
			c.getPA().movePlayer(c.absX, c.absY + 2, 2);
		break;
		case 246:
			c.getPA().movePlayer(c.absX, c.absY - 2, 1);
		break;
		case 6552:
			if (c.playerMagicBook == 0) {
				c.playerMagicBook = 1;
				c.setSidebarInterface(6, 12855);
				c.sendMessage("An ancient wisdomin fills your mind.");
				c.getPA().resetAutocast();
			} else {
				c.setSidebarInterface(6, 1151); //modern
				c.playerMagicBook = 0;
				c.sendMessage("You feel a drain on your memory.");
				c.autocastId = -1;
				c.getPA().resetAutocast();
			}	
		break;
				
		case 1817:
			if(!c.inLMS() && !c.inLMSWaiting()) {
				c.getPA().startTeleport(3213, 3425, 0, "modern");
				c.sendMessage("@dbl@You have teleported home");
			}
		break;
		case 9356:
			c.getPA().movePlayer(2413, 5117, 0);
			c.sendMessage("@dbl@Good luck! Items is kept on death.");
		break;
		case 1733:
			c.getPA().movePlayer(c.absX, 10322, 0);
		break;
		
		case 1734:
			if (c.absY != 10323) {
			c.getPA().movePlayer(3018, 3450, 0);
			} else {
			c.getPA().movePlayer(3044, 3927, 0);
			}
		break;
		
		case 9357:
			c.getPA().resetTzhaar();
		break;
		
		case 8959:
			if (c.getX() == 2490 && (c.getY() == 10146 || c.getY() == 10148)) {
				if (c.getPA().checkForPlayer(2490, c.getY() == 10146 ? 10148 : 10146)) {
					new Object(6951, c.objectX, c.objectY, c.heightLevel, 1, 10, 8959, 15);	
				}			
			}
		break;
		
		case 2213:
                            c.getPA().openUpBank();
		case 14367:
                case 9398:
                            c.getPA().openUpBank();
		case 11758:
		case 3193:
		case 2693:
		break;
		case 10230:
			c.getPA().movePlayer(2900, 4449, 0);
		break;
		case 10229:
			c.getPA().movePlayer(1912, 4367, 0);
		break;
		case 2623:
			if (c.absX >= c.objectX)
				c.getPA().walkTo(-1,0);
			else
				c.getPA().walkTo(1,0);
		break;
		//pc boat
		case 14315:
			c.getPA().movePlayer(2661,2639,0);
		break;
		case 14314:
			c.getPA().movePlayer(2657,2639,0);
		break;
		
		case 1596:
		case 1597:
		if (c.absX == 2936) {
			c.getPA().walkTo(-1,0);
		} else {
			c.getPA().walkTo(1,0);
		}
		if (c.absY != 3451 && c.absY != 3450) {
		if (c.getY() >= c.objectY)
			c.getPA().walkTo(0,-1);
		else
			c.getPA().walkTo(0,1);
		}
		break;
		
		case 14235:
		case 14233:
			if (c.objectX == 2670)
				if (c.absX <= 2670)
					c.absX = 2671;
				else
					c.absX = 2670;
			if (c.objectX == 2643)
				if (c.absX >= 2643)
					c.absX = 2642;
				else
					c.absX = 2643;
			if (c.absX <= 2585)
				c.absY += 1;
			else c.absY -= 1;
			c.getPA().movePlayer(c.absX, c.absY, 0);
		break;
		
		case 14829: case 14830: case 14827: case 14828: case 14826: case 14831:
			Server.objectHandler.startObelisk(objectType);
			Server.objectManager.startObelisk(objectType);
		break;
		case 4387:
			Server.castleWars.joinWait(c,1);
		break;
		
		case 4388:
			Server.castleWars.joinWait(c,2);
		break;
		
		case 4408:
			Server.castleWars.joinWait(c,3);
		break;
		
		case 9368:
			if (c.getY() > 5167) 
				c.getPA().movePlayer(2399, 5167, 0);
			else
				c.getPA().movePlayer(2399, 5169, 0);	
		break;
		case 4411:
		case 4415:
		case 4417:
		case 4418:
		case 4419:
		case 4420:
		case 4469:
		case 4470:
                case 1746:
if (c.objectX == 3083   && c.objectY == 3513){                
               c.startAnimation(828);                
               c.getPA().movePlayer(3083, 3512, 0);
               }
if (c.objectX == 3096   && c.objectY == 3511){                
               c.startAnimation(828);                
               c.getPA().movePlayer(3097, 3511, 0);
               }
               break;
                case 4911:
		case 4912:
                case 1747:
if (c.objectX == 3083   && c.objectY == 3513){                
               c.startAnimation(828);                
               c.getPA().movePlayer(3083, 3512, 1);
               }
if (c.objectX == 3096   && c.objectY == 3511){                
               c.startAnimation(828);                
               c.getPA().movePlayer(3097, 3511, 1);
               }
               break;
               case 1757:
 			Server.castleWars.handleObjects(c, objectType, obX, obY);
		break;
		
		
		
		case 2286:
		case 154:
		case 4058:
		case 2295:
		case 2285:
		case 2313:
		case 2312:
		case 2314:
			c.getAgility().handleGnomeCourse(objectType,obX,obY);
		break;
		
		//barrows
		//Chest
		case 10284:
			if(c.barrowsKillCount < 5) {
				c.sendMessage("You haven't killed all the brothers");
			}
			if(c.barrowsKillCount == 5 && c.barrowsNpcs[c.randomCoffin][1] == 1) {
				c.sendMessage("I have already summoned this npc.");
			}
			if(c.barrowsNpcs[c.randomCoffin][1] == 0 && c.barrowsKillCount >= 5) {
				Server.npcHandler.spawnNpc(c, c.barrowsNpcs[c.randomCoffin][0], 3551, 9694-1, 0, 0, 120, 30, 200, 200, true, true);
				c.barrowsNpcs[c.randomCoffin][1] = 1;
			}
			if((c.barrowsKillCount > 5 || c.barrowsNpcs[c.randomCoffin][1] == 2) && c.getItems().freeSlots() >= 2) {
				c.getPA().resetBarrows();
				c.getItems().addItem(c.getPA().randomRunes(), Misc.random(150) + 100);
				if (Misc.random(2) == 1)
					c.getItems().addItem(c.getPA().randomBarrows(), 1);
				c.getPA().startTeleport(3564, 3288, 0, "modern");
			} else if(c.barrowsKillCount > 5 && c.getItems().freeSlots() <= 1) {
				c.sendMessage("You need at least 2 inventory slot opened.");
			}
			break;
		//coffins
		case 6707: // verac
			c.getPA().movePlayer(3556, 3298, 0);
			break;
			
		case 6823:
			if(server.model.minigames.Barrows.selectCoffin(c, objectType)) {
				return;
			}
			if(c.barrowsNpcs[0][1] == 0) {
				Server.npcHandler.spawnNpc(c, 2030, c.getX(), c.getY()-1, -1, 0, 120, 25, 200, 200, true, true);
				c.barrowsNpcs[0][1] = 1;
			} else {
				c.sendMessage("You have already searched in this sarcophagus.");
			}
			break;

		case 6706: // torag 
			c.getPA().movePlayer(3553, 3283, 0);
			break;
			
		case 6772:
			if(server.model.minigames.Barrows.selectCoffin(c, objectType)) {
				return;
			}
			if(c.barrowsNpcs[1][1] == 0) {
				Server.npcHandler.spawnNpc(c, 2029, c.getX()+1, c.getY(), -1, 0, 120, 20, 200, 200, true, true);
				c.barrowsNpcs[1][1] = 1;
			} else {
				c.sendMessage("You have already searched in this sarcophagus.");
			}
			break;
			
			
		case 6705: // karil stairs
			c.getPA().movePlayer(3565, 3276, 0);
			break;
		case 6822:
			if(server.model.minigames.Barrows.selectCoffin(c, objectType)) {
				return;
			}
			if(c.barrowsNpcs[2][1] == 0) {
				Server.npcHandler.spawnNpc(c, 2028, c.getX(), c.getY()-1, -1, 0, 90, 17, 200, 200, true, true);
				c.barrowsNpcs[2][1] = 1;
			} else {
				c.sendMessage("You have already searched in this sarcophagus.");
			}
			break;
			
		case 6704: // guthan stairs
			c.getPA().movePlayer(3578, 3284, 0);
			break;
		case 6773:
			if(server.model.minigames.Barrows.selectCoffin(c, objectType)) {
				return;
			}
			if(c.barrowsNpcs[3][1] == 0) {
				Server.npcHandler.spawnNpc(c, 2027, c.getX(), c.getY()-1, -1, 0, 120, 23, 200, 200, true, true);
				c.barrowsNpcs[3][1] = 1;
			} else {
				c.sendMessage("You have already searched in this sarcophagus.");
			}
			break;
			
		case 6703: // dharok stairs
			c.getPA().movePlayer(3574, 3298, 0);
			break;
		case 6771:
			if(server.model.minigames.Barrows.selectCoffin(c, objectType)) {
				return;
			}
			if(c.barrowsNpcs[4][1] == 0) {
				Server.npcHandler.spawnNpc(c, 2026, c.getX(), c.getY()-1, -1, 0, 120, 45, 250, 250, true, true);
				c.barrowsNpcs[4][1] = 1;
			} else {
				c.sendMessage("You have already searched in this sarcophagus.");
			}
			break;
			
		case 6702: // ahrim stairs
			c.getPA().movePlayer(3565, 3290, 0);
			break;
		case 2417: // partychest
                        c.getPA().showInterface(2156);
                        break; 
		case 6821:
			if(server.model.minigames.Barrows.selectCoffin(c, objectType)) {
				return;
			}
			if(c.barrowsNpcs[5][1] == 0) {
				Server.npcHandler.spawnNpc(c, 2025, c.getX(), c.getY()-1, -1, 0, 90, 19, 200, 200, true, true);
				c.barrowsNpcs[5][1] = 1;
			} else {
				c.sendMessage("You have already searched in this sarcophagus.");
			}
			break;
			
		case 1276:
		case 1278://trees
			//c.sendMessage("You chop the tree.");
			/* Woodcutting object respawning etc. by lmtruck... making my own - look at this for example
			Objects stump = new Objects(1343, c.objectX, c.objectY, 0, -1, 10, 0);
			Server.objectHandler.addObject(stump);
			Server.objectHandler.placeObject(stump);
			Objects tree = new Objects(c.objectId, c.objectX, c.objectY, 0, -1, 10, 7);
			Server.objectHandler.addObject(tree);*/
			//c.treeId = objectType;
			c.woodcut[0] = 1511;
			c.woodcut[1] = 1;
			c.woodcut[2] = 25;
			c.getWoodcutting().startWoodcutting(c.woodcut[0], c.woodcut[1], c.woodcut[2]);
		break;
		
		case 1281: //oak
			c.woodcut[0] = 1521;
			c.woodcut[1] = 15;
			c.woodcut[2] = 37;
			c.getWoodcutting().startWoodcutting(c.woodcut[0], c.woodcut[1], c.woodcut[2]);
		break;
		
		case 1308: //willow
			c.woodcut[0] = 1519;
			c.woodcut[1] = 30;
			c.woodcut[2] = 68;
			c.getWoodcutting().startWoodcutting(c.woodcut[0], c.woodcut[1], c.woodcut[2]);
		break;
		
		case 1307: //maple
			c.woodcut[0] = 1517;
			c.woodcut[1] = 45;
			c.woodcut[2] = 100;
			c.getWoodcutting().startWoodcutting(c.woodcut[0], c.woodcut[1], c.woodcut[2]);
		break;
		
		case 1309: //yew
			c.woodcut[0] = 1515;
			c.woodcut[1] = 60;
			c.woodcut[2] = 175;
			c.getWoodcutting().startWoodcutting(c.woodcut[0], c.woodcut[1], c.woodcut[2]);
		break;
		
		case 1306: //yew
			c.woodcut[0] = 1513;
			c.woodcut[1] = 75;
			c.woodcut[2] = 250;
			c.getWoodcutting().startWoodcutting(c.woodcut[0], c.woodcut[1], c.woodcut[2]);
		break;

		
		case 2090://copper
		case 2091:
			c.mining[0] = 436;
			c.mining[1] = 1;
			c.mining[2] = 12;
			c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
		break;
		
		case 2094://tin
			c.mining[0] = 438;
			c.mining[1] = 1;
			c.mining[2] = 12;
			c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
		break;		
		
		case 145856:
		case 2092:
		case 2093: //iron
			c.mining[0] = 440;
			c.mining[1] = 15;
			c.mining[2] = 35;
			c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
		break;
		
		case 14850:
		case 14851:
		case 14852:
		case 2096:
		case 2097: //coal
			c.mining[0] = 453;
			c.mining[1] = 30;
			c.mining[2] = 50;
			c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
		break;		
		
		case 2098:
		case 2099:
			c.mining[0] = 444;
			c.mining[1] = 40;
			c.mining[2] = 65;
			c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
		break;
		
		case 2102:
		case 2103:
		case 14853:
		case 14854:
		case 14855: //mith ore
			c.mining[0] = 447;
			c.mining[1] = 55;
			c.mining[2] = 80;
			c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
		break;
		
		case 2105:
		case 14862: //addy ore
			c.mining[0] = 449;
			c.mining[1] = 70;
			c.mining[2] = 95;
			c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
		break;
		
		case 14859:
		case 14860: //rune ore
			c.mining[0] = 451;
			c.mining[1] = 85;
			c.mining[2] = 125;
			c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
		break;
		case 452: //outside varrock rune essen
			c.mining[0] = 1436;
			c.mining[1] = 1;
			c.mining[2] = 9;
			c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
		break;
		case 2095:
			c.mining[0] = 436;
			c.mining[1] = 1;
			c.mining[2] = 12;
			c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
		break;
		case 8143:
			if (c.farm[0] > 0 && c.farm[1] > 0) {
				c.getFarming().pickHerb();
			}
		break;
	
			// DOORS
		case 1516:
			if (c.objectY == 2737 || c.objectY == 3477) {
				if (c.absY >= c.objectY)
					c.getPA().walkTo(0,-1);
				else
					c.getPA().walkTo(0,1);
				break;
			}
		case 1519:
			if (c.objectY == 2736 || c.objectY == 3477) {
				if (c.absY >= c.objectY)
					c.getPA().walkTo(0,-1);
				else
					c.getPA().walkTo(0,1);
				break;
			}
		case 1530:
			if (c.absX == 2922) {
				c.getPA().walkTo(-1, 0);
			} else if (c.absX == 2921) {
				c.getPA().walkTo(1, 0);
			}
		case 1531:
		case 1533:
		case 1534:
		case 11712:
		case 11711:
		case 11707:
		case 11708:
		case 6725:
		case 3198:
		case 3197:
			Server.objectHandler.doorHandling(objectType, c.objectX, c.objectY, 0);	
			break;
		
		case 9319:
			if (c.heightLevel == 0)
				c.getPA().movePlayer(c.absX, c.absY, 1);
			else if (c.heightLevel == 1)
				c.getPA().movePlayer(c.absX, c.absY, 2);
		break;
		
		case 9320:
			if (c.heightLevel == 1)
				c.getPA().movePlayer(c.absX, c.absY, 0);
			else if (c.heightLevel == 2)
				c.getPA().movePlayer(c.absX, c.absY, 1);
		break;
		
		case 4496:
		case 4494:
			if (c.heightLevel == 2) {
				c.getPA().movePlayer(c.absX - 5, c.absY, 1);
			} else if (c.heightLevel == 1) {
				c.getPA().movePlayer(c.absX + 5, c.absY, 0);
			}
		break;
		
		case 4493:
			if (c.heightLevel == 0) {
				c.getPA().movePlayer(c.absX - 5, c.absY, 1);
			} else if (c.heightLevel == 1) {
				c.getPA().movePlayer(c.absX + 5, c.absY, 2);
			}
		break;
		
		case 4495:
			if (c.heightLevel == 1) {
				c.getPA().movePlayer(c.absX + 5, c.absY, 2);
			}
		break;
		
		case 5126:
			if (c.absY == 3554)
				c.getPA().walkTo(0,1);
			else
				c.getPA().walkTo(0,-1);
		break;
		
		case 1759:
			if (c.objectX == 2884 && c.objectY == 3397)
				c.getPA().movePlayer(c.absX, c.absY + 6400, 0);				
		break;
		/*case 3203: //dueling forfeit
			if (c.duelCount > 0) {
				c.sendMessage("You may not forfeit yet.");
				break;
			}
			Client o = (Client) Server.playerHandler.players[c.duelingWith];				
			if(o == null) {
				c.getTradeAndDuel().resetDuel();
				c.getPA().movePlayer(Config.DUELING_RESPAWN_X+(Misc.random(Config.RANDOM_DUELING_RESPAWN)), Config.DUELING_RESPAWN_Y+(Misc.random(Config.RANDOM_DUELING_RESPAWN)), 0);
				break;
			}
			if(c.duelRule[0]) {
				c.sendMessage("Forfeiting the duel has been disabled!");
				break;
			}
			if(o != null) {
				o.getPA().movePlayer(Config.DUELING_RESPAWN_X+(Misc.random(Config.RANDOM_DUELING_RESPAWN)), Config.DUELING_RESPAWN_Y+(Misc.random(Config.RANDOM_DUELING_RESPAWN)), 0);
				c.getPA().movePlayer(Config.DUELING_RESPAWN_X+(Misc.random(Config.RANDOM_DUELING_RESPAWN)), Config.DUELING_RESPAWN_Y+(Misc.random(Config.RANDOM_DUELING_RESPAWN)), 0);
				o.duelStatus = 6;
				o.getTradeAndDuel().duelVictory();
				c.getTradeAndDuel().resetDuel();
				c.getTradeAndDuel().resetDuelItems();
				o.sendMessage("The other player has forfeited the duel!");
				c.sendMessage("You forfeit the duel!");
				break;
			}
			
			break;*/
			
		case 409:
		case 4859:
		case 2640:
			if(c.playerLevel[5] < c.getPA().getLevelForXP(c.playerXP[5])) {
				c.startAnimation(645);
				c.playerLevel[5] = c.getPA().getLevelForXP(c.playerXP[5]);
				c.sendMessage("You recharge your prayer points.");
				c.getPA().refreshSkill(5);
			} else {
				c.sendMessage("You already have full prayer points.");
			}
			break;
case 410:
if (c.playerMagicBook == 0) {
c.playerMagicBook = 2;
c.setSidebarInterface(6, 29999);
c.sendMessage("A Lunar wisdomin fills your mind.");
c.getPA().resetAutocast();
} else {
c.setSidebarInterface(6, 1151); //modern
c.playerMagicBook = 0;
c.sendMessage("You feel a drain on your memory.");
c.autocastId = -1;
c.getPA().resetAutocast();
}
break; 
		case 2873:
			if (!c.getItems().ownsCape()) {
				c.startAnimation(645);
				c.sendMessage("Saradomin blesses you with a cape.");
				c.getItems().addItem(2412, 1);
			}	
		break;
		case 2875:
			if (!c.getItems().ownsCape()) {
				c.startAnimation(645);
				c.sendMessage("Guthix blesses you with a cape.");
				c.getItems().addItem(2413, 1);
			}
		break;
		case 2874:
			if (!c.getItems().ownsCape()) {
				c.startAnimation(645);
				c.sendMessage("Zamorak blesses you with a cape.");
				c.getItems().addItem(2414, 1);
			}
		break;
		case 5960:
			c.getPA().startTeleport2(3090, 3956, 0);
		break;
		
		case 1815:
			c.getPA().startTeleport2(Config.EDGEVILLE_X, Config.EDGEVILLE_Y, 0);
		break;
		
		case 9706:
			c.getPA().startTeleport2(3105, 3951, 0);
		break;
		case 9707:
			c.getPA().startTeleport2(3105, 3956, 0);
		break;
		
		case 5959:
			c.getPA().startTeleport2(2539, 4712, 0);
		break;
		
		case 2558:
			c.sendMessage("This door is locked.");	
		break;
		
		case 9294:
			if (c.absX < c.objectX) {
				c.getPA().movePlayer(c.objectX + 1, c.absY, 0);
			} else if (c.absX > c.objectX) {
				c.getPA().movePlayer(c.objectX - 1, c.absY, 0);
			}
		break;
		case 10529:
		case 10527:
			if (c.absY <= c.objectY)
				c.getPA().walkTo(0,1);
			else
				c.getPA().walkTo(0,-1);
		break;
		case 3044:
			c.getSmithing().sendSmelting();
		break;
		case 733:
			c.startAnimation(451);
			/*if (Misc.random(1) == 1) {
				c.getPA().removeObject(c.objectX, c.objectY);
				c.sendMessage("You slash the web.");
			} else {
				c.sendMessage("You fail to slash the webs.");
			}*/
			if (c.objectX == 3158 && c.objectY == 3951) {
				new Object(734, c.objectX, c.objectY, c.heightLevel, 1, 10, 733, 50);
			} else {
				new Object(734, c.objectX, c.objectY, c.heightLevel, 0, 10, 733, 50);
			}
		break;

		}
	}
	//edit my K3llY make stalls give money and better xp with chance of rare pick up!
	public void secondClickObject(int objectType, int obX, int obY) {
		c.clickObjectType = 0;
		//c.sendMessage("Object type: " + objectType);
		switch(objectType) {
			case 11666:
			case 3044:
				c.getSmithing().sendSmelting();
			break;
			case 2213:
			case 14367:
			case 11758:
			case 2693:
				c.getPA().openUpBank();
			break;
			case 4876:
				c.getThieving().stealFromStall(995, 100, 1, 1000);
			break;
			case 4875:
				c.getThieving().stealFromStall(995, 150, 25, 1500);
			break;
			case 4874:
				c.getThieving().stealFromStall(995, 200, 50, 2500);
			break;
			case 4877:
				c.getThieving().stealFromStall(995, 250, 75, 10000);
			break;
			case 4878:
				c.getThieving().stealFromStall(995, 300, 90, 70000);
			break;
		}
	}
	
	public void firstClickNpc(int npcType) {
		c.clickNpcType = 0;
		c.npcClickIndex = 0;
		switch(npcType) {
		
		//king arthur talking for main quest
		//K3LLY
		case 251:
			if(c.quest1Part == 3) {
				c.getDH().sendDialogues(40, npcType);
			} else if(c.quest1Part == 5) {
				c.getDH().sendDialogues(43, npcType);
			} else if(c.quest1Part == 6) {
				c.getDH().sendDialogues(44, npcType);
			} else {
				c.getDH().sendDialogues(42, npcType);
			}
			break;

		case 1686:
		if (c.getItems().playerHasItem(536,1) && c.getItems().playerHasItem(1113) && c.getItems().playerHasItem(565)) {
		c.getItems().deleteItem(536, 1);
		c.getItems().deleteItem(1113, 1);
		c.getItems().deleteItem(565, 1);
		c.getItems().addItem(295, 1);
		c.sendMessage("Here's the untradable Glarial amulet, it turns you into Dracula. Enjoy.");
		} else {
		c.sendMessage("I would give you your H'ween Gift only if you give me..");
		c.sendMessage("..a Rune chainbody, dragon bone & blood rune. HINT: Search for this in shops");
		}
		break;

			case 2262:
				c.getDH().sendDialogues(23, npcType);
			break;
			case 660:
				c.getDH().sendDialogues(39, npcType);
			break;
			case 2244:
				c.getShops().openShop(30);
			break;
			case 219:
				c.getShops().openShop(14);
			break;
			case 2402:
				c.getShops().openShop(31);
			break;
			case 651:
				c.getShops().openShop(29);
			break;
			case 638:
				c.getShops().openShop(0);
			break;
			case 284:
				c.getShops().openShop(0);
			break;
			case 1334:
				if (!c.getItems().ownsBook()) {
					c.getItems().addItem(3842, 1);
					c.sendMessage("You recieve a Unholy book from Jossik.");
				} else {
					c.sendMessage("You already have a book.");
				}
			break;
			case 587:
				c.getShops().openShop(22);
			break;
			case 3792:
				c.getPA().movePlayer(2659, 2676, 0);
			break;
			case 1596:
				c.getDH().sendDialogues(22, npcType);
			break;
			case 3020:
			c.getDH().sendDialogues(20, npcType);
			/*if (c.getItems().playerHasItem(995,200)) {
				c.getItems().deleteItem(995,c.getItems().getItemSlot(995), 200);
				c.itemBeforeCarpet = c.playerEquipment[c.playerWeapon];
				c.playerEquipment[c.playerWeapon] = 5614;
				c.getPA().movePlayer(3308, 3109, 0);
				c.startAnimation(2262);
				c.isRunning2 = true;
				c.usingCarpet = true;
				c.getPA().walkTo3(-130, -64);
				c.getCombat().getPlayerAnimIndex(c.getItems().getItemName(c.playerEquipment[c.playerWeapon]).toLowerCase());
				c.updateRequired = true; 
				c.setAppearanceUpdateRequired(true);
				} else {
				c.sendMessage("You need 200 coins to ride the carpet.");
			}	
			break;*/
			break;
			case 1918:
			if (c.getItems().playerHasItem(995,200)) {
				c.getItems().deleteItem(995,c.getItems().getItemSlot(995), 200);
				c.getPA().movePlayer(3308, 3108, 0);
				c.sendMessage("You pay 200 coins and are flown to the Shanty pass.");
			} else {
				c.sendMessage("You need 200 coins to ride the carpet.");
				}
			break;
			case 3791:
				c.getPA().movePlayer(3049, 3235, 0);
			break;
			case 2825:
				c.getPA().movePlayer(2710, 9466, 0);
				c.sendMessage("The ship boards and the pirate escorts you to the dungeon.");
			break;
			case 534:
				c.getShops().openShop(21);
			break;
			case 1071:
				c.getShops().openShop(19);
			break;
			case 706:
				c.getDH().sendDialogues(9, npcType);
			break;
			case 637:
				if(c.quest1Part == 0)
					c.getDH().sendDialogues(24, npcType);
				else
					c.getDH().sendDialogues(26, npcType);
			break;
			case 639:
				c.getDH().sendDialogues(31, npcType);
			break;
			case 988:
				c.getDH().sendDialogues(32, npcType);
			break;
			case 2258:
				c.getDH().sendDialogues(17, npcType);
			break;
			case 659:
				c.getDH().sendDialogues(27, npcType);
			break;
			case 1599:
				if (c.slayerTask <= 0) {
					c.getDH().sendDialogues(11,npcType);
				} else {
					c.getDH().sendDialogues(13,npcType);
				}
			break;

			case 461:
				c.getShops().openShop(2);
			break;
			
			case 683:
				c.getShops().openShop(3);
			break;
			
			case 549:
				c.getShops().openShop(28);
			break;
			
			case 2538:
				c.getShops().openShop(6);
			break;
			
			case 519:
				c.getShops().openShop(8);
			break;
			case 1282:
				c.getShops().openShop(7);
			break;
			case 1152:
				c.getDH().sendDialogues(16,npcType);
			break;
			case 494:
				c.getPA().openUpBank();
			break;
			case 2566:
				c.getShops().openSkillCape();
			break;
			case 3789:
                                c.getPA().showInterface(18691);
			break;
			case 3788:
				c.getShops().openVoid();
			break;
			case 905:
				c.getDH().sendDialogues(5, npcType);
			break;
			case 460:
				c.getDH().sendDialogues(3, npcType);
			break;
			case 462:
				c.getDH().sendDialogues(7, npcType);
			break;
			case 316: //shrimp
				c.getFishing().setupFishing(317);
			break;
			case 334: //mantas
				c.getFishing().setupFishing(389);
			break;
			case 324: //tuna
				c.getFishing().setupFishing(359);
			break;
			case 314: //salmon
				c.getFishing().setupFishing(335);
			break;
			case 326: //monks
				c.getFishing().setupFishing(7944);
			break;
			case 522:
			case 523:
				c.getShops().openShop(1);
			break;
			case 599:
				c.getPA().showInterface(3559);
				c.canChangeAppearance = true;
			break;
			case 566:
				c.getDH().sendDialogues(36, npcType);
			break;
		}		
	}

	public void secondClickNpc(int npcType) {
		c.clickNpcType = 0;
		c.npcClickIndex = 0;
		switch(npcType) {
			case 988:
				c.getDH().sendDialogues(31, npcType);
			break;
			case 553:
				c.getShops().openShop(2);
			break;
			case 1282:
				c.getShops().openShop(7);
			break;
			case 334: //sharks
				c.getFishing().setupFishing(383);
			break;
			case 3788:
				c.getShops().openVoid();
			break;
			case 494:
				c.getPA().openUpBank();
			break;
			case 324: //lobs
				c.getFishing().setupFishing(359);
			break;
			case 566:
				c.getShops().openShop(17);
			break;
			case 522:
			case 523:
				c.getShops().openShop(1);
			break;
			case 461:
				c.getShops().openShop(2);
			break;
			
			case 683:
				c.getShops().openShop(3);
			break;
			
			case 2538:
				c.getShops().openShop(6);
			break;
			
			case 519:
				c.getShops().openShop(8);
			break;
			case 3789:
				c.getShops().openShop(18);
			break;
			case 589:
				c.getShops().openShop(9);
			break;
			case 594:
				c.getShops().openShop(13);
			break;
			case 1:
			case 9:
			case 18:
			case 20:
				c.getThieving().stealFromNPC(npcType);
			break;
			
		}
	}
	public void thirdClickNpc(int npcType) {
		c.clickNpcType = 0;
		c.npcClickIndex = 0;
		switch(npcType) {
			case 117:
			Misc.println("man clicked");
			break;
		}
	}
}
