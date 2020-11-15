package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOverUI extends JComponent
{
	JButton quit = new JButton("Quit");
	JButton playAgain = new JButton("Play Again");

	public GameOverUI()
	{
		gameOverEvent goe = new gameOverEvent();

		quit.setBounds(70,200,100,50);
		quit.addActionListener(goe);
		add(quit);

		playAgain.setBounds(320,200,100,50);
		playAgain.addActionListener(goe);
		add(playAgain);


	}

    public class gameOverEvent implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == playAgain)
            {
            	BoardUI.frame.setVisible(false);
            	MenuUI newMain = new MenuUI();
            }

            else if (event.getSource() == quit)
            {
               System.out.println("quit was clicked");
               System.exit(1);
            }
        }
    }


	@Override
  	protected void paintComponent(Graphics g)
  	{
  		super.paintComponent(g);
  		g.setColor(Color.PINK);
  		g.fillRoundRect(0,0,500,300,30,30);

  		g.setColor(Color.BLACK);
  		Font f = new Font("Arial Bold", Font.BOLD,70);
  		g.setFont(f);
  		g.drawString("GAME OVER",40,150);

  	}


}


