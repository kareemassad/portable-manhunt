import java.io.FileNotFoundException;

public class Main {

    public static Game g;

    public static Tile[][] tiles;

    // X and Y dimensions for the number of tiles on the board
    // Also useful for checking bounds of the PacPerson coordinates
    public static int dimX = 25;
    public static int dimY = 25;

    public static int hunters = 1;

    // Based on the online thing
    public static int currentPlayerID = 0;




    //

    // From map selection
    public static int map = 3;

    // List of players
    public static int numberOfPlayers = 4;
    public static PacPerson[] players = new PacPerson[numberOfPlayers];


    public static void main(String[] args) throws FileNotFoundException {


        System.out.println("Hello, world!");

        g = new Game();

    }
}
