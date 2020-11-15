package control;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
import ui.*;
/*
 * Game Controller
 */
public class PlayPoggers
{
	public PoggersModel.MenuSubscriber sub;
	public Boolean startGame;
	public static PoggersModel game;
	public static String moveChosen;
	public static float cardsPlayed;
	public static BoardUI board; 
	public static float highscore;
	public static PoggersTimer time = new PoggersTimer();

	public PlayPoggers(PoggersModel.MenuSubscriber s)
	{
		sub = s;
		board = new BoardUI(sub);
		game = new PoggersModel(sub);
		Mode mode = game.setUpGameMode();
		System.out.println(game.user.getPlayerHand().peek().getCardName());
	}

/*
 * This method is called when the user makes a wrong move
 * It calculates score, decides if its a high or not
 * Essentially, it's game over
 */
	public void burn()
	{
		game.user.calculateScore(cardsPlayed,time.getTimeStamp());
		Score s = new Score(game.user.getScore());
		s.openAndRead();
		System.out.println("WRONG MOVEGAME OVER");
		board.sm.setEnabled(false);
		board.ss.setEnabled(false);
		time.timer.stop();
    	GameOverUI go = new GameOverUI();
    	go.setBounds(150,50,500,300);
    	board.add(go,JLayeredPane.POPUP_LAYER);
    	System.out.println(game.user.getScore());
	}

	public void setMenuSubsriber(PoggersModel.MenuSubscriber s)
	{
		this.sub = s;
	}

/*
 * This method combines all the different playing judges and listeners
 * Calls all the methods that need to be called in order to play
 */
	public Boolean playMode(PoggersModel.MoveSubscriber moveMade)
	{
		Boolean rightMove = true;
		if (game.user.isEmpty() == true)
		{
			System.out.println("You ran out cards, congrats, you win by default!");
		}

		if (rightMove == false)
		{
			System.out.println("you made a wrong move, game should quit");

		}

			String moveString;
			if (moveMade == PoggersModel.MoveSubscriber.STACKTOSIDE)
			{
				System.out.println("Your move was to stack onto the side");
			}
			else
			{
				System.out.println("Your move was to stack onto the middle");
			}

			if (moveMade == PoggersModel.MoveSubscriber.STACKTOMID)
			{
				game.gameMode.move(moveMade, game.user);
				rightMove = game.gameMode.rightSpot(moveMade);
				System.out.println("rightMove is equal to " + rightMove);

			}

			else if (moveMade == PoggersModel.MoveSubscriber.STACKTOSIDE)
			{
				game.gameMode.move(moveMade, game.user);
				rightMove = game.gameMode.rightSpot(moveMade);
				System.out.println("rightMove is equal to " + rightMove);
			}

			if (rightMove == true)
			{
				System.out.println("you did the correct move");
				cardsPlayed++;
			}

			else
			{
				burn();
			}

		game.showBoard();
		return false;

	}
		
}