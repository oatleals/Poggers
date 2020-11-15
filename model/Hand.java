package model;
import java.util.Queue;
import java.util.LinkedList;
/*
 * The deck of card in the user's hand that is updated throughout the game
 */
public class Hand extends Deck
{
	Queue<Card> hand = new LinkedList<Card>();

	public Hand(Queue<Card> h)
	{
		this.hand = h;

	}

	public void addCard(Card c)
	{
		this.hand.add(c);
	}

	public Card peek()
	{
		return this.hand.peek();
	}

	public Card remove()
	{
		return this.hand.remove();
	}

/*
 * This method allows for printing and checking every single Card in the hand
 * without losing its place (since it is a queue).
 */
	public Card popBack()
	{
		Card temp;
		temp = this.hand.remove();
		this.hand.add(temp);
		return temp;
		
	}

	public int size()
	{
		return hand.size();
	}

}