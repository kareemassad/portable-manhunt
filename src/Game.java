import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Game extends JFrame implements ActionListener {

    boolean activatedEnd = false;

    // Create a timer that triggers every half-second
    int delay = 100;
    public Timer timer = new Timer(delay, this);
    public Timer secondTimer = new Timer(10, this);
    JLabel endTimer;
    double timeLeft = 25.0;

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

        // endTimer
        endTimer = new JLabel(Double.toString(timeLeft));
        endTimer.setForeground(Color.BLACK);
        endTimer.setHorizontalAlignment(SwingConstants.CENTER);
        endTimer.setBounds((int)(this.getWidth()-titleWidth)/2, 0, titleWidth, 80);
        this.add(endTimer);
        endTimer.setVisible(true);

        // Creates new Board object, which will be refreshed for each frame
        b = new Board();
        b.setBounds((int)(this.getWidth()-b.getWidth())/2, 60, b.getWidth(), b.getHeight());
        this.add(b);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        initializeSamplePlayers();
        detectCollision();

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

    public void detectCollision() throws FileNotFoundException {
        for (int i = 0; i < Main.numberOfPlayers; i++) {
            for (int j = i+1; j < Main.numberOfPlayers; j++) {
                if (Main.players[i].getX() == Main.players[j].getX() && Main.players[i].getY() == Main.players[j].getY()) {
                    if (Main.players[i].isHunter || Main.players[j].isHunter) {
                        Main.players[i].isHunter = true;
                        Main.players[j].isHunter = true;
                        Main.players[i].setColor();
                        Main.players[j].setColor();
                        System.out.println(Main.hunters);
                        repaint();
                        revalidate();
                    }
                }
            }
        }
        int count = 0;
        for (PacPerson p : Main.players) {
            if (p.isHunter) count++;
            delay /= Math.pow(100, Main.hunters - count);
            Main.hunters = count;
        }

        boolean end = false;

        if (Main.hunters == 3 && activatedEnd == false) {
            secondTimer.start();
            activatedEnd = true;
        } else if (Main.hunters == 4) {
            timer.stop();
            secondTimer.stop();
            JOptionPane.showMessageDialog(this, "Game over! Hunters won", "HMMMM", JOptionPane.INFORMATION_MESSAGE);
            end = true;
        } else if (timeLeft <= 0) {
            timer.stop();
            secondTimer.stop();
            JOptionPane.showMessageDialog(this, "Game over! Prey won", "WOHOO", JOptionPane.INFORMATION_MESSAGE);
            end = true;
        }

        if (end) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Try again?", "DO IT!", dialogButton);

            if(dialogResult == 0) {
                Main.g.dispose();
                Main.g = new Game();
            } else {
                this.dispose();
                System.exit(0);
            }
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
            System.out.println(delay);
            b.updateBoard();
            try {
                detectCollision();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == secondTimer) {
            timeLeft -= 0.04;
            System.out.println(timeLeft);
            endTimer.setText(Double.toString((int)timeLeft));
            endTimer.paintImmediately(endTimer.getVisibleRect());
        }

    }
}
