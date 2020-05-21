package domain;

public class UtilitySquare extends Square{
	//EFFECTS: Creates a Square that requires utility works
	
	int utilityPrice;
    int utilityOwnerID;
    
    
	
	public UtilitySquare(String name , int position, int utilityPrice) {
		super();
		this.squareName=name;
		this.position=position;
		this.utilityPrice = utilityPrice;
		this.utilityOwnerID = -1;
	}
	
	public void setUtilityOwnerID(int utilityOwnerID) {
		//MODIFIES: utilityOwnerID, owner ID of the utility square
		//EFFECTS: Updates the owner of the utility square according to player ID.
		this.utilityOwnerID = utilityOwnerID;
	}
	@Override
	public void landedOn(Player player) {
		//EFFECTS: Updates player's position to the square
		// TODO Auto-generated method stub
		
	}

}
