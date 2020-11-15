package model;
public class Card
{
	/*
	 * this give the title of the card, ex: Queen of Hearts is represented as "QH"
	 * reason we need this is so we can upload 52 sepearate files of a card image 
	 */
	String name;

    /*
	 * name of the TYPE of card.
	 * QH is still just a queen ("Q")
	 */
	String type;
    /*
	 * name of the COLOR of card.
	 * QH means its Hearts and therefore RED
	 */
	String color;
    /*
	 * name of the SUIT of card.
	 */
	String suit;
	String source;

	public Card(String name, String s)
	{
		this.source = s;
		this.name = name;
		this.type = name.substring(0,1);
		this.suit = name.substring(1,2);
		if (name.substring(1,2).equals("H") || name.substring(1,2).equals("D"))
		{
			this.color = "Red";
		}

		else
		{
			this.color = "Black";
		}

	}

	public String getCardType()
	{
		return type;
	}

	public String getCardColor()
	{
		return color;
	}

		public String getCardSuit()
	{
		return suit;
	}

	public String getCardName()
	{
		return name;
	}

	public String getSource()
	{
		return source;
	}


}