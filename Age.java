 /*
 * @author Arundhati Raicar
 * @version Last modified 27_March_2024
 */
import javax.swing.*;

//The class pops up an option pane that asks the user for his/her age.
public class Age{

    //The main method displays a message in a messagebox depending on the users age.
    public static void main(String[] args){  
        String ageText=JOptionPane.showInputDialog(null,"What is your age, cowboy?");
        int age = Integer.parseInt(ageText);
        if(age < 40){
             JOptionPane.showMessageDialog(null,"Wow you are soo young!");
        }else{
            JOptionPane.showMessageDialog(null,"Haha,You are old!");
        } 
    }
}