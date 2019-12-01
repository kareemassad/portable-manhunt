import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements ActionListener, KeyListener {

    // Create a timer that triggers every half-second
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

    @Override
    public void keyTyped(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP:
                // handle up
                break;
            case KeyEvent.VK_DOWN:
                // handle down
                break;
            case KeyEvent.VK_LEFT:
                // handle left
                break;
            case KeyEvent.VK_RIGHT :
                // handle right
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }
}
