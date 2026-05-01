import java.awt.*;
import javax.swing.*;

public class HowToPlayPage extends JFrame {

    public HowToPlayPage(Dimension size, Point location) {

        setTitle("How To Play");
        setSize(size);
        setLocation(location);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);

        JLabel label = new JLabel("HOW TO PLAY");
        label.setFont(new Font("Segoe UI", Font.BOLD, 40));
        label.setForeground(Color.CYAN);

        panel.add(label);
        setContentPane(panel);
    }
}