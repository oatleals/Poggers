package model;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.lang.*;
import java.util.Scanner;
/*
 * This class combines everything in the model
 * This allows for functionalities all across the package to be used and shared
 */

public class PoggersModel
{
	protected MenuSubscriber sub;
	public MoveSubscriber mvSub;
	public Player user;
	public Mode gameMode;


	public PoggersModel(MenuSubscriber s)
	{
		this.sub = s;
	}

	public PoggersModel()
	{}


	public void addPlayersToGame(Player p)
	{
		this.user = p;

	}
/*
 * Enums that represent Mode 
 */
	public enum MenuSubscriber
	{
		TYPE,COLOR,SUIT
	}
/*
 * Enum's that represent user move
 */
	public enum MoveSubscriber
	{
		STACKTOMID,STACKTOSIDE
	}

	public void setMenuSubsriber(MenuSubscriber s)
	{
		this.sub = s;
	}

	public MenuSubscriber getMenuSubscriber()
	{
		return this.sub;
	}

	public void showBoard()
	{
		System.out.println("currently, your middle card is " + this.gameMode.getMiddleCard().getCardName());
		System.out.println("and in your hand is a " + this.user.hand.peek().getCardName());
	}

/*
 * This method sets up the game by creating all the needed objects and placing them where they need to be
 */
	public Mode setUpGameMode()
	{
		Deck poggersDeck = new Deck();
		poggersDeck.randomize();
		poggersDeck.convertToQueue();
		poggersDeck.shuffleForUser();
		this.user = new Player("user", poggersDeck.getUserHand());

		if (sub == MenuSubscriber.TYPE)
		{	
			this.gameMode = new TypeMode(this.user);
			System.out.println("You selected type mode");

		}

		else if (sub == MenuSubscriber.COLOR)
		{
			this.gameMode = new ColorMode(this.user);
			System.out.println("you selected color mode");

		}

		else if (sub == MenuSubscriber.SUIT)
		{
			this.gameMode = new SuitMode(this.user);
			System.out.println("you selected suit mode");
		}


		this.user.listPlayersHand();
		showBoard();
		return this.gameMode;

	}

}