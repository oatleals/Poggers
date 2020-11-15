package model;
/*
 * An extension of the mode abstract class.
 * Specifies mode to be focused on matching SUITS of cards
 */
public class SuitMode extends Mode
{

  public SuitMode(Player p)
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
      System.out.println(middleCard.getCardSuit() + " " + getPrevMiddleCard().getCardSuit());
        if(middleCard.getCardSuit().equals(getPrevMiddleCard().getCardSuit())) 
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
      System.out.println(getPrevMiddleCard().getCardSuit() + " " + getSideCard().getCardSuit());
    
        if(getPrevMiddleCard().getCardSuit().equals(getSideCard().getCardSuit())) 
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





