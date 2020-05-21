package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import domain.Bank;
import domain.Game;
import domain.Location;
import domain.Player;
import domain.TransitStation;
import domain.UtilitySquare;

public class PlayerTest {

	@Test
	public void testBuyProperty() {
		
		Player testPlayer=Player.newInstance(0, Color.black);
		Location testLoc= new Location("Cyseal", 210, Color.green, 1000 );
		testPlayer.buyProperty(testLoc);
		assertEquals(2200, testPlayer.getPlayerBalance());
		assertEquals(Bank.totalMoney,21000);
		assertEquals(testLoc.getLocationOwnerID(),0);
		Bank.totalMoney=20000;

	}

	@Test
	public void testBuyUtility() {
	
		Player testPlayer=Player.newInstance(0, Color.black);
		UtilitySquare testUtility = new UtilitySquare("Water Works", 10, 150);
		testPlayer.buyUtility(testUtility);
		
		assertEquals(3050, testPlayer.getPlayerBalance());
		assertEquals(Bank.totalMoney,20150);
		Bank.totalMoney=20000;


	}
	
	@Test
	public void testBuyRailRoad() {
	
		Player testPlayer=Player.newInstance(0, Color.black);
		TransitStation testRailroad = new TransitStation("Reading Railroad", 5, 200);
		testPlayer.buyRailroad(testRailroad);
		
		assertEquals(3000, testPlayer.getPlayerBalance());
		assertEquals(Bank.totalMoney,20200);
		Bank.totalMoney=20000;


	}
}
