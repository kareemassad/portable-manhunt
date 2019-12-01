import javax.swing.*;
import java.awt.*;

public class Tile extends JLabel {

    // Attribute for whether the tile is floor (player can stand on it) or tile is wall (player cannot pass through)
    boolean isFloor = true;

    public Tile() {

        this.setVisible(true);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

    }

    // Getters and setters

    public boolean isFloor() {
        return isFloor;
    }

    public void setFloor(boolean floor) {
        isFloor = floor;
    }
}
