import javax.swing.*;
import java.awt.*;
import java.lang.invoke.SwitchPoint;

public class Tile extends JLabel {

    private Color color;

    // Attribute for whether the tile is floor (player can stand on it) or tile is wall (player cannot pass through)
    boolean isFloor = true;
    boolean isPlayer = false;

    public Tile() {

        this.setVisible(true);
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        setColor();

    }

    // Getters and setters

    public boolean isFloor() {
        return isFloor;
    }
    public boolean isPlayer(){
        return isPlayer;
    }

    public Color getColor() {
        return color;
    }

    public void setColor() {
        if (this.isFloor)
            this.color = Color.WHITE;
        else
            this.color = Color.BLACK;
    }

}
