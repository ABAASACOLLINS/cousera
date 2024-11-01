import javax.swing.*;
import java.util.Locale;
import java.util.Scanner;

public class strings {
    public static void main(String[]args){
        //strings are used to store data especially characters
        //strings are immutable ie cant be changed once
        //but they can be manipulator

        String fed ="the boy";
        /*
        string methods are used to manipulate strings and are iin the format stringname.manipulator()
        split() splits the string at a certain section
        CompareTo compares two strings(returns true or false)
        length determines the length
        replace replace all matchijng characters with sth else
        contains check if it contains sth(returns false or true)
        trim remove the blank space
        concat concatenates/adds two strings
        charAt returns the index listed
        substring  returns a substring of the string from where it started to where it ends

         can also have toUppercase and toLowercase
         */
        System.out.println(fed.length());
        System.out.println(fed.charAt(6));
        System.out.println(fed.substring(0,3));
        String password = JOptionPane.showInputDialog("please enter your password");
        while (password.length()<15) {
        password=JOptionPane.showInputDialog("please input longer password");};
        Scanner acne= new Scanner(System.in);
if (!fed.equals(fed.toUpperCase(Locale.ROOT))){
    System.out.println("include an upper case letter");
}

    }
}
