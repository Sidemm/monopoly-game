package domain;

public class TransitStation extends Square{
	//EFFECTS: Creates a square that is a transit station
	int railroadPrice;
	int railroadOwnerID;
	
	public TransitStation(String name , int position, int utilityPrice) {
		super();
		this.squareName=name;
		this.position=position;
		this.railroadPrice = utilityPrice;
		this.railroadOwnerID = -1;
	}
	
	public void setRailroadOwnerID(int railroadOwnerID) {
		// MODIFIES: railroadOwnerID, owner ID of the railroad square.
		//EFFECTS: Updates the owner of the transit station square.
		this.railroadOwnerID = railroadOwnerID;
	}
	@Override
	public void landedOn(Player player) {
		//EFFECTS: Updates player's position to the square
		// TODO Auto-generated method stub
		
	}

}
