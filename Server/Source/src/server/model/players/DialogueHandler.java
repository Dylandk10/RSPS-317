package server.model.players;

import server.util.Misc;

public class DialogueHandler {

	private Client c;
	
	public DialogueHandler(Client client) {
		this.c = client;
	}
	
	/**
	 * Handles all talking
	 * @param dialogue The dialogue you want to use
	 * @param npcId The npc id that the chat will focus on during the chat
	 */
	public void sendDialogues(int dialogue, int npcId) {
		c.talkingNpc = npcId;
		switch(dialogue) {

		case 0:
			c.talkingNpc = -1;
			c.getPA().removeAllWindows();
			c.nextChat = 0;
			break;
		case 1:
			sendStatement("You found a hidden tunnel! Do you want to enter it?");
			c.dialogueAction = 1;
			c.nextChat = 2;
			break;
		case 2:
			sendOption2("Yea! I'm fearless!",  "No way! That looks scary!");
			c.dialogueAction = 1;
			c.nextChat = 0;
			break;
		case 5:
			sendNpcChat4("Hello adventurer...", "My name is Kolodion, the master of this mage bank.", "Would you like to play a minigame in order ", 
						"to earn points towards recieving magic related prizes?", c.talkingNpc, "Kolodion");
			c.nextChat = 6;
		break;
		case 6:
			sendNpcChat4("The way the game works is as follows...", "You will be teleported to the wilderness,", 
			"You must kill mages to recieve points,","redeem points with the chamber guardian.", c.talkingNpc, "Kolodion");
			c.nextChat = 15;
		break;
		case 11:
			sendNpcChat2("Hello there young one","would you like a slayer task similar to your combat level?", c.talkingNpc, "Duradel");
			c.nextChat = 12;
		break;
		case 12:
			sendOption2("Yes I would like a slayer task.", "No I would not like a slayer task.");
			c.dialogueAction = 5;
		break;
		case 13:
			sendNpcChat2("I see You already have a task.", 
			"Would you like an easier task?", c.talkingNpc, "Duradel");
			c.nextChat = 14;
		break;
		case 14:
			sendOption2("Yes I would like an easier task.", "No I would like to keep my task.");
			c.dialogueAction = 6;
		break;
		case 15:
			sendOption2("Yes I would like to play", "No, sounds too dangerous for me.");
			c.dialogueAction = 7;
		break;
		case 16:
			sendOption2("I would like to fix all my barrows.", "Cancel");
			c.dialogueAction = 8;
		break;
		case 17:
			sendOption5("Air", "Water", "Earth", "Blood", "More");
			c.dialogueAction = 10;
			c.dialogueId = 17;
			c.teleAction = -1;
		break;
		case 18:
			sendOption5("Mind", "Body", "Cosmic", "blood", "More");
			c.dialogueAction = 11;
			c.dialogueId = 18;
			c.teleAction = -1;
		break;
		case 19:
			sendOption5("Nature", "Law", "Death", "Blood", "Previous");
			c.dialogueAction = 12;
			c.dialogueId = 19;
			c.teleAction = -1;
		break;
		case 23:
			sendOption3("44 Portals", "East Dragons", "Mage Bank");
			c.dialogueAction = 14;
		break;
		//case 24 juilet to start the main quest!
		//K3LLY
		case 24:
			sendNpcChat1("So you Think you can handle danger?", c.talkingNpc, "Juliet");
			c.nextChat = 26;
		break;
		case 25:
			sendOption2("yes", "No");
			c.nextChat = 0;
		break;
		//for main quest parts / init
		//K3LLY
		case 26:
			if(c.quest1Part == 0) {
				sendNpcChat1("Find the daganoth lair and kill one!", c.talkingNpc, "Juliet");
				c.nextChat = 0;
				c.quest1Part = 1;
				c.sendMessage("You are now on part: " + c.quest1Part);
			} else if (c.quest1Part == 2) {
				sendNpcChat1("nicely Done...find King Arthur south of here..", c.talkingNpc, "Juliet");
				c.nextChat = 0;
				c.quest1Part = 3;
				c.sendMessage("You are now on part: " + c.quest1Part);
			} else if(c.quest1Part == 6) {
				sendNpcChat1("Thank you for your help warrior!", c.talkingNpc, "Juliet");
				c.nextChat = 0;
			} else {
				sendNpcChat1("I have already told you your task!", c.talkingNpc, "Juliet");
				c.nextChat = 0;
			}
		break;
		case 27:
			sendNpcChat1("Hello there Traveler!", c.talkingNpc, "Party Pete");
			c.nextChat = 28;
		break;
		case 28:
			sendNpcChat1("Sorry about my party room...", c.talkingNpc, "Party Pete");
			c.nextChat = 29;
		break;
		case 29:
			sendNpcChat1("yes, the party chest is currently under construction...", c.talkingNpc, "Party Pete");
			c.nextChat = 30;
		break;
		case 30:
			sendNpcChat1("you will just have to manually drop it... sorry", c.talkingNpc, "Party Pete");
			c.nextChat = 0;
		break;
		case 31:
			sendNpcChat1("I miss her :(", c.talkingNpc, "Romeo");
			c.nextChat = 0;
		break;
		case 32:
			sendNpcChat1("What you want fool?", c.talkingNpc, "Sir Jerro");
			c.nextChat = 33;
		break;
		case 33:
			sendNpcChat1("Aint no way, you're gettng my treasure!", c.talkingNpc, "Sir Jerro");
			c.nextChat = 34;
		break;
		case 34:
			sendPlayerChat1("We'll see... Mr 'I think im so Undestroyable'");
			c.nextChat = 35;
		break;
		case 35:
			sendStatement("well what you waiting on? Start Attacking him!");
			c.nextChat = 0;
		break;
		case 36:
			sendNpcChat1("You have " + c.magePoints + " points.", c.talkingNpc, "Irksol");
			c.nextChat = 37;
		break;
		case 37:
			sendNpcChat1("Would you like to Increase your points?", c.talkingNpc, "Irksol");
			c.nextChat = 38;
		break;
		case 38:
			sendOption2("Yes", "No");
			c.dialogueAction = 7;
			c.nextChat = 0;
		break;
		case 39:
			sendNpcChat1("Dont you dare make fun of our gangsta dance.", c.talkingNpc, "Knight");
			c.nextChat = 0;
		break;
		//for the main quest line part 3
		//K3LLY
		case 40:
			sendNpcChat1("I see Juliet has sent you to me, but danger lies ahead", c.talkingNpc, "King Arthur");
			c.nextChat = 41;
			break;
		case 41:
			sendNpcChat1("Find the Kalphite Queen and kill her, then ill reward you!", c.talkingNpc, "King Arthur");
			c.nextChat = 0;
			c.quest1Part = 4;
			c.sendMessage("You are now on part " + c.quest1Part);
			break;
		case 42:
			sendNpcChat1("I already told you your Quest task!", c.talkingNpc, "King Arthur");
			c.nextChat = 0;
			break;
		case 43: 
			sendNpcChat1("You lived..truly are a worthy warrior take this as a reward!", c.talkingNpc, "King Arthur");
			c.nextChat = 0;
			c.quest1Part = 6;
			c.getItems().addItem(4151, 1);
			c.sendMessage("You recieved a Whip! QUEST COMPLETED!");
		break;
		
		case 44:
			sendNpcChat1("You are a true warrior my friend!", c.talkingNpc, "King Arthur");
			c.nextChat = 0;
		break;
		}
	}
	
