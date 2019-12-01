public class PacPerson {
    //Current direction "PacPerson is facing
    String currentDirection ;

    //possible directions
    boolean up,down,left,right;

    //role is either hunter or prey true -> hunter, false -> prey
    boolean role;

    //current location (might need to change how i keep location later on)
    int x;
    int y;


    public PacPerson(int spawnPoint, boolean hunterOrPrey){
        spawn(spawnPoint);
        role = hunterOrPrey;

    }
    //checks
    public void canMove(){
        //check right
        right = doesExist(x+1, y);
        left = doesExist(x-1,y);
        up = doesExist(x, y+1);
        down = doesExist(x, y-1);

    }
    // checks if location exist
    private boolean doesExist(int x, int y){

        //change later
        return true;

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


    public void move(){
        if (currentDirection == "up" && up == true){ y++;}
        else if(currentDirection == "down" && down == true){y--;}
        else if(currentDirection == "down" && right == true){x++;}
        else{x--;}
    }






}
