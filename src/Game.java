import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class Game extends JFrame implements ActionListener {

    // Create a timer that triggers every half-second
    public Timer timer = new Timer(2, this);

    Board b;

    public Game() throws FileNotFoundException {

        this.setBounds(100, 100, 600, 670);
        this.setLayout(null);

        this.setTitle("Pac Person Ultimate Portable Chainsaw");

        // Creates a title for the game
        JLabel titleText = new JLabel("Pac Person Ultimate Portable Chainsaw");
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

        // TODO: Fix

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        initializeSamplePlayers();

        // Start timer after the board is created
        timer.start();

    }

    public void initializeSamplePlayers() {

        Main.players[0] = new PacPerson(true);
        Main.players[0].setX(23);
        Main.players[0].setY(23);

        Main.players[1] = new PacPerson(false);
        Main.players[1].setX(1);
        Main.players[1].setY(1);

        Main.players[2] = new PacPerson(false);
        Main.players[2].setX(23);
        Main.players[2].setY(1);

        Main.players[3] = new PacPerson(false);
        Main.players[3].setX(1);
        Main.players[3].setY(23);






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
}