	/*
	 * Information Box
	 */
	
	public void sendStartInfo(String text, String text1, String text2, String text3, String title) {
		c.getPA().sendFrame126(title, 6180);
		c.getPA().sendFrame126(text, 6181);
		c.getPA().sendFrame126(text1, 6182);
		c.getPA().sendFrame126(text2, 6183);
		c.getPA().sendFrame126(text3, 6184);
		c.getPA().sendFrame164(6179);
	}
	
	/*
	 * Options
	 */
	
	private void sendOption(String s, String s1) {
		c.getPA().sendFrame126("Select an Option", 2470);
	 	c.getPA().sendFrame126(s, 2471);
		c.getPA().sendFrame126(s1, 2472);
		c.getPA().sendFrame126("Click here to continue", 2473);
		c.getPA().sendFrame164(13758);
	}	
	
	public void sendOption2(String s, String s1) {
		c.getPA().sendFrame126("Select an Option", 2460);
		c.getPA().sendFrame126(s, 2461);
		c.getPA().sendFrame126(s1, 2462);
		c.getPA().sendFrame164(2459);
	}
	
	private void sendOption3(String s, String s1, String s2) {
		c.getPA().sendFrame126("Select an Option", 2470);
		c.getPA().sendFrame126(s, 2471);
		c.getPA().sendFrame126(s1, 2472);
		c.getPA().sendFrame126(s2, 2473);
		c.getPA().sendFrame164(2469);
	}
	
