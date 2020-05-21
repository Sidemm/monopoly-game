package domain;

public class Die {
	
	//OVERVIEW: Die class keeps the face values of dice
	//			has roll method for player to return face
	//			values of die. It also has get method for
	//			the face value of die.
	
	int dieFaceValue;
	
	
	
	public int getDieFaceValue() {
		//EFFECTS: returns face value of die
		return dieFaceValue;
	}

	public int roll()
	{
		//MODIFIES: dieFaceValue, face value of die as integer
		//EFFECTS: returns the face value of die by choosing randomly
		//			between 1 and 6.
    dieFaceValue=(int )(Math.random() * 6 + 1);
    
    return dieFaceValue;
	}

}


