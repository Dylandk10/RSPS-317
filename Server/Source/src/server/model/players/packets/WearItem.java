package server.model.players.packets;

import server.model.players.Client;
import server.model.players.PacketType;
import server.util.Misc;


/**
 * Wear Item
 **/
public class WearItem implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		c.wearId = c.getInStream().readUnsignedWord();
		c.wearSlot = c.getInStream().readUnsignedWordA();
		c.interfaceId = c.getInStream().readUnsignedWordA();
		
		int oldCombatTimer = c.attackTimer;
		if ((c.playerIndex > 0 || c.npcIndex > 0) && c.wearId != 4153)
			c.getCombat().resetPlayerAttack();
		if (c.wearId >= 5509 && c.wearId <= 5515) {
			int pouch = -1;
			int a = c.wearId;
			if (a == 5509)
				pouch = 0;
			if (a == 5510)
				pouch = 1;
			if (a == 5512)
				pouch = 2;
			if (a == 5514)
				pouch = 3;
			c.getPA().emptyPouch(pouch);
			return;
		}
if(c.wearId == 7927) {
		c.setSidebarInterface(1, 6014);
		c.setSidebarInterface(2, 6014);
		c.setSidebarInterface(3, 6014);
		c.setSidebarInterface(4, 6014);
		c.setSidebarInterface(5, 6014);
		c.setSidebarInterface(6, 6014);
		c.setSidebarInterface(7, 6014);
		c.setSidebarInterface(8, 6014);
		c.setSidebarInterface(9, 6014); 
		c.setSidebarInterface(10, 6014);
		c.setSidebarInterface(11, 6014);
		c.setSidebarInterface(12, 6014);
		c.setSidebarInterface(13, 6014);
		c.setSidebarInterface(0, 6014);
c.sendMessage("@red@You have turned into an egg. be careful not to roll over!");
c.npcId2 = 3689 + Misc.random(5);
c.isNpc = true;
c.updateRequired = true;
c.appearanceUpdateRequired = true;
}
if(c.wearId == 295) {
		c.setSidebarInterface(1, 6014);
		c.setSidebarInterface(2, 6014);
		c.setSidebarInterface(3, 6014);
		c.setSidebarInterface(4, 6014);
		c.setSidebarInterface(5, 6014);
		c.setSidebarInterface(6, 6014);
		c.setSidebarInterface(7, 6014);
		c.setSidebarInterface(8, 6014);
		c.setSidebarInterface(9, 6014); 
		c.setSidebarInterface(10, 6014);
		c.setSidebarInterface(11, 6014);
		c.setSidebarInterface(12, 6014);
		c.setSidebarInterface(13, 6014);
		c.setSidebarInterface(0, 6014);
c.sendMessage("@red@Holy shit, your Dracula!");
c.npcId2 = 757;
c.isNpc = true;
c.updateRequired = true;
c.appearanceUpdateRequired = true;
}
if(c.wearId == 4202) {
		c.setSidebarInterface(1, 6014);
		c.setSidebarInterface(2, 6014);
		c.setSidebarInterface(3, 6014);
		c.setSidebarInterface(4, 6014);
		c.setSidebarInterface(5, 6014);
		c.setSidebarInterface(6, 6014);
		c.setSidebarInterface(7, 6014);
		c.setSidebarInterface(8, 6014);
		c.setSidebarInterface(9, 6014); 
		c.setSidebarInterface(10, 6014);
		c.setSidebarInterface(11, 6014);
		c.setSidebarInterface(12, 6014);
		c.setSidebarInterface(13, 6014);
		c.setSidebarInterface(0, 6014);
c.sendMessage("@red@You have turned into a mosquito! ewwww!");
c.npcId2 = 2493;
c.isNpc = true;
c.updateRequired = true;
c.appearanceUpdateRequired = true;
}

			//c.attackTimer = oldCombatTimer;
		c.getItems().wearItem(c.wearId, c.wearSlot);
	}

}
