import javax.swing.*;

public class frontPage extends JFrame {

    public frontPage() {

        setTitle("PACMAN YALL");
        setSize(400, 400);

        // Create new buttons and JPanel
        JButton button1 = new JButton("Map 1");
        JButton button2 = new JButton("Map 2");
        JButton button3 = new JButton("Map 3");

        JPanel panel = new JPanel();

        // Add buttons to JPanel
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        // Move Buttons
        button1.setLayout(null);
        button1.setLocation(50,250);

        button2.setLayout(null);
        button2.setLocation(50,250);

        button3.setLayout(null);
        button3.setLocation(50,250);
        // And JPanel needs to be added to the JFrame itself
        this.getContentPane().add(panel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        frontPage a = new frontPage();
    }
}