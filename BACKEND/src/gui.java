import javax.swing.JOptionPane;
public class gui {
    public static void main (String[]args){
        int age =Integer.parseInt(JOptionPane.showInputDialog( "enter your age"));
        if (age < 15) {
            JOptionPane.showMessageDialog(null,"YOU ARE BELOW AGE"); }
        else if (age <= 18){JOptionPane.showMessageDialog(null,"you are not an adult");}
        else  {JOptionPane.showMessageDialog(null, "you can proceed");}
        JOptionPane.showConfirmDialog(null,"confirm you want to proceed");

    }
}
