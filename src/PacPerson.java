import javax.swing.*;

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
        spawn(spawnPoint);
        role = hunterOrPrey;

    }
    //checks
    private void canMove(){
        //check right
        /*
        right = isFloor(x+1, y);
        left = isWall(x-1,y);
        up = isWall(x, y+1);
        down = isWall(x, y-1);*/

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
