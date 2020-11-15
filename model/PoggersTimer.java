package model;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/*
 * Timer Class
 */
public class PoggersTimer extends JPanel
{
	JLabel timerLabel;
	int counter;
	public Timer timer;
	int count;
	int prevRecord;


	public PoggersTimer()
	{
		setLayout(new GridLayout(2,2,5,5));

		timerLabel = new JLabel("Waiting...", SwingConstants.CENTER);
		add(timerLabel);

		TimeClass tc = new TimeClass();
		timer = new Timer(500,tc);
	}

	public class TimeClass implements ActionListener
	{
		//int counter;

		public TimeClass()//int counter)
		{
			//this.counter = counter;
		}

		public void actionPerformed(ActionEvent tc)
		{
			counter++; 

			if(counter >= 1)
			{
				timerLabel.setText("Time: " + counter);
			}

			else
			{
				timer.stop(); 
				timerLabel.setText("Total: " + counter);
				//Toolkit.getDefaultToolkit().beep();
			}
		}
	}

	public int getTimeStamp()
	{
		return counter;
	}

}