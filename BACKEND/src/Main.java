import java.util.Scanner;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        int i;
        for (i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
        int[] age = new int[]{4, 5, 6, 7};
        System.out.println(age[3]);

        for (i = 0; i < age.length; i++) {
            System.out.print(age[i] );}
        System.out.println();


            for (int value : age) {
                System.out.print(value);
            }
        System.out.println();
         int [][] number =new int [][]{{23,45,56},
            {98,37,78},
                 {45,37,78},};
            for (int h=0; h<number.length; h++){for (int j=0; j<number[h].length; j++){
                System.out.print(number[h][j]+"\n");
            }}
                System.out.println();
Scanner bio =new Scanner(System.in);
int year =bio.nextInt();
                System.out.println("YEar of birth");
                System.out.println(year);
                String name =JOptionPane.showInputDialog("eneter your name ");
        System.out.println(name);
        int birthyear =bio.nextInt();
        System.out.println(birthyear);
        JOptionPane.showMessageDialog(null,"hello");
            }

        }


