import javax.swing.JOptionPane;
public class Switch {
    public static void main (String[]args){
        int ages=18;
        switch (ages){
            case 15:
                System.out.println("you are older");
        break;
            case 14 :
                System.out.println("you are you");
                break;
            default:
                System.out.println("it is what it is");
                JOptionPane.showConfirmDialog(null,"confirm you want to exit");

        }

    }
}
