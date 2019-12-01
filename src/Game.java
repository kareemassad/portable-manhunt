import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {

    public Timer timer = new Timer(500, this);

    public Game() {

        this.setBounds(100, 100, 500, 530);
        this.setLayout(null);

        this.setTitle("Man Pac Ultimate Portable Chainsaw");

        // Creates a title for the game
        JLabel titleText = new JLabel("Man Pac Ultimate Portable Chainsaw");
        titleText.setForeground(Color.BLACK);
        int titleWidth = 300;
        titleText.setHorizontalAlignment(SwingConstants.CENTER);
        titleText.setBounds((int)(this.getWidth()-titleWidth)/2, 0, titleWidth, 50);
        this.add(titleText);
        titleText.setVisible(true);

        // Creates new Board object, which will be refreshed for each frame
         Board b = new Board();
         b.setBounds((int)(this.getWidth()-b.getWidth())/2, 60, b.getWidth(), b.getHeight());
         this.add(b);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Start timer after the board is created
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            // TODO: Fix timer
        }
    }
}
