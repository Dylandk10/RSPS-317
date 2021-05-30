package server.model.players.packets;

import server.model.players.Client;
import server.model.players.PacketType;



/**
 * Clicking an item, bury bone, eat food etc
 **/
public class ClickItem implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		int junk = c.getInStream().readSignedWordBigEndianA();
		int itemSlot = c.getInStream().readUnsignedWordA();
		int itemId = c.getInStream().readUnsignedWordBigEndian();
		if (c.usingCarpet) {
			return;
		}
		if (itemId != c.playerItems[itemSlot] - 1) {
			return;
		}
		if (itemId == 8007) {
			c.getPA().teleTab("varrock");
		}
		if (itemId == 8008) {
			c.getPA().teleTab("lumbridge");
		}
		if (itemId == 8009) {
			c.getPA().teleTab("falador");
		}
		if (itemId == 8010) {
			c.getPA().teleTab("camelot");
		}
		if (itemId == 8011) {
			c.getPA().teleTab("ardy");
		}
		//PvP artefacts.
		if(itemId == 14892) {
			c.getItems().deleteItem(14892, 1);
			c.getItems().addItem(995, 100000);
			c.sendMessage("You activate the mysterious artefact and recieve 100,000 gold.");
		}
		if(itemId == 14891) {
			c.getItems().deleteItem(14891, 1);
			c.getItems().addItem(995, 200000);
			c.sendMessage("You activate the mysterious artefact and recieve 200,000 gold.");
		}
		if(itemId == 14890) {
			c.getItems().deleteItem(14890, 1);
			c.getItems().addItem(995, 300000);
			c.sendMessage("You activate the mysterious artefact and recieve 300,000 gold.");
		}
		if(itemId == 14889) {
			c.getItems().deleteItem(14889, 1);
			c.getItems().addItem(995, 400000);
			c.sendMessage("You activate the mysterious artefact and recieve 400,000 gold.");
		}
		if(itemId == 14888) {
			c.getItems().deleteItem(14888, 1);
			c.getItems().addItem(995, 500000);
			c.sendMessage("You activate the mysterious artefact and recieve 500,000 gold.");
		}
		if(itemId == 14887) {
			c.getItems().deleteItem(14887, 1);
			c.getItems().addItem(995, 600000);
			c.sendMessage("You activate the mysterious artefact and recieve 600,000 gold.");
		}
		if(itemId == 14886) {
			c.getItems().deleteItem(14886, 1);
			c.getItems().addItem(995, 700000);
			c.sendMessage("You activate the mysterious artefact and recieve 700,000 gold.");
		}
		if(itemId == 14885) {
			c.getItems().deleteItem(14885, 1);
			c.getItems().addItem(995, 800000);
			c.sendMessage("You activate the mysterious artefact and recieve 800,000 gold.");
		}
		if(itemId == 14884) {
			c.getItems().deleteItem(14884, 1);
			c.getItems().addItem(995, 900000);
			c.sendMessage("You activate the mysterious artefact and recieve 900,000 gold.");
		}
		if(itemId == 14883) {
			c.getItems().deleteItem(14883, 1);
			c.getItems().addItem(995, 1000000);
			c.sendMessage("You activate the mysterious artefact and recieve 1,000,000 gold.");
		}
		if(itemId == 14882) {
			c.getItems().deleteItem(14882, 1);
			c.getItems().addItem(995, 2000000);
			c.sendMessage("You activate the mysterious artefact and recieve 2,000,000 gold.");
		}
		if(itemId == 14881) {
			c.getItems().deleteItem(14881, 1);
			c.getItems().addItem(995, 3000000);
			c.sendMessage("You activate the mysterious artefact and recieve 3,000,000 gold.");
		}
		//for slayer coin pouch
		//made by K3LLY
		if(itemId == 2957) {
			int random = (int)(Math.random()*100);
			if(random >= 95) {
				c.getItems().deleteItem(2957, 1);
				c.getItems().addItem(995, 1000000);
				c.sendMessage("You hit the Jackpot and recieve 1M!");
			}
			if(random >= 70) {
				c.getItems().deleteItem(2957, 1);
				c.getItems().addItem(995, 10000);
				c.sendMessage("rewarded 100000gp");
			}
			if(random >= 20) {
				c.getItems().deleteItem(2957, 1);
				c.getItems().addItem(995, 10000);
				c.sendMessage("Rewarded 1000gp");
			} else {
				c.getItems().deleteItem(2957, 1);
				c.getItems().addItem(995, 100);
				c.sendMessage("your not so lucky... here's 100gp");
			}
		}
                if(itemId == 550) {
                c.getPA().showInterface(5392); 
                c.sendMessage("You take a look at the newcomers map.");  
                }
		if(itemId == 4155) {
				if (c.slayerTask <= 0) {
					c.getDH().sendDialogues(11,1599);
				} else {
					c.getDH().sendDialogues(13,1599);
				}
		}
		if(itemId == 14880) {
			c.getItems().deleteItem(14880, 1);
			c.getItems().addItem(995, 4000000);
			c.sendMessage("You activate the mysterious artefact and recieve 4,000,000 gold.");
		}
		if(itemId == 14879) {
			c.getItems().deleteItem(14879, 1);
			c.getItems().addItem(995, 4000000);
			c.sendMessage("You activate the mysterious artefact and recieve 5,000,000 gold.");
		}
		if(itemId == 14878) {
			c.getItems().deleteItem(14878, 1);
			c.getItems().addItem(995, 10000000);
			c.sendMessage("You activate the mysterious artefact and recieve 10,000,000 gold.");
		}
		if(itemId == 14877) {
			c.getItems().deleteItem(14877, 1);
			c.getItems().addItem(995, 5000000);
			c.sendMessage("You activate the mysterious artefact and recieve 5,000,000 gold.");
		}
		if(itemId == 14876) {
			c.getItems().deleteItem(14876, 1);
			c.getItems().addItem(995, 10000000);
			c.sendMessage("You activate the mysterious artefact and recieve 10,000,000 gold.");
		}
		if (itemId == 4251) {
			c.getPA().movePlayer(3565, 3316, 0);
			c.sendMessage("You empty the ectophial.");
			c.getItems().deleteItem(4251,c.getItems().getItemSlot(4251), 1);
			c.getItems().addItem(4252, 1);
		}
		if (itemId >= 5509 && itemId <= 5514) {
			int pouch = -1;
			int a = itemId;
			if (a == 5509)
				pouch = 0;
			if (a == 5510)
				pouch = 1;
			if (a == 5512)
				pouch = 2;
			if (a == 5514)
				pouch = 3;
			c.getPA().fillPouch(pouch);
			return;
		}
		if (c.getHerblore().isUnidHerb(itemId))
			c.getHerblore().handleHerbClick(itemId);
		if (c.getFood().isFood(itemId))
			c.getFood().eat(itemId,itemSlot);
		//ScriptManager.callFunc("itemClick_"+itemId, c, itemId, itemSlot);
		if (c.getPotions().isPotion(itemId))
			c.getPotions().handlePotion(itemId,itemSlot);
		if (c.getPrayer().isBone(itemId))
			c.getPrayer().buryBone(itemId, itemSlot);
		if (itemId == 952) {
			if(c.inArea(3553, 3301, 3561, 3294)) {
				c.teleTimer = 3;
				c.newLocation = 1;
			} else if(c.inArea(3550, 3287, 3557, 3278)) {
				c.teleTimer = 3;
				c.newLocation = 2;
			} else if(c.inArea(3561, 3292, 3568, 3285)) {
				c.teleTimer = 3;
				c.newLocation = 3;
			} else if(c.inArea(3570, 3302, 3579, 3293)) {
				c.teleTimer = 3;
				c.newLocation = 4;
			} else if(c.inArea(3571, 3285, 3582, 3278)) {
				c.teleTimer = 3;
				c.newLocation = 5;
			} else if(c.inArea(3562, 3279, 3569, 3273)) {
				c.teleTimer = 3;
				c.newLocation = 6;
			}
		}
	}

}
