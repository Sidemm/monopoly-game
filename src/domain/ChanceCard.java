package domain;

public class ChanceCard extends Card {
	
	//OVERVIEW: Chance Card class performs the action according to the
	//			chance card that is picked the current player.
	//			As common it shows the card info for all cards. 
	//EFFECTS: Creates a Chance Card that requires different actions
	//			for different chance cards.
	
	int cardID = 0; //BU OKEY MIIIIIII?????
	boolean keep = false;
	
	public ChanceCard(){
		
	}
	
	@Override
	public void performRequirement(Player p) {
		
		//REQUIRES: p is the current player
		//MODIFIES: player.position, position of the player
		//EFFECTS: performs the action according to requirement such as 
		//			updating player and bank money, updating player location
		//			setting location owner,updating assets of the player etc.
		
		// TODO Auto-generated method stub
		switch(cardID){
		
		//play immediately cards
		case 1:
			showCardInfo("MARDI GRAS!");
			////BURAYA BAKKKK
			break;
		case 2:
			showCardInfo("Advance to the Nearest Railroad");
			
			break;
		case 3:
			showCardInfo("Advance to Illinois Ave.");
			int pos = Board.findSquare("Illinois Ave.");
			p.playerPosition = pos;
			Location loc = (Location) Game.monopolyBoard.getSquare(pos); //squareList initialize edilince ��z�lcek in�
			if(loc.locationOwnerID != 0){
				p.payRent(loc);
			}
			break;
		case 4:
			showCardInfo("Get Taken for a Ride");
			
			break;
		case 5:
			showCardInfo("Go To Jail!");
			p.advanceToSquare(Board.findSquare("Jail"));
			break;
		case 6:
			showCardInfo("Make General Repairs to all your properties");
			int payRepair = 0;
			for(String property : p.returnProperties()){
				if(property == "House" || 
				   property == "Cab" || 
				   property == "Stand" ||
				   property == "Transit Station") {
					payRepair+=25;
				} else if(property == "Hotel" || property == "Skyscraper"){
					payRepair+=100;
				}
			}
			p.decreaseBalance(payRepair);
			Bank.increaseTotalMoney(payRepair);
			break;
		case 7:
			showCardInfo("Traffic Ticket!");
			p.decreaseBalance(15);
			Bank.increaseTotalMoney(15);
			break;
		case 8:
			showCardInfo("Advance to Stock Exchange");
			p.advanceToSquare(Board.findSquare("Stock Exchange"));
			break;
		case 9:
			showCardInfo("Buyer's Market");
			break;
		case 10:
			showCardInfo("Advance to the Pay Corner");
			break;
		case 11:
			showCardInfo("Property Taxes");
			break;
		case 12:
			showCardInfo("Business Trip");
			break;
		case 13:
			showCardInfo("Advance to Squeeze Play");
			break;
		case 14:
			showCardInfo("Pay Back!");
			break;
		case 15:
			showCardInfo("Changing Lanes");
			break;
		case 16:
			showCardInfo("Changing Lanes");
			break;
		
		//keep cards
		}
	}
	
}
