import javax.swing.*;
import java.awt.*;
//not sure if this need to extend JLabel
public class PacPerson {

    //Current direction "PacPerson is facing
    private String currentDirection ;

    //possible directions
    private boolean up, down, left, right;

    //role is either hunter or prey true -> hunter, false -> prey
    private boolean isHunter;

    // Color of the PacPerson: red -> hunter, green -> prey
    private Color color;

    //current location (might need to change how i keep location later on)
    int x;
    int y;

    public PacPerson(boolean isHunter){
        currentDirection = "right";

        //spawn(spawnPoint);
        this.isHunter = isHunter;
        this.setColor();
        /*
        this.setVisible(true);
        this.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
        this.setText("A");*/
    }
    public String getDirection(){
        return currentDirection;
    }

    public void setDirection(String dir){
        currentDirection = dir;
    }

    //checks
    private void canMove(){
        //check right

    }

    //moves location based off current direction
    public void move(){

        // Checks for walls
        right = x < Main.dimX-1 && Main.tiles[x+1][y].isFloor();
        left = x > 0 && Main.tiles[x-1][y].isFloor();
        up = y > 0 && Main.tiles[x][y-1].isFloor();
        down = y < Main.dimY-1 && Main.tiles[x][y+1].isFloor();

        // Moves
        System.out.println(currentDirection + " " + right + " " + getX() + " " + getY());
        if (currentDirection.equals("up") && up == true){ y++;}
        else if(currentDirection.equals("down") && down == true){y--;}
        else if(currentDirection.equals("right") && right == true){x++;}
        else{x--;}
//        switch (currentDirection)
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor() {
        if (this.isHunter)
            this.color = Color.RED;
        else
            this.color = Color.GREEN;
    }
}