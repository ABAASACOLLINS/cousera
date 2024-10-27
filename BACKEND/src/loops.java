import javax.swing.*;

public class loops {
    public static void main (String[]args){
/*
while loops repeat sth till the crieria is satisfied and in this case the criteria hs to be input by the function
 they check if the condition is satisfied then execute the command in carry brackets if its not
 */
        int x =4;
        while (x <8){
            System.out.println("x not enough");
            x++;
            System.out.println("ive shifted x to "+ x);

        }
        System.out.println("can i do this");
        do {
            System.out.println("type x ");
            x++;
            System.out.println("ive shifted x to "+ x);
        }while( x<10);
       String name= JOptionPane.showInputDialog("input your name ");
       while(!name.equals("ABAASA")){
           String errorMessage=JOptionPane.showInputDialog(null,"ENTER CORRECT NAME");
            name=errorMessage;
       }
       // FOR LOOP



    }
}
