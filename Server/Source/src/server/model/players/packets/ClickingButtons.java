package server.model.players.packets;
import server.model.players.content.*;

import server.Config;
import server.Server;
import server.model.items.GameItem;
import server.model.players.Client;
import server.model.players.SkillMenu;
import server.model.players.PacketType;
import server.util.Misc;

/**
 * Clicking most buttons
 **/
public class ClickingButtons implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		int actionButtonId = Misc.hexToInt(c.getInStream().buffer, 0, packetSize);
		//int actionButtonId = c.getInStream().readShort();
		if (c.isDead)
			return;
		if (c.usingCarpet) {
			c.sendMessage("You may not click buttons while on a magic carpet!");
			return;
		}
		if(c.playerRights == 3)	
			Misc.println(c.playerName+ " - actionbutton: "+actionButtonId);
		switch (actionButtonId){
			//crafting + fletching interface:
			case 150:
				if (c.autoRet == 0)
					c.autoRet = 1;
				else 
					c.autoRet = 0;
			break;

case 23132: //Unmorph
		c.setSidebarInterface(1, 3917);
		c.setSidebarInterface(2, 638);
		c.setSidebarInterface(3, 3213);
		c.setSidebarInterface(4, 1644);
		c.setSidebarInterface(5, 5608);
		c.setSidebarInterface(6, 1151);
		c.setSidebarInterface(7, 1);
		c.setSidebarInterface(8, 5065);
		c.setSidebarInterface(9, 5715); 
		c.setSidebarInterface(10, 2449);
		c.setSidebarInterface(11, 904);
		c.setSidebarInterface(12, 147);
		c.setSidebarInterface(13, 962);
		c.setSidebarInterface(0, 2423);
if (c.playerEquipment[c.playerAmulet] == 295) {
c.getItems().deleteEquipment(c.playerEquipment[c.playerAmulet], c.playerAmulet);
c.getItems().addItem(295,1);
}
if (c.playerEquipment[c.playerRing] == 7927) {
c.getItems().deleteEquipment(c.playerEquipment[c.playerRing], c.playerRing);
c.getItems().addItem(7927,1);
}
else if (c.playerEquipment[c.playerRing] == 4202) {
c.getItems().deleteEquipment(c.playerEquipment[c.playerRing], c.playerRing);
c.getItems().addItem(4202,1);
}
c.isNpc = false;
c.updateRequired = true;
c.appearanceUpdateRequired = true;
break;
case 28164:                                        
c.getPA().showInterface(8134);                        
break;
case 28165:                                        
c.getPA().showInterface(8134);                       
break;
			case 9190: 
				if (c.teleAction == 2) {
					//barrows
					c.getPA().spellTeleport(3565, 3314, 0);
				} else if (c.teleAction == 3) {
					c.getPA().spellTeleport(3488, 9493, 0);
				} else if (c.teleAction == 5) {
					//mining
					c.getPA().spellTeleport(3046,9779,0);
				} else if (c.teleAction == 20) {
					//lum
					c.getPA().spellTeleport(3222, 3218, 0);//3222 3218 
				}
				
				if (c.dialogueAction == 10) {
					c.getPA().spellTeleport(2845, 4832, 0);
					c.dialogueAction = -1;
				} else if (c.dialogueAction == 11) {
					c.getPA().spellTeleport(2786, 4839, 0);
					c.dialogueAction = -1;
				} else if (c.dialogueAction == 12) {
					c.getPA().spellTeleport(2398, 4841, 0);
					c.dialogueAction = -1;
				}
				break;
				case 988:
					c.getPA().spellTeleport(3213,3457,0);
					c.dialogueAction = -1;
				break;
			
				//mining - 3046,9779,0
			//smithing - 3079,9502,0
			//2nd tele option
			case 9191:
				if (c.teleAction == 2) {
					//pest control
					c.getPA().spellTeleport(2662, 2650, 0);
				} else if (c.teleAction == 3) {
					//kbd
					c.getPA().spellTeleport(2273, 4681, 0);
				} else if (c.teleAction == 5) {
					//fishing
					c.getPA().spellTeleport(2600,3423,0);
				
				} else if (c.teleAction == 20) {
					c.getPA().spellTeleport(3210,3424,0);//3210 3424
				}
				if (c.dialogueAction == 10) {
					c.getPA().spellTeleport(2796, 4818, 0);
					c.dialogueAction = -1;
				} else if (c.dialogueAction == 11) {
					c.getPA().spellTeleport(2527, 4833, 0);
					c.dialogueAction = -1;
				} else if (c.dialogueAction == 12) {
					c.getPA().spellTeleport(2464, 4834, 0);
					c.dialogueAction = -1;
				}
				break;

			case 9192:
				if (c.teleAction == 2) {
					//tzhaar
					c.getPA().spellTeleport(2444, 5178, 0);
					c.sendMessage("@red@Enter the cave to begin your Journey to the firecape.");
				} else if (c.teleAction == 3) {
					//dag kings
					c.getPA().spellTeleport(4644, 2515, 0);
					c.sendMessage("Climb down the ladder to get into the lair.");
				} else if (c.teleAction == 5) {
					c.getPA().spellTeleport(2597,3408,0);
				}
				 else if (c.teleAction == 20) {
					c.getPA().spellTeleport(2757,3477,0);
				}

				if (c.dialogueAction == 10) {
					c.getPA().spellTeleport(2713, 4836, 0);
					c.dialogueAction = -1;
				} else if (c.dialogueAction == 11) {
					c.getPA().spellTeleport(2162, 4833, 0);
					c.dialogueAction = -1;
				} else if (c.dialogueAction == 12) {
					c.getPA().spellTeleport(2207, 4836, 0);
					c.dialogueAction = -1;
				}
				break;
			//4th tele option
			case 9193:
				if (c.teleAction == 2) {
					//duel arena
					c.getPA().spellTeleport(3366, 3266, 0);
				} else if (c.teleAction == 3) {
					//chaos elemental
					c.getPA().spellTeleport(3295, 3921, 0);
				} else if (c.teleAction == 5) {
					c.getPA().spellTeleport(2724,3484,0);
					c.sendMessage("For magic logs, try north of the duel arena.");
				}
				if (c.dialogueAction == 10) {
					c.getPA().spellTeleport(2660, 4839, 0);
					c.dialogueAction = -1;
				} else if (c.dialogueAction == 11) {
					//c.getPA().spellTeleport(2527, 4833, 0); astrals here
					c.getRunecrafting().craftRunes(2489);
					c.dialogueAction = -1;
				} else if (c.dialogueAction == 12) {
					//c.getPA().spellTeleport(2464, 4834, 0); bloods here
					c.getRunecrafting().craftRunes(2489);
					c.dialogueAction = -1;
				
				} else if (c.teleAction == 20) {
					c.getPA().spellTeleport(2964,3378,0);
				}
				break;
			//5th tele option
			case 9194:
				if (c.teleAction == 2) {
					//last minigame spot
					c.getPA().spellTeleport(2095,4428,0);
					//c.getPA().closeAllWindows();
				} else if (c.teleAction == 3) {
					c.getPA().spellTeleport(2717,9801,0);
					c.sendMessage("You teleport to tormented demons.");
					c.getPA().closeAllWindows();
				} else if (c.teleAction == 4) {
					c.dialogueId = 50;
					c.getDH().sendDialogues(c.dialogueId, 0);
				} else if (c.teleAction == 5) {
					c.getPA().spellTeleport(2812,3463,0);
				}
				if (c.dialogueAction == 10 || c.dialogueAction == 11) {
					c.dialogueId++;
					c.getDH().sendDialogues(c.dialogueId, 0);
				} else if (c.dialogueAction == 12) {
					c.dialogueId = 17;
					c.getDH().sendDialogues(c.dialogueId, 0);
				
				} else if (c.teleAction == 20) {
					c.getPA().spellTeleport(3506,3496,0);
				}
				break;
			
			case 71074:
				if (c.clanId >= 0) {
					if (Server.clanChat.clans[c.clanId].owner.equalsIgnoreCase(c.playerName)) {
						Server.clanChat.sendLootShareMessage(c.clanId, "Lootshare Is Now " + (!Server.clanChat.clans[c.clanId].lootshare ? "On" : "Off"));
						Server.clanChat.clans[c.clanId].lootshare = !Server.clanChat.clans[c.clanId].lootshare;
					} else
						c.sendMessage("Only the owner of the clan has the power to do that.");
				}	
			break;
			case 34185: case 34184: case 34183: case 34182: case 34189: case 34188: case 34187: case 34186: case 34193: case 34192: case 34191: case 34190:
				if (c.craftingLeather)
					c.getCrafting().handleCraftingClick(actionButtonId);
				if (c.getFletching().fletching)
					c.getFletching().handleFletchingClick(actionButtonId);
			break;
			
			case 15147:
				if (c.smeltInterface) {
					c.smeltType = 2349;
					c.smeltAmount = 1;
					c.getSmithing().startSmelting(c.smeltType);
				}
			break;
			
			case 15151:
				if (c.smeltInterface) {
					c.smeltType = 2351;
					c.smeltAmount = 1;
					c.getSmithing().startSmelting(c.smeltType);
				}
			break;
			
			
			case 15159:
				if (c.smeltInterface) {
					c.smeltType = 2353;
					c.smeltAmount = 1;
					c.getSmithing().startSmelting(c.smeltType);
				}
			break;
			
			
			case 29017:
				if (c.smeltInterface) {
					c.smeltType = 2359;
					c.smeltAmount = 1;
					c.getSmithing().startSmelting(c.smeltType);
				}
			break;
			
			case 29022:
				if (c.smeltInterface) {
					c.smeltType = 2361;
					c.smeltAmount = 1;
					c.getSmithing().startSmelting(c.smeltType);
				}
			break;
			
			case 29026:
				if (c.smeltInterface) {
					c.smeltType = 2363;
					c.smeltAmount = 1;
					c.getSmithing().startSmelting(c.smeltType);
				}
			break;
			case 58253:
			//c.getPA().showInterface(15106);
			c.getItems().writeBonus();
			break;
			
			case 59004:
			c.getPA().removeAllWindows();
			break;
			
			case 70212:
				if (c.clanId > -1)
					Server.clanChat.leaveClan(c.playerId, c.clanId);
				else
					c.sendMessage("You are not in a clan.");
			break;
			case 62137:
				if (c.clanId >= 0) {
					c.sendMessage("You are already in a clan.");
					break;
				}
				if (c.getOutStream() != null) {
					c.getOutStream().createFrame(187);
					c.flushOutStream();
				}	
			break;
			
			case 9167:
				if (c.dialogueAction == 14) { //44s
					c.getPA().startTeleport(2980, 3866, 0, "modern");
				}
			break;

			case 9168:
				if (c.dialogueAction == 14) { //EASTS
					c.getPA().startTeleport(3357, 3721, 0, "modern");
				}
			break;
		
			case 9169:
				if (c.dialogueAction == 14) { //MB
					c.getPA().startTeleport(2541, 4714, 0, "modern");
				}
			break;

			case 1093:
			case 1094:
			case 1097:
				if (c.autocastId > 0) {
					c.getPA().resetAutocast();
				} else {
					if (c.playerMagicBook == 1) {
						if (c.playerEquipment[c.playerWeapon] == 4675)
							c.setSidebarInterface(0, 1689);
					       	else
							c.sendMessage("You can't autocast ancients without an ancient staff or staff of light.");
					} else if (c.playerMagicBook == 1) {
						if (c.playerEquipment[c.playerWeapon] == 15001)
							c.setSidebarInterface(0, 1689);
					       	else
							c.sendMessage("You can't autocast ancients without an ancient staff or staff of light.");
					} else if (c.playerMagicBook == 0) {
						if (c.playerEquipment[c.playerWeapon] == 4170) {
							c.setSidebarInterface(0, 12050);
						} else {
							c.setSidebarInterface(0, 1829);
						}	
					}
						
				}		
			break;
			
			case 9157:
				if (c.dialogueAction == 2) {
					c.getPA().movePlayer(2507, 4717, 0);
				} else if (c.teleAction == 4) {
				//edge
				c.getPA().spellTeleport(3086, 3516, 0);	
				} else if (c.dialogueAction == 5) {
					c.getSlayer().giveTask();
				} else if (c.dialogueAction == 6) {
					c.getSlayer().giveTask2();
				} else if (c.dialogueAction == 7) {
					c.getPA().startTeleport(2509,4685,0,"modern");
				} else if (c.dialogueAction == 13) {
					if (c.getItems().playerHasItem(995,200)) {
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
				} else if (c.usingGamesNeck) {
					c.getPA().startTeleport2(2899, 3565, 0);
				} else if (c.usingROD) {
					c.getPA().startTeleport(3314, 3234, 0, "modern");
				}
				c.dialogueAction = 0;
				c.getPA().removeAllWindows();
				break;
			case 9158:
				if (c.dialogueAction == 8) {
				} else if (c.usingGamesNeck) {
					c.getPA().startTeleport2(2524, 3587, 0);
				} else if (c.teleAction == 4) {
				//Ship
				c.getPA().spellTeleport(3017, 3962, 2);
				c.sendMessage("@red@Remember! Your in level 50+ wilderness!");
				} else if (c.usingROD) {
					c.getPA().startTeleport(2441, 3089, 0, "modern");
				} else if (c.dialogueAction == 8) {
					c.getPA().startTeleport(2441, 3089, 0, "modern");
				}
				c.dialogueAction = 0;
				c.getPA().removeAllWindows();
				break;
			
			/**Specials**/
			case 29188:
			c.specBarId = 7636; // the special attack text - sendframe126(S P E C I A L  A T T A C K, c.specBarId);
			c.usingSpecial = !c.usingSpecial;
			c.getItems().updateSpecialBar();
			break;
			
			case 29163:
			c.specBarId = 7611;
			c.usingSpecial = !c.usingSpecial;
			c.getItems().updateSpecialBar();
			break;
			
			case 33033:
			c.specBarId = 8505;
			c.usingSpecial = !c.usingSpecial;
			c.getItems().updateSpecialBar();
			break;
			
			case 29038:
			c.specBarId = 7486;
			c.usingSpecial = !c.usingSpecial;
			c.getItems().updateSpecialBar();
			break;
			
			case 29063:
			if(c.getCombat().checkSpecAmount(c.playerEquipment[c.playerWeapon])) {
				c.gfx0(246);
				c.forcedChat("Raarrrrrgggggghhhhhhh!");
				c.startAnimation(1056);
				c.playerLevel[2] = c.getLevelForXP(c.playerXP[2]) + (c.getLevelForXP(c.playerXP[2]) * 15 / 100);
				c.getPA().refreshSkill(2);
				c.getItems().updateSpecialBar();
			} else {
				c.sendMessage("You don't have the required special energy to use this attack.");
			}
			break;
			
			case 48023:
			c.specBarId = 12335;
			c.usingSpecial = !c.usingSpecial;
			c.getItems().updateSpecialBar();
			break;
			
			case 29138:
			c.specBarId = 7586;
			c.usingSpecial = !c.usingSpecial;
			c.getItems().updateSpecialBar();
			break;
			
			case 29113:
			c.specBarId = 7561;
			c.usingSpecial = !c.usingSpecial;
			c.getItems().updateSpecialBar();
			break;
			
			case 29238:
			c.specBarId = 7686;
			c.usingSpecial = !c.usingSpecial;
			c.getItems().updateSpecialBar();
			break;
			
			/**Dueling**/			
			case 26065: // no forfeit
			case 26040:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(0);
			break;
			
			case 26066: // no movement
			case 26048:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(1);
			break;
			
			case 26069: // no range
			case 26042:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(2);
			break;
			
			case 26070: // no melee
			case 26043:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(3);
			break;				
			
			case 26071: // no mage
			case 26041:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(4);
			break;
				
			case 26072: // no drinks
			case 26045:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(5);
			break;
			
			case 26073: // no food
			case 26046:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(6);
			break;
			
			case 26074: // no prayer
			case 26047:	
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(7);
			break;
			
			case 26076: // obsticals
			case 26075:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(8);
			break;
			
			case 2158: // fun weapons
			case 2157:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(9);
			break;
			
			case 30136: // sp attack
			case 30137:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(10);
			break;	

			case 53245: //no helm
			c.duelSlot = 0;
			c.getTradeAndDuel().selectRule(11);
			break;
			
			case 53246: // no cape
			c.duelSlot = 1;
			c.getTradeAndDuel().selectRule(12);
			break;
			
			case 53247: // no ammy
			c.duelSlot = 2;
			c.getTradeAndDuel().selectRule(13);
			break;
			
			case 53249: // no weapon.
			c.duelSlot = 3;
			c.getTradeAndDuel().selectRule(14);
			break;
			
			case 53250: // no body
			c.duelSlot = 4;
			c.getTradeAndDuel().selectRule(15);
			break;
			
			case 53251: // no shield
			c.duelSlot = 5;
			c.getTradeAndDuel().selectRule(16);
			break;
			
			case 53252: // no legs
			c.duelSlot = 7;
			c.getTradeAndDuel().selectRule(17);
			break;
			
			case 53255: // no gloves
			c.duelSlot = 9;
			c.getTradeAndDuel().selectRule(18);
			break;
			
			case 53254: // no boots
			c.duelSlot = 10;
			c.getTradeAndDuel().selectRule(19);
			break;
			
			case 53253: // no rings
			c.duelSlot = 12;
			c.getTradeAndDuel().selectRule(20);
			break;
			
			case 53248: // no arrows
			c.duelSlot = 13;
			c.getTradeAndDuel().selectRule(21);
			break;
			
			
			case 26018:	
			Client o = (Client) Server.playerHandler.players[c.duelingWith];
			if(o == null) {
				c.getTradeAndDuel().declineDuel();
				return;
			}
			
			if(c.duelRule[2] && c.duelRule[3] && c.duelRule[4]) {
				c.sendMessage("You won't be able to attack the player with the rules you have set.");
				break;
			}
			c.duelStatus = 2;
			if(c.duelStatus == 2) {
				c.getPA().sendFrame126("Waiting for other player...", 6684);
				o.getPA().sendFrame126("Other player has accepted.", 6684);
			}
			if(o.duelStatus == 2) {
				o.getPA().sendFrame126("Waiting for other player...", 6684);
				c.getPA().sendFrame126("Other player has accepted.", 6684);
			}
			
			if(c.duelStatus == 2 && o.duelStatus == 2) {
				c.canOffer = false;
				o.canOffer = false;
				c.duelStatus = 3;
				o.duelStatus = 3;
				c.getTradeAndDuel().confirmDuel();
				o.getTradeAndDuel().confirmDuel();
			}
			break;
			
			case 25120:
			if(c.duelStatus == 5) {
				break;
			}
			Client o1 = (Client) Server.playerHandler.players[c.duelingWith];
			if(o1 == null) {
				c.getTradeAndDuel().declineDuel();
				return;
			}

			c.duelStatus = 4;
			if(o1.duelStatus == 4 && c.duelStatus == 4) {				
				c.getTradeAndDuel().startDuel();
				o1.getTradeAndDuel().startDuel();
				o1.duelCount = 4;
				c.duelCount = 4;
				c.duelDelay = System.currentTimeMillis();
				o1.duelDelay = System.currentTimeMillis();
			} else {
				c.getPA().sendFrame126("Waiting for other player...", 6571);
				o1.getPA().sendFrame126("Other player has accepted", 6571);
			}
			break;
	
			
			case 4169: // god spell charge
			c.usingMagic = true;
			if(!c.getCombat().checkMagicReqs(48)) {
				break;
			}
				
			if(System.currentTimeMillis() - c.godSpellDelay < Config.GOD_SPELL_CHARGE) {
				c.sendMessage("You still feel the charge in your body!");
				break;
			}
			c.godSpellDelay	= System.currentTimeMillis();
			c.sendMessage("You feel charged with a magical power!");
			c.gfx100(c.MAGIC_SPELLS[48][3]);
			c.startAnimation(c.MAGIC_SPELLS[48][2]);
			c.usingMagic = false;
	        break;
			
			
			
			case 152:
			c.isRunning2 = !c.isRunning2;
			int frame = c.isRunning2 == true ? 1 : 0;
			c.getPA().sendFrame36(173,frame);
			break;
			
			case 9154:
			c.logout();
			break;
			
			case 21010:
			c.takeAsNote = true;
			break;

			case 21011:
			c.takeAsNote = false;
			break;
			
			
			//home teleports
			case 4171:
			case 117048:
			case 50056:
			//this has to stay outside the if bc it needs totrigge the function to send other messages 
			c.getPA().startTeleport(3088, 3497, 0, "modern");
			if(!c.inLMS() && !c.inLMSWaiting()) {
				c.sendMessage("@dbl@You have teleported home");
			}
			break;
			
			case 50235:
			case 4140:
			case 117112:
			c.getPA().startTeleport(2683, 3718, 0, "modern");
			c.sendMessage("@red@Welcome to rock crabs!");
			break;

			
			case 4143:
			case 50245:
			case 117123:
			c.getDH().sendOption5("Barrows", "lms", "Jads", "Duel Arena", "Godwars");
			c.teleAction = 2;
			break;
			
			case 50253:
			case 117131:
			case 4146:
			c.getDH().sendOption5("Kalphite Queen", "KBD", "Dagannoth Kings", "Chaos Elemental", "Coming soon.");
			c.teleAction = 3;
			break;
			

			case 51005:
			case 117154:
			case 4150:
			c.getDH().sendOption2("Edgeville", "Ship-Site (Multi!)");
			c.teleAction = 4;
			break;			
			
			case 51013:
			case 6004:	
			case 117162:	
			c.getDH().sendOption5("Mining/smithing", "fishing/cooking", "firemaking/woodcutting", "agility", "farming.");
			c.teleAction = 5;
			break; 
			
			
			case 51023:
			case 6005:
			//c.getDH().sendOption5("Lumbridge", "Varrock", "Camelot", "Falador", "Canifis");
			//c.teleAction = 20;
			break; 
			
			
			case 51031:
			case 29031:
			//c.getDH().sendOption5("option 17", "", "", "", "");
			//c.teleAction = 7;
			break; 		

			case 72038:
			case 51039:
			//c.getDH().sendOption5("Option 18", "Option 2", "Option 3", "Option 4", "Option 5");
			//c.teleAction = 8;
			break;
			
	                 
			case 9125: //Accurate
			case 6221: // range accurate
			case 22228: //punch (unarmed)
			case 48010: //flick (whip)
			case 21200: //spike (pickaxe)
			case 1080: //bash (staff)
			case 6168: //chop (axe)
			case 6236: //accurate (long bow)
			case 17102: //accurate (darts)
			case 8234: //stab (dagger)
			c.fightMode = 0;
			if (c.autocasting)
				c.getPA().resetAutocast();
			break;
			
			case 9126: //Defensive
			case 48008: //deflect (whip)
			case 22229: //block (unarmed)
			case 21201: //block (pickaxe)
			case 1078: //focus - block (staff)
			case 6169: //block (axe)
			case 33019: //fend (hally)
			case 18078: //block (spear)
			case 8235: //block (dagger)
			c.fightMode = 1;
			if (c.autocasting)
				c.getPA().resetAutocast();
			break;
			
			case 9127: // Controlled
			case 48009: //lash (whip)
			case 33018: //jab (hally)
			case 6234: //longrange (long bow)
			case 6219: //longrange
			case 18077: //lunge (spear)
			case 18080: //swipe (spear)
			case 18079: //pound (spear)
			case 17100: //longrange (darts)
			c.fightMode = 3;
			if (c.autocasting)
				c.getPA().resetAutocast();
			break;
			
			case 9128: //Aggressive
			case 6220: // range rapid
			case 22230: //kick (unarmed)
			case 21203: //impale (pickaxe)
			case 21202: //smash (pickaxe)
			case 1079: //pound (staff)
			case 6171: //hack (axe)
			case 6170: //smash (axe)
			case 33020: //swipe (hally)
			case 6235: //rapid (long bow)
			case 17101: //repid (darts)
			case 8237: //lunge (dagger)
			case 8236: //slash (dagger)
			c.fightMode = 2;
			if (c.autocasting)
				c.getPA().resetAutocast();
			break;	
			
			
			/**Prayers**/
			case 21233: // thick skin
			c.getCombat().activatePrayer(0);
			break;	
			case 21234: // burst of str
			c.getCombat().activatePrayer(1);
			break;	
			case 21235: // charity of thought
			c.getCombat().activatePrayer(2);
			break;	
			case 70080: // range
			c.getCombat().activatePrayer(3);
			break;
			case 70082: // mage
			c.getCombat().activatePrayer(4);
			break;
			case 21236: // rockskin
			c.getCombat().activatePrayer(5);
			break;
			case 21237: // super human
			c.getCombat().activatePrayer(6);
			break;
			case 21238:	// improved reflexes
			c.getCombat().activatePrayer(7);
			break;
			case 21239: //hawk eye
			c.getCombat().activatePrayer(8);
			break;
			case 21240:
			c.getCombat().activatePrayer(9);
			break;
			case 21241: // protect Item
			c.getCombat().activatePrayer(10);
			break;			
			case 70084: // 26 range
			c.getCombat().activatePrayer(11);
			break;
			case 70086: // 27 mage
			c.getCombat().activatePrayer(12);
			break;	
			case 21242: // steel skin
			c.getCombat().activatePrayer(13);
			break;
			case 21243: // ultimate str
			c.getCombat().activatePrayer(14);
			break;
			case 21244: // incredible reflex
			c.getCombat().activatePrayer(15);
			break;	
			case 21245: // protect from magic
			c.getCombat().activatePrayer(16);
			break;					
			case 21246: // protect from range
			c.getCombat().activatePrayer(17);
			break;
			case 21247: // protect from melee
			c.getCombat().activatePrayer(18);
			break;
			case 70088: // 44 range
			c.getCombat().activatePrayer(19);
			break;	
			case 70090: // 45 mystic
			c.getCombat().activatePrayer(20);
			break;				
			case 2171: // retrui
			c.getCombat().activatePrayer(21);
			break;					
			case 2172: // redem
			c.getCombat().activatePrayer(22);
			break;					
			case 2173: // smite
			c.getCombat().activatePrayer(23);
			break;
			case 70092: // chiv
			c.getCombat().activatePrayer(24);
			break;
			case 70094: // turmoil
			c.getCombat().activatePrayer(25);
			c.gfx100(1224);
			c.startAnimation(782);
			break;		

			case 13092:
			Client ot = (Client) Server.playerHandler.players[c.tradeWith];
			if(ot == null) {
				c.getTradeAndDuel().declineTrade();
				c.sendMessage("Trade declined as the other player has disconnected.");
				break;
			}
			c.getPA().sendFrame126("Waiting for other player...", 3431);
			ot.getPA().sendFrame126("Other player has accepted", 3431);	
			c.goodTrade= true;
			ot.goodTrade= true;
			
			for (GameItem item : c.getTradeAndDuel().offeredItems) {
				if (item.id > 0) {
					if(ot.getItems().freeSlots() < c.getTradeAndDuel().offeredItems.size()) {					
						c.sendMessage(ot.playerName +" only has "+ot.getItems().freeSlots()+" free slots, please remove "+(c.getTradeAndDuel().offeredItems.size() - ot.getItems().freeSlots())+" items.");
						ot.sendMessage(c.playerName +" has to remove "+(c.getTradeAndDuel().offeredItems.size() - ot.getItems().freeSlots())+" items or you could offer them "+(c.getTradeAndDuel().offeredItems.size() - ot.getItems().freeSlots())+" items.");
						c.goodTrade= false;
						ot.goodTrade= false;
						c.getPA().sendFrame126("@red@Not enough inventory space...", 3431);
						ot.getPA().sendFrame126("@red@Not enough inventory space...", 3431);
							break;
					} else {
						c.getPA().sendFrame126("Waiting for other player...", 3431);				
						ot.getPA().sendFrame126("Other player has accepted", 3431);
						c.goodTrade= true;
						ot.goodTrade= true;
						}
					}	
				}	
				if (c.inTrade && !c.tradeConfirmed && ot.goodTrade && c.goodTrade) {
					c.tradeConfirmed = true;
					if(ot.tradeConfirmed) {
						c.getTradeAndDuel().confirmScreen();
						ot.getTradeAndDuel().confirmScreen();
						break;
					}
							  
				}

		
			break;
					
			case 13218:
			c.tradeAccepted = true;
			Client ot1 = (Client) Server.playerHandler.players[c.tradeWith];
				if (ot1 == null) {
					c.getTradeAndDuel().declineTrade();
					c.sendMessage("Trade declined as the other player has disconnected.");
					break;
				}
				
				if (c.inTrade && c.tradeConfirmed && ot1.tradeConfirmed && !c.tradeConfirmed2) {
					c.tradeConfirmed2 = true;
					if(ot1.tradeConfirmed2) {	
						c.acceptedTrade = true;
						ot1.acceptedTrade = true;
						c.getTradeAndDuel().giveItems();
						ot1.getTradeAndDuel().giveItems();
						break;
					}
				ot1.getPA().sendFrame126("Other player has accepted.", 3535);
				c.getPA().sendFrame126("Waiting for other player...", 3535);
				}
				
			break;		
			/* Rules Interface Buttons */
			case 125011: //Click agree
				if(!c.ruleAgreeButton) {
					c.ruleAgreeButton = true;
					c.getPA().sendFrame36(701, 1);
				} else {
					c.ruleAgreeButton = false;
					c.getPA().sendFrame36(701, 0);
				}
				break;
			case 125003://Accept
				if(c.ruleAgreeButton) {
					c.getPA().showInterface(3559);
					c.newPlayer = false;
				} else if(!c.ruleAgreeButton) {
					c.sendMessage("You need to click on you agree before you can continue on.");
				}
				break;
			case 125006://Decline
				c.sendMessage("You have chosen to decline, Client will be disconnected from the server.");
				break;
			/* End Rules Interface Buttons */
			/* Player Options */
			case 74184:
				if(!c.splitChat) {
					c.splitChat = true;
					c.getPA().sendFrame36(502, 1);
					c.getPA().sendFrame36(287, 1);
				} else {
					c.splitChat = false;
					c.getPA().sendFrame36(502, 0);
					c.getPA().sendFrame36(287, 0);
				}
				break;
			case 74192:
				if(!c.isRunning2) {
					c.isRunning2 = true;
					c.getPA().sendFrame36(504, 1);
					c.getPA().sendFrame36(173, 1);
				} else {
					c.isRunning2 = false;
					c.getPA().sendFrame36(504, 0);
					c.getPA().sendFrame36(173, 0);
				}
				break;
			case 74201://brightness1
				c.getPA().sendFrame36(505, 1);
				c.getPA().sendFrame36(506, 0);
				c.getPA().sendFrame36(507, 0);
				c.getPA().sendFrame36(508, 0);
				c.getPA().sendFrame36(166, 1);
				break;
			case 74203://brightness2
				c.getPA().sendFrame36(505, 0);
				c.getPA().sendFrame36(506, 1);
				c.getPA().sendFrame36(507, 0);
				c.getPA().sendFrame36(508, 0);
				c.getPA().sendFrame36(166,2);
				break;

			case 74204://brightness3
				c.getPA().sendFrame36(505, 0);
				c.getPA().sendFrame36(506, 0);
				c.getPA().sendFrame36(507, 1);
				c.getPA().sendFrame36(508, 0);
				c.getPA().sendFrame36(166,3);
				break;

			case 74205://brightness4
				c.getPA().sendFrame36(505, 0);
				c.getPA().sendFrame36(506, 0);
				c.getPA().sendFrame36(507, 0);
				c.getPA().sendFrame36(508, 1);
				c.getPA().sendFrame36(166,4);
				break;
			case 74206://area1
				c.getPA().sendFrame36(509, 1);
				c.getPA().sendFrame36(510, 0);
				c.getPA().sendFrame36(511, 0);
				c.getPA().sendFrame36(512, 0);
				break;
			case 74207://area2
				c.getPA().sendFrame36(509, 0);
				c.getPA().sendFrame36(510, 1);
				c.getPA().sendFrame36(511, 0);
				c.getPA().sendFrame36(512, 0);
				break;
			case 74208://area3
				c.getPA().sendFrame36(509, 0);
				c.getPA().sendFrame36(510, 0);
				c.getPA().sendFrame36(511, 1);
				c.getPA().sendFrame36(512, 0);
				break;
			case 74209://area4
				c.getPA().sendFrame36(509, 0);
				c.getPA().sendFrame36(510, 0);
				c.getPA().sendFrame36(511, 0);
				c.getPA().sendFrame36(512, 1);
				break;
			case 168:
                c.startAnimation(855);
            break;
            case 169:
                c.startAnimation(856);
            break;
            case 162:
                c.startAnimation(857);
            break;
            case 164:
                c.startAnimation(858);
            break;
            case 165:
                c.startAnimation(859);
            break;
            case 161:
                c.startAnimation(860);
            break;
            case 170:
                c.startAnimation(861);
            break;
            case 171:
                c.startAnimation(862);
            break;
            case 163:
                c.startAnimation(863);
            break;
            case 167:
         	c.startAnimation(864);
            break;
            case 172:
                c.startAnimation(865);
            break;
            case 166:
                c.startAnimation(866);
            break;
            case 52050:
                c.startAnimation(2105);
            break;
            case 52051:
                c.startAnimation(2106);
            break;
            case 52052:
                c.startAnimation(2107);
            break;
            case 52053:
                c.startAnimation(2108);
            break;
            case 52054:
                c.startAnimation(2109);
            break;
            case 52055:
                c.startAnimation(2110);
            break;
            case 52056:
                c.startAnimation(2111);
            break;
            case 52057:
                c.startAnimation(2112);
            break;
            case 52058:
                c.startAnimation(2113);
            break;
            case 43092:
                c.startAnimation(0x558);
            break;
            case 2155:
                c.startAnimation(0x46B);
            break;
            case 25103:
                c.startAnimation(0x46A);
            break;
            case 25106:
                c.startAnimation(0x469);
            break;
            case 2154:
                c.startAnimation(0x468);
            break;
            case 52071:
                c.startAnimation(0x84F);
            break;
            case 52072:
                c.startAnimation(0x850);
            break;
            case 59062:
                c.startAnimation(2836);
            break;
            case 72032:
                c.startAnimation(3544);
            break;
            case 72033:
                c.startAnimation(3543);
            break;
            case 72254:
                c.startAnimation(3866);
            break;
			/* END OF EMOTES */

			case 118098:
				if (c.playerLevel[1] < 20) {
					c.sendMessage("You need 20 defence to cast this spell."); 
				} else {
					c.getPA().vengMe();
				}
				//SkillMenu.openInterface(c, -1)
				//SkillMenu.openInterface(c,0);
			break;
			
			case 24017:
				c.getPA().resetAutocast();
				//c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
				c.getItems().sendWeapon(c.playerEquipment[c.playerWeapon], c.getItems().getItemName(c.playerEquipment[c.playerWeapon]));
				//c.setSidebarInterface(0, 328);
				//c.setSidebarInterface(6, c.playerMagicBook == 0 ? 1151 : c.playerMagicBook == 1 ? 12855 : 1151);
			break;
			//main quest log in book
			//K3LLY
			case 28170:
				c.getPA().sendFrame107();
				if(c.quest1Part == 0) {
					c.sendMessage("To start Quest talk to Juliet.");
					c.getPA().sendFrame36(8714, 0);
					c.getPA().sendFrame171(171, 0);
				} else if (c.quest1Part == 1) {
					c.sendMessage("Find and kill a Dagannoth!");
					c.getPA().sendFrame171(171, 0);
				} else if(c.quest1Part == 2) {
					c.sendMessage("Return to Juliet");
					c.getPA().sendFrame171(171, 0);
				} else if(c.quest1Part == 3) {
					c.sendMessage("Find King Arthur south of EdgeVille");
				} else if(c.quest1Part == 4) {
					c.sendMessage("Find and kill the Kalphite Queen!");
				} else if(c.quest1Part == 5) {
					c.sendMessage("Return to King Arthur");
				} else {
					c.sendMessage("QUEST COMPLETED!");
				}
				break;
		}
		if (c.isAutoButton(actionButtonId))
			c.assignAutocast(actionButtonId);
}
	}