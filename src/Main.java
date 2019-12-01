public class Main {

    public static Tile[][] tiles;

    // X and Y dimensions for the number of tiles on the board
    // Also useful for checking bounds of the PacPerson coordinates
    public static int dimX = 15;
    public static int dimY = 15;

    public static int currentPlayerID = 0;

    // List of players
    public static int numberOfPlayers = 1;
    public static PacPerson[] players = new PacPerson[numberOfPlayers];

    public static void main(String[] args) {

        System.out.println("Hello, world!");

        new Game();

    }

}
