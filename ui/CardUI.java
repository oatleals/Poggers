package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
/*
 * This class is solely dedicated to visualizing a Card object via an ImageIcon
 */
public class CardUI extends JPanel{

  private Card cardForUI;
  private String source;

  public CardUI()
  {}

  public CardUI(Card c)
  {
    this.cardForUI = c;
    this.source = cardForUI.getSource();
  }

  public void changeCard(Card c)
  {
    this.source = c.getSource();
  }

  public String getSource()
  {
    return source;
  }

  @Override
  protected void paintComponent(Graphics g)
  {

    super.paintComponent(g);
    ImageIcon card = new ImageIcon(source);
    card.paintIcon(this,g,0,0);

  }

}










