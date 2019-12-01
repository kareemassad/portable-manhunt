import javax.swing.*;
import java.awt.*;
import java.lang.invoke.SwitchPoint;

public class Tile extends JLabel {

    // Attribute for whether the tile is floor (player can stand on it) or tile is wall (player cannot pass through)
    boolean isFloor = true;
    boolean isPlayer = false;

    public Tile() {

        this.setVisible(true);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

    }

    // Getters and setters

    public boolean isFloor() {
        return isFloor;
    }
    public boolean isPlayer(){
        return isPlayer;
    }
    public void setFloor(boolean floor) {
        isFloor = floor;
        isPlayer = !floor;
        if(floor){
            this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        }
        else{
            this.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
        }


    }
    public void setPlayer(boolean player){
        isPlayer = player;
        isFloor = !player;
    }
}
