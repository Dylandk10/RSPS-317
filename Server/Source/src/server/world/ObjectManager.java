package server.world;

import java.util.ArrayList;

import server.model.objects.Object;
import server.util.Misc;
import server.model.players.Client;
import server.Server;

/**
 * @author Sanity
 */

public class ObjectManager {

	public ArrayList<Object> objects = new ArrayList<Object>();
	private ArrayList<Object> toRemove = new ArrayList<Object>();
	public void process() {
		for (Object o : objects) {
			if (o.tick > 0)
				o.tick--;
			else {
				updateObject(o);
				toRemove.add(o);
			}		
		}
		for (Object o : toRemove) {
			if (isObelisk(o.newId)) {
				int index = getObeliskIndex(o.newId);
				if (activated[index]) {
					activated[index] = false;
					teleportObelisk(index);
				}
			}
			objects.remove(o);	
		}
		toRemove.clear();
	}
	
	public void removeObject(int x, int y) {
		for (int j = 0; j < Server.playerHandler.players.length; j++) {
			if (Server.playerHandler.players[j] != null) {
				Client c = (Client)Server.playerHandler.players[j];
				c.getPA().object(-1, x, y, 0, 10);
				c.getPA().object(-1, 3281, 3495, 0, 10);			
			}	
		}	
	}
	
	public void updateObject(Object o) {
		for (int j = 0; j < Server.playerHandler.players.length; j++) {
			if (Server.playerHandler.players[j] != null) {
				Client c = (Client)Server.playerHandler.players[j];
				c.getPA().object(o.newId, o.objectX, o.objectY, o.face, o.type);			
			}	
		}	
	}
	
	public void placeObject(Object o) {
		for (int j = 0; j < Server.playerHandler.players.length; j++) {
			if (Server.playerHandler.players[j] != null) {
				Client c = (Client)Server.playerHandler.players[j];
				if (c.distanceToPoint(o.objectX, o.objectY) <= 60)
					c.getPA().object(o.objectId, o.objectX, o.objectY, o.face, o.type);
			}	
		}
	}
	
	public Object getObject(int x, int y, int height) {
		for (Object o : objects) {
			if (o.objectX == x && o.objectY == y && o.height == height)
				return o;
		}	
		return null;
	}
	
	public void loadObjects(Client c) {
		if (c == null)
			return;
		for (Object o : objects) {
			if (loadForPlayer(o,c))
				c.getPA().object(o.objectId, o.objectX, o.objectY, o.face, o.type);
		}
		loadCustomSpawns(c);
		if (c.distanceToPoint(2813, 3463) <= 60) {
			c.getFarming().updateHerbPatch();
		}
	}
	
	private int[][] customObjects = {{}};
	public void loadCustomSpawns(Client c) {
		//runecrafting
		c.getPA().checkObjectSpawn(7129, 1923, 5012, 0, 10);
		//stalls
		c.getPA().checkObjectSpawn(4878, 3084, 3497, 1, 10);
		c.getPA().checkObjectSpawn(4874, 3084, 3495, 1, 10);
		c.getPA().checkObjectSpawn(4877, 3084, 3493, 1, 10);
		c.getPA().checkObjectSpawn(4875, 3084, 3491, 1, 10);
		c.getPA().checkObjectSpawn(4876, 3084, 3489, 1, 10);
		//stalls
		c.getPA().checkObjectSpawn(3084, 3493, 3425, 0, 10);
		c.getPA().checkObjectSpawn(1755, 3055, 9774, 0, 0);
		c.getPA().checkObjectSpawn(1596, 3008, 3850, 1, 0);
		c.getPA().checkObjectSpawn(1596, 3008, 3849, -1, 0);
		c.getPA().checkObjectSpawn(1596, 3040, 10307, -1, 0);
		c.getPA().checkObjectSpawn(1596, 3040, 10308, 1, 0);
		c.getPA().checkObjectSpawn(1596, 3022, 10311, -1, 0);
		c.getPA().checkObjectSpawn(1596, 3022, 10312, 1, 0);
		c.getPA().checkObjectSpawn(1596, 3044, 10341, -1, 0);
		c.getPA().checkObjectSpawn(1596, 3044, 10342, 1, 0);
		c.getPA().checkObjectSpawn(2213, 3080, 9502, 1, 10);
		c.getPA().checkObjectSpawn(2475, 3233, 9312, 1, 10);
		c.getPA().checkObjectSpawn(4551, 2522, 3595, 1, 10);
		//premium isle mining rocks
		c.getPA().checkObjectSpawn(14859, 3175, 3364, 1, 10);
		c.getPA().checkObjectSpawn(14859, 3177, 3364, 1, 10);
		c.getPA().checkObjectSpawn(2090, 3180, 3368, 1, 10);
		c.getPA().checkObjectSpawn(2090, 3178, 3368, 1, 10);
		//home
		c.getPA().checkObjectSpawn(409, 3085, 3508, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3088, 3509, 1, 10);
		//premium isle smithing
		//c.getPA().checkObjectSpawn(2782, 2833, 3351, 4, 10);
		if (c.heightLevel == 0)
			c.getPA().checkObjectSpawn(2492, 2105, 4429, 1, 10);
		else
			c.getPA().checkObjectSpawn(-1, 2105, 4429, 1, 10);
		//fishing
		c.getPA().checkObjectSpawn(42, 2845, 3429, 1, 10);
		//doors
		c.getPA().checkObjectSpawn(-1, 2611, 3399, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2611, 3398, 1, 10);
		//crates
		c.getPA().checkObjectSpawn(-1, 3205, 3460, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3204, 3461, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3204, 3459, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3203, 3461, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3203, 3460, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3206, 3459, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3207, 3459, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3208, 3459, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3204, 3460, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3221, 3460, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3221, 3459, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3220, 3459, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3219, 3459, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3218, 3459, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3220, 3456, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3221, 3456, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3218, 3456, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3217, 3456, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3218, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3226, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3227, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3228, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3228, 3454, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3227, 3453, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3226, 3451, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3226, 3452, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3227, 3452, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3204, 3456, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3205, 3456, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3207, 3456, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3208, 3456, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3207, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3223, 3490, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3223, 3491, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3224, 3491, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3224, 3492, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3218, 3491, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3222, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3221, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3220, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3219, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3217, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3216, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3209, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3208, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3206, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3205, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3204, 3455, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3203, 3455, 1, 10);
		//portals godwars
		c.getPA().checkObjectSpawn(2492, 2897, 3618, 1, 10);
		c.getPA().checkObjectSpawn(12269, 2593, 3413, 1, 10);
		//acient and lunar altar home
		c.getPA().checkObjectSpawn(6552, 3085, 3511, 1 ,10);
		c.getPA().checkObjectSpawn(410, 3089, 3510, 1 ,10);
		
		//portal to last man stadning 
		c.getPA().checkObjectSpawn(2156, 3091, 3487, 1, 10);
	}
	
