package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import domain.Game;
import domain.Location;
import domain.Player;

public class LocationTest {
	
	
	@Test
	public void testLandedOn() {
		
		Player testPlayer=Player.newInstance(0, Color.black);
		Player testPlayer1= Player.newInstance(1, Color.lightGray);
		Game.players.add(testPlayer);
		Game.players.add(testPlayer1);
		Location testLoc= new Location("Temeria", 2220, Color.DARK_GRAY, 5000 );
		testLoc.setLocationOwnerID(1);
		testLoc.landedOn(testPlayer);
		assertEquals(2200,testPlayer.getPlayerBalance());
		
		
	}

	@Test
	public void testLocation() {
		int test1=3;
		Location testLoc = new Location("Moon", 2, Color.CYAN, 1000);
		boolean testcolorGroups= Location.colorGroups.containsKey(Color.CYAN);
		assertEquals("keyTest",true, testcolorGroups);
		
		Location testLoc1 = new Location("Venus", 3, Color.CYAN, 600);
		Location testLoc2 = new Location("Uranus",4, Color.CYAN, 800);
		int testcolorGroups1= Location.colorGroups.get(Color.CYAN);
		assertEquals("colorGroupTest",test1, testcolorGroups1);
	}

	@Test
	public void testSetLocationOwnerID() {
		int test1 = 1;
		int test2 = 2; 
		Location testLoc = new Location("İzmir", 1, Color.BLUE, 250);
		testLoc.setLocationOwnerID(test1);
		assertEquals(test1, testLoc.getLocationOwnerID());
		testLoc.setLocationOwnerID(test2);
		assertEquals(test2, testLoc.getLocationOwnerID());
	}

}
