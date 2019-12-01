import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {

    // X and Y dimensions for the number of tiles on the board
    private static int dimX = 15;
    private static int dimY = 15;

    // Width and height of the JPanel Board, useful for setBounds from Game
    private static int width = 400;
    private static int height = 400;

    public Timer timer = new Timer(500, this);

    public Board() {

        // Gridlayout with dimY rows and dimX columns
        this.setLayout(new GridLayout(dimY, dimX));

        // Array of Tile objects to add PacPerson to when the game is in progress
        Tile[][] tiles = new Tile[dimY][dimX];

        // Assigns default Tile object to every position in the tiles array
        for (int i = 0; i < dimY; i++) {
            for (int j = 0; j < dimX; j++) {
                tiles[i][j] = new Tile();
                this.add(tiles[i][j]);
            }
        }

        this.setVisible(true);

        timer.start();

    }

    public void updateBoard() {
        // TODO: Use appropriate refresh methods
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            // TODO: Fix timer
        }
    }
}
