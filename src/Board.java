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
    public void keyPressed (KeyEvent e) {
        int keyCode = e.getKeyChar();
        int c = e.getKeyCode();
        switch(keyCode) {
            case 'w':
                if (Main.players[0].canMove("up"))
                    Main.players[0].setDirection("up");

                break;
            case 's':
                if (Main.players[0].canMove("down"))
                    Main.players[0].setDirection("down");
                //send to client or server

                break;
            case 'a':
                if (Main.players[0].canMove("left"))
                    Main.players[0].setDirection("left");
                //send to client or server

                break;
            case 'd':
                if (Main.players[0].canMove("right"))
                    Main.players[0].setDirection("right");
                break;
            case 'u':
                if (Main.players[1].canMove("up"))
                    Main.players[1].setDirection("up");
                break;
            case 'h':
                if (Main.players[1].canMove("left"))
                    Main.players[1].setDirection("left");
                break;
            case 'j':
                if (Main.players[1].canMove("down"))
                    Main.players[1].setDirection("down");
                break;
            case 'k':
                if (Main.players[1].canMove("right"))
                    Main.players[1].setDirection("right");
                break;
            case KeyEvent.VK_DOWN:
                if (Main.players[2].canMove("down"))
                    Main.players[2].setDirection("down");
                break;
            case KeyEvent.VK_RIGHT:
                if (Main.players[2].canMove("right"))
                    Main.players[2].setDirection("right");
                break;
            case KeyEvent.VK_UP:
                if (Main.players[2].canMove("up"))
                    Main.players[2].setDirection("up");
                break;
            case KeyEvent.VK_LEFT:
                if (Main.players[2].canMove("left"))
                    Main.players[2].setDirection("left");
                break;
            case '8':
                if (Main.players[3].canMove("up"))
                    Main.players[3].setDirection("up");
                break;
            case '4':
                if (Main.players[3].canMove("left"))
                    Main.players[3].setDirection("left");
                break;
            case '2':
                if (Main.players[3].canMove("down"))
                    Main.players[3].setDirection("down");
                break;
            case '5':
                if (Main.players[3].canMove("right"))
                    Main.players[3].setDirection("right");
                break;

        }

        if (c == 38) {
            if (Main.players[2].canMove("up"))
                Main.players[2].setDirection("up");
        }
        if(c == 40){
            if (Main.players[2].canMove("down"))
                Main.players[2].setDirection("down");
        }
        if(c == 39){
            if (Main.players[2].canMove("right"))
                Main.players[2].setDirection("right");
        }
        if(c == 37){
            if (Main.players[2].canMove("left"))
                Main.players[2].setDirection("left");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