	public final int IN_USE_ID = 14825;
	public boolean isObelisk(int id) {
		for (int j = 0; j < obeliskIds.length; j++) {
			if (obeliskIds[j] == id)
				return true;
		}
		return false;
	}
	public int[] obeliskIds = {14829,14830,14827,14828,14826,14831};
	public int[][] obeliskCoords = {{3154,3618},{3225,3665},{3033,3730},{3104,3792},{2978,3864},{3305,3914}};
	public boolean[] activated = {false,false,false,false,false,false};
	
	public void startObelisk(int obeliskId) {
		int index = getObeliskIndex(obeliskId);
		if (index >= 0) {
			if (!activated[index]) {
				activated[index] = true;
				addObject(new Object(14825, obeliskCoords[index][0], obeliskCoords[index][1], 0, -1, 10, obeliskId,16));
				addObject(new Object(14825, obeliskCoords[index][0] + 4, obeliskCoords[index][1], 0, -1, 10, obeliskId,16));
				addObject(new Object(14825, obeliskCoords[index][0], obeliskCoords[index][1] + 4, 0, -1, 10, obeliskId,16));
				addObject(new Object(14825, obeliskCoords[index][0] + 4, obeliskCoords[index][1] + 4, 0, -1, 10, obeliskId,16));
			}
		}	
	}
	
	public int getObeliskIndex(int id) {
		for (int j = 0; j < obeliskIds.length; j++) {
			if (obeliskIds[j] == id)
				return j;
		}
		return -1;
	}
	
	public void teleportObelisk(int port) {
		int random = Misc.random(5);
		while (random == port) {
			random = Misc.random(5);
		}
		for (int j = 0; j < Server.playerHandler.players.length; j++) {
			if (Server.playerHandler.players[j] != null) {
				Client c = (Client)Server.playerHandler.players[j];
				int xOffset = c.absX - obeliskCoords[port][0];
				int yOffset = c.absY - obeliskCoords[port][1];
				if (c.goodDistance(c.getX(), c.getY(), obeliskCoords[port][0] + 2, obeliskCoords[port][1] + 2, 1)) {
					c.getPA().startTeleport2(obeliskCoords[random][0] + xOffset, obeliskCoords[random][1] + yOffset, 0);
				}
			}		
		}
	}
	
	public boolean loadForPlayer(Object o, Client c) {
		if (o == null || c == null)
			return false;
		return c.distanceToPoint(o.objectX, o.objectY) <= 60 && c.heightLevel == o.height;
	}
	
	public void addObject(Object o) {
		if (getObject(o.objectX, o.objectY, o.height) == null) {
			objects.add(o);
			placeObject(o);
		}	
	}




}
