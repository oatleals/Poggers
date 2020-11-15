package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
/*
 * Displays everything that involves the play through of the game
 */
public class BoardUI extends JLayeredPane implements FrameUI
{

  private String mode;

  static PoggersModel.MenuSubscriber sub;
  public static JButton sm = new JButton("Stack on Middle");
  public static JButton ss = new JButton("Stack on Side");
  static JFrame frame;

  JButton start = new JButton("start");
  JButton back = new JButton("<– Main Menu");

  JLabel timerLabel;
  CardUI handDown;
  CardUI handUp;
  CardUI middle;

  PoggersTimer timeDisplayed;


  public BoardUI(PoggersModel.MenuSubscriber s){

    sub = s;
    setPreferredSize(new Dimension(800,750));
    setLayout(null);

    if (sub == PoggersModel.MenuSubscriber.TYPE)
    {
      mode = "Type Mode";
    }
    else if (sub == PoggersModel.MenuSubscriber.COLOR)
    {
      mode = "Color Mode";
    }

    else
    {
      mode = "Suit Mode";
    }

    frame = new JFrame(mode);

    SwitchScreens switchingScreens = new SwitchScreens();
    Stacking stacking = new Stacking();
    
    back.setBounds(10,10,100,50);
    back.setMinimumSize(new Dimension(100,50));
    add(back,JLayeredPane.DEFAULT_LAYER);
    back.addActionListener(switchingScreens);

    sm.setBounds(260,600,120,50);
    sm.setMinimumSize(new Dimension(100,50));
    add(sm,JLayeredPane.DEFAULT_LAYER);
    sm.addActionListener(stacking);
    sm.setEnabled(false);

    ss.setBounds(390,600,120,50);
    ss.setMinimumSize(new Dimension(100,50));
    add(ss,JLayeredPane.DEFAULT_LAYER);
    ss.addActionListener(stacking);
    ss.setEnabled(false);

    start.setBounds(300,10,100,50);
    start.setMinimumSize(new Dimension(100,50));
    add(start,JLayeredPane.DEFAULT_LAYER);
    start.addActionListener(switchingScreens);


    Card MIDDLE = new Card("KH","src/red_back.png");
    middle = new CardUI(MIDDLE);
    middle.setBounds(300,200,200,306);
    add(middle,JLayeredPane.DEFAULT_LAYER);    
    

    Card BACK = new Card("BACK","src/red_back.png");
    CardUI handDown = new CardUI(BACK);
    handDown.setBounds(10,375,200,306);
    add(handDown,JLayeredPane.DEFAULT_LAYER);


    handUp = new CardUI();
    handUp.setBounds(30,400,200,306);
    add(handUp,JLayeredPane.DEFAULT_LAYER);


    ModeUI.playGame.time.setBounds(600,10,100,50);
    add(ModeUI.playGame.time,JLayeredPane.DEFAULT_LAYER);

    setFrame(this);

  }

  public void setFrame(JComponent ui)
  {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setSize(new Dimension(800,800));
    frame.add(ui);
    frame.pack();
    frame.setVisible(true);
  } 

/*
 * Listeners for when the user clicks on a button
 */     
  public class SwitchScreens implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      System.out.println("button was clicked");

      if (event.getSource() == back)
      {
        System.out.println("BACK TO MAIN MENU"); 
        frame.setVisible(false);
        MenuUI mainMenu = new MenuUI();
      }

      else if (event.getSource() == start)
      {
        ModeUI.playGame.time.timer.start();
        sm.setEnabled(true);
        ss.setEnabled(true);
        start.setEnabled(false);

        handUp.changeCard(ModeUI.playGame.game.user.getPlayerHand().peek());
        handUp.repaint();
        middle.changeCard(ModeUI.playGame.game.gameMode.getMiddleCard());
        System.out.println("OH MY GOD" + middle.getSource());
        middle.repaint();

      }
    }
  }

/*
 * Listeners for when user makes a move
 */
  public class Stacking implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      System.out.println("colors should change");

      if (event.getSource() == sm)
      {
        middle.changeCard(ModeUI.playGame.game.user.getPlayerHand().peek());
        middle.repaint();

        ModeUI.playGame.playMode(PoggersModel.MoveSubscriber.STACKTOMID);

        handUp.changeCard(ModeUI.playGame.game.user.getPlayerHand().peek());
        handUp.repaint();

        System.out.println("hand becomes middle, and handUp is updated");
        System.out.println(ModeUI.playGame.time.getTimeStamp());

      }

      else if (event.getSource() == ss)
      {

        System.out.println("repainting... colors should change to green");


        ModeUI.playGame.playMode(PoggersModel.MoveSubscriber.STACKTOSIDE);

        middle.changeCard(ModeUI.playGame.game.gameMode.getSideCard());
        middle.repaint();

        handUp.changeCard(ModeUI.playGame.game.user.getPlayerHand().peek());
        handUp.repaint();

      }
    }
  }

}





