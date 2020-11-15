package model;
import java.io.*;
import java.lang.*;
import java.util.*;
/*
 * This class reads and writes to the scores file.
 */
public class Score
{

  private File fileName = new File("score.txt");
  public static float highscores[] = new float[5];
  private FileWriter w;
  private Scanner scanner;
  private float score;
  private int k = 0;


  public Score(float score)
  {
    this.score = score;

  }

  public Score()
  {}

  public void openAndRead()
  {
    try
    {
      scanner = new Scanner(fileName);
    }
    catch(Exception e)
    {
      System.out.println("Failed to open file");
    }

    while(scanner.hasNext())
    {

      float f = Float.parseFloat(scanner.nextLine());
      highscores[k] = f;
      System.out.println("k is " + k + " next line is " + f);
      System.out.println(highscores[k]);
      k++;
    }

    for(int i=0; i < 5; i++)
    {
      if(score > highscores[i])
      {
        for (int j=4; j>i; j--)
        {
          highscores[j] = highscores[j-1];
        }
        highscores[i] = score;
        writeToFile();
        break;
      }
    }
  }

  public void writeToFile()
  {
    try
    {
      w = new FileWriter("score.txt", false);
      w.write(highscores[0]+"\n"+highscores[1]+"\n"+highscores[2]+"\n"+highscores[3]+ "\n"+highscores[4]);
      w.close();

    }   
    catch (IOException e)
    {
      System.out.println("Could not write to file");
      System.out.println(e);
    }
  }

  public float getScores(int i)
  {
    return highscores[i];
  }
  
}







