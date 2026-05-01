import java.awt.*;
import javax.swing.*;

public class GamePage extends JFrame {

    public GamePage(Dimension size, Point location) {

        setTitle("Game Page");
        setSize(size);
        setLocation(location);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);

        JLabel label = new JLabel("GAME STARTED ⚡");
        label.setFont(new Font("Segoe UI", Font.BOLD, 40));
        label.setForeground(Color.WHITE);

        panel.add(label);
        setContentPane(panel);
    }
}