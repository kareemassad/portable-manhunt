import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board extends JPanel implements KeyListener {

    // Width and height of the JPanel Board, useful for setBounds from Game
    private static int width = 550;
    private static int height = 550;

    public Board() throws FileNotFoundException {

        this.setBackground(Color.WHITE);

        // Gridlayout with dimY rows and dimX columns
        this.setLayout(new GridLayout(Main.dimY, Main.dimX));

        // Array of Tile objects to add PacPerson to when the game is in progress
        Main.tiles = new Tile[Main.dimY][Main.dimX];

        // Read the file and make a 2d array based on the boolean values
        boolean[][] isWallArray = new boolean[Main.dimY][Main.dimY];
        Scanner read = new Scanner(new File("res/map" + Main.map + ".txt"));
        int ii = 0;
        int jj = 0;
        while (read.hasNext() && ii < Main.dimY) {
            String[] line = read.next().split("");
            for (String x : line) {
                System.out.println(ii + " " + jj);
                isWallArray[ii][jj] = x.equals("1");
                jj++;
            }
            ii++;
            jj = 0;
        }

        // Assigns default Tile object to every position in the tiles array
        for (int i = 0; i < Main.dimY; i++) {
            for (int j = 0; j < Main.dimX; j++) {
                Main.tiles[i][j] = new Tile();
                if (isWallArray[i][j]) {
                    Main.tiles[i][j].isFloor = false;
                    Main.tiles[i][j].setColor();
                }
                Main.tiles[i][j].setBackground(Main.tiles[i][j].getColor());
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
                if (Main.players[Main.currentPlayerID].canMove("up"))
                    Main.players[Main.currentPlayerID].setDirection("up");
                break;
            case 's':
                if (Main.players[Main.currentPlayerID].canMove("down"))
                    Main.players[Main.currentPlayerID].setDirection("down");
                break;
            case 'a':
                if (Main.players[Main.currentPlayerID].canMove("left"))
                    Main.players[Main.currentPlayerID].setDirection("left");
                break;
            case 'd':
                if (Main.players[Main.currentPlayerID].canMove("right"))
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
