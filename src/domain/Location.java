package domain;

import java.awt.Color;
import java.util.HashMap;

import controller.GameViewController;

public class Location extends Square{
    //OVERVIEW: this class implements location subclass of squares which represents estates 
    //of different regions like New York, Pacific Avenue, St. James Place etc. 
    //Locations have different colors and prices according to value of the region and it has 
    //a method that leads to a purchase or rent based according to owner condition. 
    
    /* When the location bought the ownerID will be the ID that player holds this location*/
    int hotelCost;
    int houseCost;
    int skyscraperCost;
    int locationOwnerID=-1;
    /* The location will have their assets
     * Which will be represented with Hashmap
     * For example if there are 3 apartments and 2 hotels
     * A hashmap will be constructed as "Apartment" --> 3 , "Hotel" --> 2
     */
    public HashMap<String, Integer> locationAssets;
    /*Every location has its own color*/
    Color locationColor;
    public static HashMap<Color, Integer> colorGroups = new HashMap<Color, Integer>();
    /*Every location has its own price and rent value*/
    int locationPrice;
    int rent;
    
    //constructors
    public Location(String name, int position, Color locationColor, int locationPrice) {
        //EFFECTS: initializes this to have name, position, locationColor and locationPrice.
        super();
        this.squareName=name;
        this.position = position;
        this.locationColor = locationColor;
        this.locationPrice = locationPrice;
        this.rent =locationPrice/5;
        locationAssets = new HashMap<String, Integer>();
        this.houseCost = 50;
        this.hotelCost = 250;
        this.skyscraperCost = 300;
        if(colorGroups.containsKey(locationColor)){
            colorGroups.put(locationColor, colorGroups.get(locationColor)+1);
        }else{
            colorGroups.put(locationColor, 1);
        }

    }


    
    //methods
    @Override
    public void landedOn(Player player) {
        //REQUIRES:player.position is equal to this location.
        //MODIFIES: player, bank, this.
        //EFFECTS: if this doesn't have an owner it leads player to a purchase decision. 
        //otherwise player pays rent amount of this.price to the owner.
        if(this.locationOwnerID==-1) {
          if(player.getPlayerBalance()>=this.locationPrice) {
              System.out.println("landedon");
            GameViewController.advancetoUnownedLoc(this);
          }
          }
        else
            player.payRent(this);    
    }

    public void updateRent() {
        //EFFECTS:changes rent of this to newRent.
        // TODO Auto-generated method stub
        
    }
    
    public void setLocationOwnerID(int locationOwnerID) {
        //EFFECTS:sets the owner of this as locationOwnerID.
        this.locationOwnerID = locationOwnerID;
    }
    
    public int getLocationOwnerID() {
        //EFFECTS:returns locationOwnerID of this.
        return locationOwnerID;
    }
    
    public int getLocationPrice() {
        //EFFECTS:returns locationPrice of this.
        return locationPrice;
    }
    
    public int getRent() {
        //REQUIRES: this.owner is not -1. 
        //EFFECTS: returns the rent value of this.
        return rent;
    }
    
    public String getName() {
        //EFFECTS: returns name of this.
        return this.squareName;
    }


}
