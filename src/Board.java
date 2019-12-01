import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

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



        this.setVisible(true);

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

}
