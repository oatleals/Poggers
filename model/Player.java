package model;
/*
 * Player Object
 */
public class Player
{
	// player name
	String pn;
	// player's  score
	float score;
	// player's hand
	Hand hand; 

	public Player(String name, Hand h)
	{
		this.pn = name;
		this.hand = h;
	}

	public Player(String name, float score, Hand h)
	{
		this.pn = name;
		this.score = score;
		this.hand = h;
	}

	public String getName()
	{
		return this.pn;
	}

	public float getScore()
	{
		return this.score;
	}

	public void calculateScore(float c, int t)
	{

		System.out.println("cards played handed was " + c);

		System.out.println("time handed was " + t);

		float temp = c/t;

		String numberAsString = String.format ("%.1f", temp);

		System.out.println(numberAsString);

		this.score = Float.valueOf(numberAsString);
	}

	public Hand getPlayerHand()
	{
		return this.hand;
	}

	public void listPlayersHand()
	{
		System.out.println(getName());
		for(int i = 0; i < this.hand.size(); i++)
		{
			System.out.println(this.hand.popBack().getCardName());
		}
	}

/*
 * Checks if the hand of the player is empty
 */
	public Boolean isEmpty()
	{
		if(this.hand.size() == 0)
		{
			return true;
		}

		else
		{
			return false;
		}
	}

}