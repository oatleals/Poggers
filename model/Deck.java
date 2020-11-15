package model;
import java.util.Random;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
/*
 * A Deck object is created by combining Card objects into a list
 */
public class Deck
{

  public ArrayList<Card> deck = new ArrayList<Card>();
  public Queue<Card> queueDeck = new LinkedList<Card>();
  public Hand userHand;

  public Deck()
  {

    Card KH = new Card("KH","src/KH.png");
    this.deck.add(KH);
    Card KD = new Card("KD","src/KD.png");
    this.deck.add(KD);
    Card KC = new Card("KC","src/KC.png");
    this.deck.add(KC);
    Card KS = new Card("KS","src/KS.png");
    this.deck.add(KS);

    Card QH = new Card("QH","src/QH.png");
    this.deck.add(QH);
    Card QD = new Card("QD","src/QD.png");
    this.deck.add(QH);
    Card QC = new Card("QC","src/QC.png");
    this.deck.add(QH);
    Card QS = new Card("QS","src/QS.png");
    this.deck.add(QS);

    Card JH = new Card("JH","src/JH.png");
    this.deck.add(JH);
    Card JD = new Card("JD","src/JD.png");
    this.deck.add(JD);
    Card JC = new Card("JC","src/JC.png");
    this.deck.add(JC);
    Card JS = new Card("JS","src/JS.png");
    this.deck.add(JS);

  	Card AH = new Card("AH","src/AH.png");
    this.deck.add(AH);
    Card AD = new Card("AD","src/AD.png");
    this.deck.add(AD);
    Card AC = new Card("AC","src/AC.png");
    this.deck.add(AC);
    Card AS = new Card("AS","src/AS.png");
    this.deck.add(AS);

    Card H2 = new Card("2H","src/2H.png");
    this.deck.add(H2);
    Card D2 = new Card("2D","src/2D.png");
    this.deck.add(D2);
    Card C2 = new Card("2C","src/2C.png");
    this.deck.add(C2);
    Card S2 = new Card("2S","src/2S.png");
    this.deck.add(S2);

    Card H3 = new Card("3H","src/3H.png");
    this.deck.add(H3);
    Card D3 = new Card("3D","src/3D.png");
    this.deck.add(D3);
    Card C3 = new Card("3C","src/3C.png");
    this.deck.add(C3);
    Card S3 = new Card("3S","src/3S.png");
    this.deck.add(S3);

    Card H4 = new Card("4H","src/4H.png");
    this.deck.add(H4);
    Card D4 = new Card("4D","src/4D.png");
    this.deck.add(D4);
    Card C4 = new Card("4C","src/4C.png");
    this.deck.add(C4);
    Card S4 = new Card("4S","src/4S.png");
    this.deck.add(S4);

    Card H5 = new Card("5H","src/5H.png");
    this.deck.add(H5);
    Card D5 = new Card("5D","src/5D.png");
    this.deck.add(D5);
    Card C5 = new Card("5C","src/5C.png");
    this.deck.add(C5);
    Card S5 = new Card("5S","src/5S.png");
    this.deck.add(S5);

    Card H6 = new Card("6H","src/6H.png");
    this.deck.add(H6);
    Card D6 = new Card("6D","src/6D.png");
    this.deck.add(D6);
    Card C6 = new Card("6C","src/6C.png");
    this.deck.add(C6);
    Card S6 = new Card("6S","src/6S.png");
    this.deck.add(S6);

    Card H7 = new Card("7H","src/7H.png");
    this.deck.add(H7);
    Card D7 = new Card("7D","src/7D.png");
    this.deck.add(D7);
    Card C7 = new Card("7C","src/7C.png");
    this.deck.add(C7);
    Card S7 = new Card("7S","src/7S.png");
    this.deck.add(S7);

    Card H8 = new Card("8H","src/8H.png");
    this.deck.add(H8);
    Card D8 = new Card("8D","src/8D.png");
    this.deck.add(H8);
    Card C8 = new Card("8C","src/8C.png");
    this.deck.add(C8);
    Card S8 = new Card("8S","src/8S.png");
    this.deck.add(S8);

    Card H9 = new Card("9H","src/9H.png");
    this.deck.add(H9);
    Card D9 = new Card("9D","src/9D.png");
    this.deck.add(D9);
    Card C9 = new Card("9C","src/9C.png");
    this.deck.add(C9);
    Card S9 = new Card("9S","src/9S.png");
    this.deck.add(S9);

    Card H0 = new Card("0H","src/0H.png");
    this.deck.add(H0);
    Card D0 = new Card("0D","src/0D.png");
    this.deck.add(D0);
    Card C0 = new Card("0C","src/0C.png");
    this.deck.add(C0);
    Card S0 = new Card("0S","src/0S.png");
    this.deck.add(S0);
  }



  public void randomize()
  {

    ArrayList<Card> tempDeck =  new ArrayList<Card>();
    Random rand = new Random();

    int count = 0;
    while(count <= 51)
    {

      int randCard = rand.nextInt(this.deck.size());
      tempDeck.add(this.deck.get(randCard));
      this.deck.remove(randCard);
      count++;
    }

    this.deck = tempDeck;
    System.out.println("randomized");
  }

  public void convertToQueue()
  {
  	Queue<Card> qDeck = new LinkedList<Card>();
    for (int i=0; i < this.deck.size(); i++)
    {
        qDeck.add(this.deck.get(i));
    }

    System.out.println("The head of the queue is " + qDeck.peek().getCardName());
  	this.queueDeck = qDeck;
  }

/*
 * Creates a queue that's ready for a Hand object to use
 */
  public void shuffleForUser()
  {
    Queue<Card> temp1 = new LinkedList<Card>();

    for(int i = 0; i < 52; i++){
        temp1.add(this.queueDeck.remove());
    }
    this.userHand = new Hand(temp1);
  }

  public Hand getUserHand()
  {
    return userHand;
  }

  public Queue<Card> getQueueDeck()
  {
    return queueDeck;
  }

}
