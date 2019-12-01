import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    private static int dimX = 10;
    private static int dimY = 10;

    public Board() {

        this.setBounds(100, 100, 300, 330);

        this.setTitle("Man Pac Ultimate Portable Chainsaw");

        this.setLayout(new BorderLayout());

        JPanel gamearea = new JPanel(new GridLayout(10, 10));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Tile[][] tiles = new Tile[dimY][dimX];

        for (int i = 0; i < dimY; i++) {
            for (int j = 0; j < dimX; j++) {
                tiles[i][j] = new Tile();
                gamearea.add(tiles[i][j]);
            }
        }

        this.add(gamearea);

        this.setVisible(true);

    }

}
