package domain;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;



public class Player {
	// OVERVIEW: This class represents players in the game with features
	// such as ID, money, color, position etc. It provides various methods
	// to access or change the features of a player.
	
	
	/* Every player has a unique ID*/
	int playerID;
	/* Every player has initial amount of money*/
	int playerBalance;
	/* Every player has a unique color to represent itself on board*/
	Color playerColor;
	/* The players will buy locations they will be stored in playerAssets*/
	ArrayList<Location> playerAssets;
	/*Players start at the position 0*/
	int playerPosition = 0;
	/*If the player wants to keep a card the playerCardHolder list will keep that.*/
	ArrayList<Card> playerCardHolder = new ArrayList<Card>();
	/*To keep the dice history in case of double throwing*/
	int[][] playerDiceHistory=new int[0][3];
	int diceHistory=0; //doubled dice history
	int count=0; // count of how many time player rolled on its turn.

	private static ArrayList<Observer> observers = new ArrayList<Observer>();
	private static int state = 0;

	public static int getState() {
		// EFFECTS: returns state
		return state;
	}

	public static void setState() {
		// MODIFIES: state, state of the player
		// EFFECTS: Changes the state of the player such that if state is less
		// than zero, sets it to zero. For all other situations sets it to the state%6.
		// In addition to these, notifies all observers
		state++;
		if(state<0)
			state = 0;
		else
			state = state % 6;
		notifyAllObservers();
	}

	public static void attach(Observer observer){
		// MODIFIES: observers, the observer list
		// EFFECTS: Adds observer to observers
		observers.add(observer);		
	}

	public static void notifyAllObservers(){
		// MODIFIES: observers, the observer list
		// EFFECTS: Updates each observer in the observer list
		for (Observer observer : observers) {
			observer.update();
		}
	}

	public static ArrayList<Observer> getObservers() {
		// EFFECTS: Returns observers, the observer list
		return observers;
	}

