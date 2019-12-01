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


    public PacPerson(int spawnPoint){
        spawn(spawnPoint);

    }
    //checks
    public void canMove(){

    }

    //for now we will not randomize spawn location
    //3 spawn points
    public void spawn(int spawnPoint){
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







}