	public void sendOption4(String s, String s1, String s2, String s3) {
		c.getPA().sendFrame126("Select an Option", 2481);
		c.getPA().sendFrame126(s, 2482);
		c.getPA().sendFrame126(s1, 2483);
		c.getPA().sendFrame126(s2, 2484);
		c.getPA().sendFrame126(s3, 2485);
		c.getPA().sendFrame164(2480);
	}
	
	public void sendOption5(String s, String s1, String s2, String s3, String s4) {
		c.getPA().sendFrame126("Select an Option", 2493);
		c.getPA().sendFrame126(s, 2494);
		c.getPA().sendFrame126(s1, 2495);
		c.getPA().sendFrame126(s2, 2496);
		c.getPA().sendFrame126(s3, 2497);
		c.getPA().sendFrame126(s4, 2498);
		c.getPA().sendFrame164(2492);
	}

	/*
	 * Statements
	 */
	
	private void sendStatement(String s) { // 1 line click here to continue chat box interface
		c.getPA().sendFrame126(s, 357);
		c.getPA().sendFrame126("Click here to continue", 358);
		c.getPA().sendFrame164(356);
	}
	
	/*
	 * Npc Chatting
	 */
	
	public void sendNpcChat1(String s, int ChatNpc, String name) {
		c.getPA().sendFrame200(4883, 591);
		c.getPA().sendFrame126(name, 4884);
		c.getPA().sendFrame126(s, 4885);
		c.getPA().sendFrame75(ChatNpc, 4883);
		c.getPA().sendFrame164(4882);
	}
	
	private void sendNpcChat2(String s, String s1, int ChatNpc, String name) {
		c.getPA().sendFrame200(4888, 591);
		c.getPA().sendFrame126(name, 4889);
		c.getPA().sendFrame126(s, 4890);
		c.getPA().sendFrame126(s1, 4891);
		c.getPA().sendFrame75(ChatNpc, 4888);
		c.getPA().sendFrame164(4887);
	}
	
	private void sendNpcChat3(String s, String s1, String s2, int ChatNpc, String name) {
		c.getPA().sendFrame200(4894, 591);
		c.getPA().sendFrame126(name, 4895);
		c.getPA().sendFrame126(s, 4896);
		c.getPA().sendFrame126(s1, 4897);
		c.getPA().sendFrame126(s2, 4898);
		c.getPA().sendFrame75(ChatNpc, 4894);
		c.getPA().sendFrame164(4893);
	}
	
	private void sendNpcChat4(String s, String s1, String s2, String s3, int ChatNpc, String name) {
		c.getPA().sendFrame200(4901, 591);
		c.getPA().sendFrame126(name, 4902);
		c.getPA().sendFrame126(s, 4903);
		c.getPA().sendFrame126(s1, 4904);
		c.getPA().sendFrame126(s2, 4905);
		c.getPA().sendFrame126(s3, 4906);
		c.getPA().sendFrame75(ChatNpc, 4901);
		c.getPA().sendFrame164(4900);
	}
	
	/*
	 * Player Chating Back
	 */
	
	private void sendPlayerChat1(String s) {
		c.getPA().sendFrame200(969, 591);
		c.getPA().sendFrame126(c.playerName, 970);
		c.getPA().sendFrame126(s, 971);
		c.getPA().sendFrame185(969);
		c.getPA().sendFrame164(968);
	}
	
	private void sendPlayerChat2(String s, String s1) {
		c.getPA().sendFrame200(974, 591);
		c.getPA().sendFrame126(c.playerName, 975);
		c.getPA().sendFrame126(s, 976);
		c.getPA().sendFrame126(s1, 977);
		c.getPA().sendFrame185(974);
		c.getPA().sendFrame164(973);
	}
	
	private void sendPlayerChat3(String s, String s1, String s2) {
		c.getPA().sendFrame200(980, 591);
		c.getPA().sendFrame126(c.playerName, 981);
		c.getPA().sendFrame126(s, 982);
		c.getPA().sendFrame126(s1, 983);
		c.getPA().sendFrame126(s2, 984);
		c.getPA().sendFrame185(980);
		c.getPA().sendFrame164(979);
	}
	
	private void sendPlayerChat4(String s, String s1, String s2, String s3) {
		c.getPA().sendFrame200(987, 591);
		c.getPA().sendFrame126(c.playerName, 988);
		c.getPA().sendFrame126(s, 989);
		c.getPA().sendFrame126(s1, 990);
		c.getPA().sendFrame126(s2, 991);
		c.getPA().sendFrame126(s3, 992);
		c.getPA().sendFrame185(987);
		c.getPA().sendFrame164(986);
	}
}
