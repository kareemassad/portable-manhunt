import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    public Game() {

        this.setBounds(100, 100, 500, 530);
        this.setLayout(null);

        this.setTitle("Man Pac Ultimate Portable Chainsaw");

        JLabel titleText = new JLabel("Insert title");
        titleText.setForeground(Color.BLACK);
        int titleWidth = 100;
        titleText.setHorizontalAlignment(SwingConstants.CENTER);
        titleText.setBounds((int)(this.getWidth()-titleWidth)/2, 20, titleWidth, 100);

        this.add(titleText);
        titleText.setVisible(true);


         Board b = new Board();

         b.setBounds((int)(this.getWidth()-b.getWidth())/2, 100, b.getWidth(), b.getHeight());

         this.add(b);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
