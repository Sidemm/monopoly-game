package domain;

public abstract class Card {
	
	String cardName;
	String type;
	
	public abstract void performRequirement(Player p);
	
	public void showCardInfo(String cardName) { //FRAME OLACAK �EKILDE DEGISTIRRRRRRRRR
		System.out.println("You have picked \""+cardName+"\" card!");
	}
	
}
