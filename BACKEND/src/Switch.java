import javax.swing.JOptionPane;
public class Switch {
    public Switch() {
    }

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


// Adding a while loop
        int counter = 0;
        while (counter < 5) {
            System.out.println("Counter: " + counter);
            counter++;
        }

// Adding a do-while loop
        int counter2 = 0;
        do {
            System.out.println("Counter2: " + counter2);
            counter2++;
        } while (counter2 < 5);

    }
}
