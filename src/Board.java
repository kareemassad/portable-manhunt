import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel implements KeyListener {

    // Width and height of the JPanel Board, useful for setBounds from Game
    private static int width = 400;
    private static int height = 400;

    public Board() {

        // Gridlayout with dimY rows and dimX columns
        this.setLayout(new GridLayout(Main.dimY, Main.dimX));

        // Array of Tile objects to add PacPerson to when the game is in progress
        Main.tiles = new Tile[Main.dimY][Main.dimX];

        // Assigns default Tile object to every position in the tiles array
        for (int i = 0; i < Main.dimY; i++) {
            for (int j = 0; j < Main.dimX; j++) {
                Main.tiles[i][j] = new Tile();
                this.add(Main.tiles[i][j]);
            }
        }

        this.addKeyListener(this);

        this.setVisible(true);

        this.setFocusable(true);
        this.requestFocus();

    }

    public void updateBoard() {
        this.revalidate();
        this.repaint();
    }

    // Getters and setters

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        Board.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        Board.height = height;
    }

    // This is for the current player
    @Override
    public void keyTyped(KeyEvent e) {
        int keyCode = e.getKeyChar();
        switch(keyCode) {
            case 'w':
                Main.players[Main.currentPlayerID].setDirection("up");
                break;
            case 's':
                Main.players[Main.currentPlayerID].setDirection("down");
                break;
            case 'a':
                Main.players[Main.currentPlayerID].setDirection("left");
                break;
            case 'd':
                Main.players[Main.currentPlayerID].setDirection("right");
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
