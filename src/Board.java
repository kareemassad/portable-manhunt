import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    public Board() {

        this.setBounds(0, 0, 100, 100);

        this.setTitle("Man Pac Ultimate Portable Chainsaw");

        this.setLayout(new GridLayout(10, 10));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);

    }

}
