import javax.swing.*;
import java.awt.*;

public class PacPerson extends JLabel {
    //Current direction "PacPerson is facing
    private String currentDirection ;

    //possible directions
    private boolean up,down,left,right;

    //role is either hunter or prey true -> hunter, false -> prey
    private boolean role;

    //current location (might need to change how i keep location later on)
    int x;
    int y;


    private PacPerson(int spawnPoint, boolean hunterOrPrey){
        currentDirection = "right";

        spawn(spawnPoint);
        role = hunterOrPrey;
        this.setVisible(true);
        this.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
    }
    public String getDirection(){
        return currentDirection;
    }




    //checks
    private void canMove(){
        //check right

        right = Main.tiles[x+1][y].isFloor();
        left = Main.tiles[x-1][y].isFloor();
        up = Main.tiles[x][y+1].isFloor();
        down = Main.tiles[x][y-1].isFloor();

    }






    //for now we will not randomize spawn location
    //3 spawn points
    private void spawn(int spawnPoint){
        if(spawnPoint == 1){
            x = 1;
            y = 1;
        }
        else if(spawnPoint == 2){
            x = 4;
            y = 4;

        }
        else{
            x = 6;
            y= 8;
        }
    }

    //moves location based off current direction
    public void move(){
        if (currentDirection == "up" && up == true){ y++;}
        else if(currentDirection == "down" && down == true){y--;}
        else if(currentDirection == "down" && right == true){x++;}
        else{x--;}
    }








}
