package server.model.minigames;

import server.util.Misc;

public class LastManStandingManager {
	private LastManStandingHandler lms;
	public LastManStandingManager() {
		this.lms = new LastManStandingHandler();
	}
	
	//handles the game starting and control for lms 
	public void process() {
		lms.process(LastManStanding.holdLMSList, LastManStanding.playerList);
	}
}