	public static void start30secondsTimer() throws InterruptedException {
		// MODIFIES: state, state of the player
		// EFFECTS: Runs a timer and sets the state of the player periodically
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				setState();
			}
		}, 5000, 30000);
	}

	public static Player newInstance(int ID, Color color) {
		// MODIFIES: player
		// EFFECTS: Returns a new player object whose fields are set/initialized
		Player p = new Player();
		p.setPlayerColor(color);
		p.setPlayerID(ID);
		p.playerBalance=3200;
		p.playerAssets = new ArrayList<Location>();
		return p;
	}

	public void increaseBalance(int amount) {
		// MODIFIES: playerBalance, player's money
		// EFFECTS: Increases player's money by amount
		playerBalance += amount;
	}

	public void decreaseBalance(int amount) {
		// MODIFIES: playerBalance, player's money
		// EFFECTS: Decreases player's money by amount
		playerBalance -= amount;
	}

	public void buyProperty(Location loc) {
		// MODIFIES: playerBalance
		// 			 Bank.totalMoney
		//			 loc.locationOwnerID
		//			 playerAssets, properties of the player
		// EFFECTS: Decreases the player's money by loc.locationPrice,
		// increases the total money by loc.locationPrice, sets the owner
		// of the location, add the location to the assets of the player
		this.decreaseBalance(loc.locationPrice);
		Bank.increaseTotalMoney(loc.locationPrice);
		loc.setLocationOwnerID(this.playerID);
		playerAssets.add(loc);
	}

	public void buyUtility(UtilitySquare square) {
		// MODIFIES: playerBalance
		//			 Bank.totalMoney
		//			 square.utilityOwnerID
		// EFFECTS: Decreases the player's money by utilityPrice, increases total money
		// by the same amount, sets the owner of the square
		this.decreaseBalance(square.utilityPrice);
		Bank.increaseTotalMoney(square.utilityPrice);
		square.setUtilityOwnerID(this.playerID);
	}

	public void buyRailroad(TransitStation square) {
		// MODIFIES: playerBalance
		//			 Bank.totalMoney
		//			 square.playerID
		// EFFECTS: Decreases the player's money by railroadPrice, increases total money
		// by the same amount, sets the owner of the square
		this.decreaseBalance(square.railroadPrice);
		Bank.increaseTotalMoney(square.railroadPrice);
		square.setRailroadOwnerID(this.playerID);
	}

	public void buildSkyscraper(Location loc){
		// REQUIRES:
		// MODIFIES: loc.locationAssets
		//			 playerBalance
		// EFFECTS: Checks if player has enough money to build a skyscraper,
		//			KARISIK KISIMLAR NABIYO ANLAMADIM
		//			For every asset of the player, checks the color and 
		//			determines if player can build a Skyscraper on that location.
		//			Decreases the player's money and increases Bank.totalMoney.
		// 			Updates the assets placed on the location.
		//			Prints a information message.
		if(playerBalance >= loc.skyscraperCost){
			if(!loc.locationAssets.containsKey("Skyscraper")){
				Color c = loc.locationColor;
				int a = Location.colorGroups.get(c);
				int count = 0;
				for(int i = 0; i<playerAssets.size(); i++){
					Location l = playerAssets.get(i);
					if(l.locationColor.equals(c)){
						if(l.locationAssets.containsKey("Hotel") || l.locationAssets.containsKey("Skyscraper")){
							count++;
						}
					}

				}
				if(count == a){
					loc.locationAssets.put("Skyscraper", 1);
					loc.updateRent();
					decreaseBalance(loc.skyscraperCost);
					Bank.increaseTotalMoney(loc.skyscraperCost);
					System.out.println("A skyscraper has been built succesfully on the location "+loc);
				}else{
					System.out.println(loc+" is not suitable to build a skyscraper!");
				}}else{
					System.out.println(loc+" is not suitable to build a skyscraper!");
				}
		}else{
			System.out.println("Insufficient Funds!");
		}


	}

	public void buildHotel(Location loc){
		// REQUIRES:
		// MODIFIES: loc.locationAssets
		//			 playerBalance
		// EFFECTS: Checks if player has enough money to build a hotel,
		//			KARISIK KISIMLAR NABIYO ANLAMADIM
		//			For every asset of the player, checks the color and 
		//			determines if player can build a hotel on that location.
		//			Decreases the player's money and increases Bank.totalMoney.
		// 			Updates the assets placed on the location.
		//			Prints a information message.
		if(loc.locationAssets.containsKey("House") && loc.locationAssets.get("House")==4 && !loc.locationAssets.containsKey("Hotel")){
			if(playerBalance >= loc.hotelCost){
				Color c = loc.locationColor;
				int a = Location.colorGroups.get(c);
				int count = 0;
				for(int i = 0; i < playerAssets.size(); i++){
					Location l = playerAssets.get(i);
					if(l.locationColor.equals(c)){
						if(l.locationAssets.get("House")==4 || l.locationAssets.containsKey("Hotel")){
							count++;
						}
					}
				}
				if(count >= a){
					decreaseBalance(loc.hotelCost);
					Bank.increaseTotalMoney(loc.hotelCost);
					loc.locationAssets.put("Hotel", 1);
					loc.updateRent();
					System.out.println("A hotel has been built succesfully on the location "+loc);
				}else{
					System.out.println(loc+" is not suitable to build a hotel!");
				}
			}else{
				System.out.println("Insufficient Funds!");
			}
		}else{
			System.out.println(loc+" is not suitable to build a hotel!");
		}

	}

	public void buildHouse(Location loc){
		// REQUIRES:
		// MODIFIES: loc.locationAssets
		//			 playerBalance
		// EFFECTS: Checks if player has enough money to build a house,
		//			KARISIK KISIMLAR NABIYO ANLAMADIM
		//			For every asset of the player, checks the color and 
		//			determines if player can build a house on that location.
		//			Decreases the player's money and increases Bank.totalMoney.
		// 			Updates the assets placed on the location.
		//			Prints a information message.
		if(playerBalance >= loc.houseCost){
			if(!loc.locationAssets.containsKey("Hotel") && !loc.locationAssets.containsKey("Skyscraper") && (!loc.locationAssets.containsKey("House") || loc.locationAssets.get("House")!=4)){
				Color c = loc.locationColor;
				int a = Location.colorGroups.get(c)-1;
				int count = 0;
				for(int i = 0; i < playerAssets.size(); i++){
					if(playerAssets.get(i).locationColor.equals(c)){
						count++;
					}
				}
				if(count >= a){
					decreaseBalance(loc.houseCost);
					Bank.increaseTotalMoney(loc.houseCost);
					if(loc.locationAssets.containsKey("House")){
						int houseNum = loc.locationAssets.get("House");
						loc.locationAssets.put("House", houseNum + 1);
					}else{
						loc.locationAssets.put("House", 1);
					}
					loc.updateRent();
					System.out.println("A house has been built succesfully on the location "+loc);
				}else{
					System.out.println(loc+" is not suitable to build a house!");
				}
			}else{
				System.out.println(loc+" is not suitable to build a house!");;
			}
		}else{
			System.out.println("Insufficient Funds!");
		}
	}

	public void build(String type, Location loc){
		// REQUIRES: ????
		// MODIFIES: 
		// EFFECTS:
		switch(type){
		case "House": buildHouse(loc);
		break;
		case "Hotel": buildHotel(loc);
		break;
		case "Skyscraper": buildSkyscraper(loc);
		break;
		}
	}





	//This method pays the rent of the specified location
		public void payRent(Location loc){
			decreaseBalance(loc.getRent());
			Game.players.get(loc.getLocationOwnerID()).increaseBalance(loc.getRent());
		}

		
	//This method return all properties that Player has
	public ArrayList<String> returnProperties(){
		return null;
	}


	public void printPlayerCreation()
	{
		// EFFECTS: Prints the created player information
		System.out.println("The player with ID:"+playerID+" is created with the color:"+playerColor.toString());
	}

	public void initializeDiceHistory (){
		// MODIFIES: playerDiceHistory
		// EFFECTS: Initializes the dice history of the player
		for (int i = 0; i <2; i++) {
			for (int j = 0; j < 1; j++) {
				playerDiceHistory[i][j] = 0;
			}

		} 
	}
	public void rollDice(){
		// MODIFIES: Game.firstDie
		//			 Game.secondDie
		//			 Game.speedDie
		// EFFECTS: Rolls the three dice and changes the related fields
		Game.firstDie.roll();
		Game.secondDie.roll();
		Game.speedDie.roll();	
		count++;
		//checkDouble(faceValue1,faceValue2);
	}

	public int getPlayerID() {
		// EFFECTS: Returns playerID
		return playerID;
	}

	public void setPlayerID(int playerID) {
		// MODIFIES: playerID
		// EFFECTS: Sets playerID
		this.playerID = playerID;
	}

	public Color getPlayerColor() {
		// EFFECTS: Returns playerColor
		return playerColor;
	}

	public void setPlayerColor(Color playerColor) {
		// MODIFIES: playerColor
		// EFFECTS: Sets playerColor
		this.playerColor = playerColor;
	}

	public int getPlayerBalance() {
		// EFFECTS: Returns playerBalance
		return playerBalance;
	}

	public void setPlayerBalance(int playerBalance) {
		// MODIFIES: playerBalance
		// EFFECTS: Sets playerBalance
		this.playerBalance = playerBalance;
	}

	public ArrayList<Location> getPlayerAssets() {
		// EFFECTS: Returns playerAssets
		return playerAssets;
	}

	public void setPlayerAssets(ArrayList<Location> playerAssets) {
		// MODIFIES: playerAssets
		// EFFECTS: Sets playerAssets
		this.playerAssets = playerAssets;
	}

	public int getPlayerPosition() {
		// EFFECTS: Returns playerPosition
		return playerPosition;
	}

	public void setPlayerPosition(int playerPosition) {
		// MODIFIES: playerPosition
		// EFFECTS: Sets playerPosition
		this.playerPosition = playerPosition;
	}

	public ArrayList<Card> getPlayerCardHolder() {
		// EFFECTS: Returns playerCardHolder
		return playerCardHolder;
	}

	public void setPlayerCardHolder(ArrayList<Card> playerCardHolder) {
		// MODIFIES: playerCardHolder
		// EFFECTS: Sets playerCardHolder
		this.playerCardHolder = playerCardHolder;
	}

	public int[][] getPlayerDiceHistory() {
		// EFFECTS: Returns playerDiceHistory
		return playerDiceHistory;
	}

	public void setPlayerDiceHistory(int[][] playerDiceHistory) {
		// MODIFIES: playerDiceHistory
		// EFFECTS: Sets playerDiceHistory
		this.playerDiceHistory = playerDiceHistory;
	}

	public void advanceToSquare(int position) {
		// MODIFIES: playerPosition
		// 			 square
		// EFFECTS: Changes the position of the player and related fields of square
		this.playerPosition=position%20;
		Square square=Game.monopolyBoard.getSquare(position);
		square.landedOn(this);
	}


	public void move() {

		rollDice();	

	}

}


