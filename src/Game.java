import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements ActionListener, KeyListener {

    // Create a timer that triggers every half-second
    public Timer timer = new Timer(500, this);

    Board b;

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
        b = new Board();
        b.setBounds((int)(this.getWidth()-b.getWidth())/2, 60, b.getWidth(), b.getHeight());
        this.add(b);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        initializeSamplePlayers();

        // Start timer after the board is created
        timer.start();

    }

    public void initializeSamplePlayers() {
        for (int i = 0; i < Main.numberOfPlayers; i++) {
            Main.players[i] = new PacPerson(true);
            Main.players[i].setX(0);
            Main.players[i].setY(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            for (int i = 0; i < Main.numberOfPlayers; i++) {
                Main.tiles[Main.players[i].getY()][Main.players[i].getX()].setBackground(Color.WHITE);
                Main.players[i].move();
                Main.tiles[Main.players[i].getY()][Main.players[i].getX()].setBackground(Main.players[i].getColor());
            }
            b.updateBoard();
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
