package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList.*;
import model.*;
/*
 * Visual representation of the high scores
 */ 

public class ScoreUI extends JPanel implements FrameUI
{
  JButton back = new JButton("back");
  JFrame frame;
  public Score s;

  public ScoreUI(){

    s = new Score();
    s.openAndRead();

    frame = new JFrame("Scoreboard");

    setPreferredSize(new Dimension(400,400));
    setLayout(null);
    setFrame(this);

    SwitchScreens switchingScreens = new SwitchScreens();
    back.setBounds(150,300,100,50);
    add(back);
    back.addActionListener(switchingScreens);
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
     

  @Override
  public void paintComponent(Graphics g){

    super.paintComponent(g);

    g.drawString("1st: " + s.getScores(0), 150, 25);
    g.drawString("2nd: " + s.getScores(1), 150, 75);
    g.drawString("3rd: " + s.getScores(2), 150, 125);
    g.drawString("4th: " + s.getScores(3), 150, 175);
    g.drawString("5th: " + s.getScores(4), 150, 225);
    g.drawString("These scores are caculated by measuring", 50, 250);
    g.drawString("how many cards are being played correctly per second", 30,270);

  }

  public class SwitchScreens implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {

      if (event.getSource() == back)
      {
        MenuUI menu = new MenuUI();
      }
    }
  }
  
}
