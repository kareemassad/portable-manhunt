import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    private static int dimX = 15;
    private static int dimY = 15;

    private static int width = 300;
    private static int height = 300;

    public Board() {

        this.setLayout(new GridLayout(dimY, dimX));

        Tile[][] tiles = new Tile[dimY][dimX];

        for (int i = 0; i < dimY; i++) {
            for (int j = 0; j < dimX; j++) {
                tiles[i][j] = new Tile();
                this.add(tiles[i][j]);
            }
        }

        this.setVisible(true);

    }

    public void updateBoard() {

    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        Board.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        Board.height = height;
    }
}
