package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
import control.*;
/*
 * This UI allows for user to choose what type of mode they want to play
 */
public class ModeUI extends JPanel
{
    public JButton type = new JButton("CARD TYPE MODE");
    public JButton color = new JButton("CARD COLOR MODE");
    public JButton suit = new JButton("CARD SUIT MODE");
    private JButton back = new JButton("Back to Menu");
    public JFrame frame;
    public PoggersModel.MenuSubscriber sub;
    public static PlayPoggers playGame;
    public static Boolean gameOver;

  public ModeUI() 
  {


    setPreferredSize(new Dimension(500,500));
    setLayout(null);
    SwitchScreens switchingScreens = new SwitchScreens();
    frame = new JFrame("Choose Your Mode");

    type.setBounds(175,20,150,50);
    add(type);
    type.addActionListener(switchingScreens);


    color.setBounds(175,100,150,50);
    add(color);
    color.addActionListener(switchingScreens);

    suit.setBounds(175,180,150,50);
    add(suit);
    suit.addActionListener(switchingScreens);

    back.setBounds(200,260,100,50);
    add(back);
    back.addActionListener(switchingScreens);

    setFrame(this);
  }

  public void setFrame(JComponent ui)
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(500,500));
        frame.add(ui);
        frame.pack();
        frame.setVisible(true);
    } 
     

  public class SwitchScreens implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
        System.out.println("button was clicked");

        if (event.getSource() == type)
        {
           System.out.println("CARD TYPE MODE");
           frame.setVisible(false);
           playGame = new PlayPoggers(PoggersModel.MenuSubscriber.TYPE);
        }

        else if (event.getSource() == color)
        {
           System.out.println("CARD COLOR MODE"); 
           frame.setVisible(false);
           playGame = new PlayPoggers(PoggersModel.MenuSubscriber.COLOR);
        }
        else if (event.getSource() == suit)
        {
           System.out.println("CARD SUIT MODE");
           frame.setVisible(false);
           playGame = new PlayPoggers(PoggersModel.MenuSubscriber.SUIT);           
        }

        else if (event.getSource() == back)
        {
           System.out.println("BACK TO MAIN MENU"); 
           frame.setVisible(false);
           MenuUI mainMenu = new MenuUI();

        }
    }
  }
}
