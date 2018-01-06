import javax.swing.*;

public class Project0
{
     public static void main(String[] args)
     {
          String input = JOptionPane.showInputDialog(null, "Please enter a sentence.");
		  while(!input.equalsIgnoreCase("STOP"))
          {
               int lowercase = 0;
               int uppercase = 0;
               for(int i = 0; i < input.length(); i++)
               {
                    if(new Character(input.charAt(i)).equals(new Character('e')))
                         lowercase++;
                    if(new Character(input.charAt(i)).equals(new Character('E')))
                         uppercase++;
               }
              JOptionPane.showMessageDialog(null, "Number of lower case e's: " + lowercase + "\n" + " Number of upper case e's: " + uppercase);
			  input = JOptionPane.showInputDialog(null, "Please enter a sentence.");
          }
     }
}