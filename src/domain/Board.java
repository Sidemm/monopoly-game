package domain;

import java.awt.*;
import java.util.HashMap;

public class Board {
	
	//OVERVÝEW: Board class initializes the squares with their creation classes, 
	// 			adds initiliazed squares to a sqaure list. It also keeps square tracks
	//			with their names in a hashmap.
	//			It has methods for finding squares to get the information about related sqaure 
	//			and drawing cards.

	// To be initialized
	static Square[] squareList=new Square[20];
	HashMap<String, Integer> trackInfo = new HashMap<String, Integer>();
	
	
	//Sets track borders
	
	public Board() {
		
		//MODIFIES:squareList, static array of square objects
		//			trackInfo, hashmap of square names with their position on board 
		//EFFECTS:Updates squareList by adding all square objects to square array,
		//			updates the trackInfo by mapping square name and its position on board
		
	//Temporary squares to prevent null pointer exception
		
		squareList[0]=new PayCornerSquare();
		squareList[2]=new ChanceSquare();
		squareList[5]=new PayCornerSquare();
		squareList[7]=new ChanceSquare();
		squareList[10]=new PayCornerSquare();
		squareList[12]=new ChanceSquare();
		squareList[15]=new PayCornerSquare();
		squareList[18]=new ChanceSquare();


		Location p1=new Location("Oriental Avenue",1,Color.MAGENTA,100); 
		trackInfo.put("Oriental Avenue", 1);
		squareList[1]=p1;
		
		Location p2=new Location("Vermont Avenue",3,Color.MAGENTA,100);
		trackInfo.put("Vermont Avenue", 3);
		squareList[3]=p2;

		Location p3=new Location("Connecticut Avenue",4,Color.MAGENTA,120); 
		trackInfo.put("Connecticut Avenue", 4);
		squareList[4]=p3;


		Location p4=new Location("St. Charles Place",6,Color.PINK,140); 
		trackInfo.put("St. Charles Place", 6);
		squareList[6]=p4;


		Location p5=new Location("States Avenue",8,Color.PINK,140); 
		trackInfo.put("States Avenue", 8);
		squareList[8]=p5;


		Location p6=new Location("Virginia Avenue",9,Color.PINK,160); 
		trackInfo.put("Virginia Avenue", 9);
		squareList[9]=p6;


		Location p7=new Location("St. James Place",11,Color.ORANGE,180); 
		trackInfo.put("St. James Place", 11);
		squareList[11]=p7;


		Location p8=new Location("Tenessee Avenue",13,Color.ORANGE,180); 
		trackInfo.put("Tenessee Avenue", 13);
		squareList[13]=p8;


		Location p9=new Location("New York Avenue",14,Color.ORANGE,200);
		trackInfo.put("New York Avenue", 14);
		squareList[14]=p9;


		Location p10=new Location("Pacific Avenue",16,Color.GREEN,300);
		trackInfo.put("Pacific Avenue", 16);
		squareList[16]=p10;


		Location p11=new Location("North Carolina Avenue",17,Color.GREEN,300);
		trackInfo.put("North Carolina Avenue", 17);
		squareList[17]=p11;


		Location p12=new Location("Pennsylvania Avenue",19,Color.GREEN,320);
		trackInfo.put("Pennsylvania Avenue", 19);
		squareList[19]=p12;


	}


	// This method finds the position of a square with its name
	public static int findSquare(String sqName){
		
		//REQUIRES: s is in the squareList
		//MODIFIES: i,the position of a square as integer
		//EFFECTS: If square name is equal to searched square name
		//			it returns the position of square otherwise returns 0
		//			a message that says searched sqaure does not exist.
		
		int i=0;
		
		for(Square s : squareList){
			if(s.squareName == sqName){
				return i;
			}
			i++;
		}
		System.out.println("No square named "+sqName+" exists!");
		return 0;
	}
	
	
	public HashMap<String, Integer> getTrackInfo() {
		//EFFECTS: returns trackInfo
		return trackInfo;
	}


	public Square getSquare(int position){
		//EFFECTS: returns the square for given position 
		return squareList[position];
	}
	
	public static Card drawCard(String type) {
		// TODO Auto-generated method stub
		return null;
	}
}
