import javax.swing.*;
import java.awt.*;
//not sure if this need to extend JLabel
public class PacPerson {
    //Current direction "PacPerson is facing
    private String currentDirection ;

    //possible directions
    private boolean up,down,left,right;

    //role is either hunter or prey true -> hunter, false -> prey
    private boolean role;

    //current location (might need to change how i keep location later on)
    int x;
    int y;

    public PacPerson( boolean hunterOrPrey){
        currentDirection = "right";

        //spawn(spawnPoint);
        role = hunterOrPrey;
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

        right = Main.tiles[x+1][y].isFloor();
        left = Main.tiles[x-1][y].isFloor();
        up = Main.tiles[x][y+1].isFloor();
        down = Main.tiles[x][y-1].isFloor();

    }

    //moves location based off current direction
    public void move(){
        if (currentDirection == "up" && up == true){ y++;}
        else if(currentDirection == "down" && down == true){y--;}
        else if(currentDirection == "down" && right == true){x++;}
        else{x--;}
    }
}