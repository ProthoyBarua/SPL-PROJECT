import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrontPageDynamic extends JFrame {

    public FrontPageDynamic() {
        setTitle("GRIDFIX");
        setSize(1200, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Simple Black Background Panel with BoxLayout
        JPanel bg = new JPanel();
        bg.setBackground(Color.BLACK);
        bg.setLayout(new BoxLayout(bg, BoxLayout.Y_AXIS));
        setContentPane(bg);

        // Top spacing
        bg.add(Box.createVerticalStrut(60));

        // ===== STATIC LOGO =====
        StaticLogo logo = new StaticLogo(140, 140);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        bg.add(logo);

        bg.add(Box.createVerticalStrut(20));

        // ===== TITLE =====
        JLabel title = new JLabel("GRIDFIX", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 80));
        title.setForeground(new Color(0, 200, 255));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        bg.add(title);

        // ===== SUBTITLE =====
        JLabel subtitle = new JLabel("Smart Energy Grid", SwingConstants.CENTER);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 28));
        subtitle.setForeground(new Color(0, 255, 200));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        bg.add(subtitle);

        bg.add(Box.createVerticalStrut(40));

        // ===== BUTTON PANEL =====
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
        btnPanel.setOpaque(false);
        btnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton startBtn = new JButton(" ENERGISE THE GRID");
        startBtn.setBackground(new Color(0, 200, 150));
        startBtn.setForeground(Color.WHITE);
        startBtn.setFocusPainted(false);
        startBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));

        JButton helpBtn = new JButton("HOW TO PLAY");
        helpBtn.setBackground(new Color(0, 150, 255));
        helpBtn.setForeground(Color.WHITE);
        helpBtn.setFocusPainted(false);
        helpBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));

        startBtn.setPreferredSize(new Dimension(280, 50));
        helpBtn.setPreferredSize(new Dimension(220, 50));

        btnPanel.add(startBtn);
        btnPanel.add(helpBtn);

        bg.add(btnPanel);

        // Bottom spacing
        bg.add(Box.createVerticalGlue());

        // ===== BUTTON ACTIONS =====
        startBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Game Start"));
        helpBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "How to play"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrontPageDynamic().setVisible(true));
    }
}

//////////////////////////////////////////////////
// ⚡ CUSTOM NEON LIGHTNING BOLT LOGO (STATIC)
//////////////////////////////////////////////////
class StaticLogo extends JComponent {

    public StaticLogo(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // High quality rendering
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        int cx = getWidth() / 2;
        int cy = getHeight() / 2;

        Polygon bolt = new Polygon();

        // Coordinates for the hollow neon lightning bolt
        int[][] points = {
            {20, -45},   // Top tip
            {-25, 5},    // Left outer point
            {5, 5},      // Inner corner right
            {-20, 45},   // Bottom tip
            {25, -5},    // Right outer point
            {-5, -5}     // Inner corner left
        };

        double scale = 1.3; // Make it a bit bigger

        for (int[] p : points) {
            int px = (int)(p[0] * scale);
            int py = (int)(p[1] * scale);
            bolt.addPoint(cx + px, cy + py);
        }

        // Neon Glow effect
        // Draw multiple thick passes with low alpha
        for (int i = 6; i >= 1; i--) {
            int alpha = (i == 1) ? 255 : (40 / i);
            g2.setColor(new Color(100, 200, 255, alpha)); // Light blue/cyan
            g2.setStroke(new BasicStroke(i * 3.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.draw(bolt);
        }

        // Inner bright core
        g2.setColor(new Color(220, 245, 255)); // Almost white blue
        g2.setStroke(new BasicStroke(3.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.draw(bolt);
    }
}