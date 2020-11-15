package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * Directions for how to play
 */
public class HTP extends JPanel implements FrameUI
{
    JFrame frame;
    JButton back = new JButton("back");

    public HTP()
    {
        frame = new JFrame("Scoreboard");

        setPreferredSize(new Dimension(800,500));
        setLayout(null);
        setFrame(this);

        SwitchScreens switchingScreens = new SwitchScreens();
        back.setBounds(10,425,100,50);
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

    @Override
    public void paintComponent(Graphics g){

    super.paintComponent(g);

    g.drawString("1. Choose a mode ('TYPE', 'COLOR', 'SUIT'). ", 10, 25);
    g.drawString("2. You will get two move options when the game starts: Stack to Midde/Stack to Side ", 10, 50);
    g.drawString("3. The goal is to avoid stacking the cards with the same characteristics, depending on what mode you chose.", 10, 75);
    g.drawString("FOR EXAMPLE: if COLOR mode was chosen, avoid stacking to the middle cards of the same color on top of each other.", 10, 100);
    g.drawString("                I.E. RED ON RED or BLACK ON BLACK.", 10, 125);
    g.drawString("FOR EXAMPLE: if TYPE mode was chosen, avoid stacking to the middle cards of the same type on top of each other.", 10, 150);
    g.drawString("                I.E. ACE ON ACE or FIVE ON FIVE.",10,175);
    g.drawString("FOR EXAMPLE: if SUIT mode was chosen, avoid stacking to the middle cards of the same type on top of each other.", 10, 200);
    g.drawString("                I.E. SPADES ON SPADES or HEARTS ON HEARTS.",10,225);
    g.drawString("4. The cards on the bottoom left are the user's hand, and the card in the middle is where stakcing takes place.",10,250);
    g.drawString("5. Only stack on the middle if the cards DON'T MATCH, this is how you avoid a burn", 10, 275);
    g.drawString("6. If you come across cards that match, STACK TO THE SIDE.", 10, 300);
    g.drawString("7. If you stack to the side correctly, all the middle cards that have been piling up will return to your hand", 10, 325);
    g.drawString("8. When this happens, you will be able to keep playing even longer", 10, 350);
    g.drawString("9. The fast you play, correctly, the better your score!", 10, 375);
    g.drawString("10. GOOD LUCK AND HAVE FUN!", 10, 400);
  }

}
