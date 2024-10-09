import javax.swing.JOptionPane;
import java.util.Scanner;

public class logicalOperators {
    public static void main (String[]args){
        // logical operators include && both statements are true for and
        // || for or and
        // ! for not which reverses boolean value of condition
        int number= 45;
        if(number<45 && number>40){
            System.out.println("you are middle age" );

        }
        else {
            System.out.println("young");
        }
        if (number<40 || number>80){
            System.out.println("still middle age");
        }
        String get= JOptionPane.showInputDialog("how old are you");
        if (get.equals("boy")){
            System.out.println("male");
        }
        if (number == 45 ){
            System.out.println("oldie");
        }
//while loops
        Scanner bio=new Scanner(System.in);
        int age =16;
        while (age<18 && age>78){
            System.out.println("you are still young");
            age= bio.nextInt();
        }

    }
}
