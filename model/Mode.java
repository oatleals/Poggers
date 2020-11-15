package model;
import java.util.ArrayList;
/*
 * Abstact class for game mode (there are 3)
 */
public abstract class Mode
{

  public ArrayList<Card> middle = new ArrayList<Card>();
  public Card middleCard;
  public Card prevMiddleCard;
  public Card sideCard;
  public ArrayList<Card> side = new ArrayList<Card>();
  public Card userCurrent;
  public Player p;
  Boolean decision;


  public Mode(Player p)
  {
    this.p = p;
    middle.add(this.p.hand.remove());
    setMiddleCard();
  }

/*
 * When implemented, this method will return wether or not the user made the correct choice when moving
 */
 public abstract Boolean rightSpot(PoggersModel.MoveSubscriber userChoice);

  public Player getPlayer()
  {
    return this.p;
  }

  public void setUserCurrent()
  {
    this.userCurrent = this.p.hand.peek();
  }

  public Card getUserCurrent()
  {
   // this.setUserCurrent();
    return this.userCurrent;

  }

  public void setMiddleCard()
  {
    this.middleCard = middle.get(middle.size()-1);
  }

  public void setPrevMiddleCard()
  {
    this.prevMiddleCard = middle.get(middle.size()-2);
  }

  public Card getMiddleCard()
  {
    return this.middleCard;
  }

  public Card getPrevMiddleCard()
  {
    setPrevMiddleCard();
    return this.prevMiddleCard;
  }
  
  public  void stackOnMiddle(Card c)
  {
      
      this.middle.add(c); 
      this.middleCard = c;   
  }


  
  public  void stackOnSide(Card c)
  {
      this.side.add(c);
      this.sideCard = c;
      this.stackOnMiddle(c);
  }

  public Card getSideCard()
  {
    return sideCard;
  }

/* When the user stacks to the card correctly, 
 * all the cards in the middle return to the hand
 */
 public void addToHand()
  {
    for (int i = 0; i < this.middle.size()-1; i++)
    {
      this.p.getPlayerHand().addCard(this.middle.get(i));
    }
  }

/*
 * This method moves cards according to the user's choice
 * it also updates the current positions of all the cards being played at the time.
 */
  public void move(PoggersModel.MoveSubscriber s, Player player)
  {
    String name = player.getName();

    if (s == PoggersModel.MoveSubscriber.STACKTOMID)
    {
      Card tempMid = this.middleCard;
      Card tempCurrent = player.hand.peek();
      this.stackOnMiddle(player.hand.remove());
    }

    else if( s == PoggersModel.MoveSubscriber.STACKTOSIDE)
    {
      Card tempMid = this.middleCard;
      Card tempCurrent = player.hand.peek();
      this.stackOnSide(player.hand.remove());
    }

  }
  
 }  

