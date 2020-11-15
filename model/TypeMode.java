package model;
/*
 * An extension of the mode abstract class.
 * Specifies mode to be focused on matching TYPES of cards
 */
public class TypeMode extends Mode
{

  public TypeMode(Player p)
  {
    super(p);
  }

/*
 * Checks to see if the user move choice was CORRECT OR NOT
 */
  public Boolean rightSpot(PoggersModel.MoveSubscriber userChoice)
  {
    if (userChoice == PoggersModel.MoveSubscriber.STACKTOMID)
    {
      System.out.println(middleCard.getCardName() + " " + getPrevMiddleCard().getCardName());
      System.out.println(middleCard.getCardType() + " " + getPrevMiddleCard().getCardType());
        if(middleCard.getCardType().equals(getPrevMiddleCard().getCardType())) 
        {
          System.out.println("cards match... this is a burn");
          this.decision = false;
        }

        else
        {
          System.out.println("cards dont match, u gucci");
          this.decision = true;
        }
    }

    else if(userChoice == PoggersModel.MoveSubscriber.STACKTOSIDE)
    {
      System.out.println(getPrevMiddleCard().getCardName() + " " + getSideCard().getCardName());
      System.out.println(getPrevMiddleCard().getCardType() + " " + getSideCard().getCardType());
    
        if(getPrevMiddleCard().getCardType().equals(getSideCard().getCardType())) 
        {
          System.out.println("yay, u sided correctly");
          this.addToHand();
          this.decision = true;
        }

        else
        {
          System.out.println("bruh u too paranoid. think before u play");
          this.decision = false;
        }
    }
    return this.decision;
  }	
	
}
