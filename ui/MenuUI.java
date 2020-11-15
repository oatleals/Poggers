package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
/*
 * Main Menu is displayed for the user
 */
public class MenuUI extends JPanel implements FrameUI
{
    public JButton play = new JButton("PLAY");
    private JButton sb = new JButton("SCORE BOARD");
    private JButton htp = new JButton("HOW TO PLAY");
    private JButton quit = new JButton("QUIT");

    public MenuUI()
    {
        frame.setTitle("Main Menu");

        setPreferredSize(new Dimension(500,500));
        setLayout(null);
        SwitchScreens switchingScreen = new SwitchScreens();


        play.setBounds(225,20,50,50);
        add(play);
        play.addActionListener(switchingScreen);


        sb.setBounds(200,100,100,50);
        add(sb);
        sb.addActionListener(switchingScreen);


        htp.setBounds(200,180,100,50);
        add(htp);
        htp.addActionListener(switchingScreen);

        quit.setBounds(225,260,50,50);
        add(quit);
        quit.addActionListener(switchingScreen);

        setFrame(this);

}

    public static void setFrame(JComponent ui)
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(800,800));
        frame.add(ui);
        frame.pack();
        frame.setVisible(true);
    }

     
/*
 * Listeners for switching framees
 */
    public class SwitchScreens implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            System.out.println("button was clicked");

            if (event.getSource() == play)
            {
                System.out.println("play was clicked");
                frame.setVisible(false);
                ModeUI chooseMode = new ModeUI();
            }
            else if (event.getSource() == sb)
            {
               System.out.println("scoreboard was clicked"); 
               frame.setVisible(false);
               ScoreUI sb = new ScoreUI();
            }
            else if (event.getSource() == htp)
            {
                HTP h = new HTP();
                System.out.println("how to play was clicked"); 
            }

            else if (event.getSource() == quit)
            {
               System.out.println("quit was clicked");
               System.exit(1);
            }
        }
    }
}
