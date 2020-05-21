package domain;

public class Bank {
	//OVERVÝEW: This class has the total amount of money in monopoly game.
	//It provides two methods that updates money in the bank.
	public static int totalMoney = 20000;
	
	public static void decreaseTotalMoney(int amount)
	{
		//MODIFIES:totalMoney, total amount of money
		//EFFECTS: Decrements total money as amount
		totalMoney -= amount;
	}
	
	public static void increaseTotalMoney(int amount)
	{
		//MODIFIES:totalMoney, total amount of money
		//EFFECTS: Increments total money as amount
		totalMoney += amount;
	}

}
