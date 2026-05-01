import java.awt.*;
import javax.swing.*;

public class FrontPageDynamic extends JFrame {

    public FrontPageDynamic() {

        setTitle("GRIDFIX");
        setSize(1200, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel bg = new JPanel();
        bg.setBackground(Color.BLACK);
        bg.setLayout(new BoxLayout(bg, BoxLayout.Y_AXIS));
        setContentPane(bg);

        bg.add(Box.createVerticalStrut(60));

        StaticLogo logo = new StaticLogo(140, 140);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        bg.add(logo);

        bg.add(Box.createVerticalStrut(20));

        JLabel title = new JLabel("GRIDFIX", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 80));
        title.setForeground(new Color(0, 200, 255));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        bg.add(title);

        JLabel subtitle = new JLabel("Smart Energy Grid", SwingConstants.CENTER);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 28));
        subtitle.setForeground(new Color(0, 255, 200));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        bg.add(subtitle);

        bg.add(Box.createVerticalStrut(40));

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
        btnPanel.setOpaque(false);

        JButton startBtn = new JButton("ENERGISE THE GRID");
        JButton helpBtn = new JButton("HOW TO PLAY");

        setupInteractiveButton(startBtn, new Color(0, 200, 150));
        setupInteractiveButton(helpBtn, new Color(0, 150, 255));

        startBtn.setPreferredSize(new Dimension(280, 50));
        helpBtn.setPreferredSize(new Dimension(220, 50));

        btnPanel.add(startBtn);
        btnPanel.add(helpBtn);
        bg.add(btnPanel);

        bg.add(Box.createVerticalStrut(30));

        startBtn.addActionListener(e -> openGamePage());
        helpBtn.addActionListener(e -> openHelpPage());
    }

    private void setupInteractiveButton(JButton btn, Color baseColor) {
        btn.setBackground(baseColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(baseColor.brighter());
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(baseColor);
            }
        });
    }

    private void openGamePage() {
        GamePage gamePage = new GamePage(getSize(), getLocation());
        gamePage.setVisible(true); 
        dispose();
    }

    private void openHelpPage() {
        HowToPlayPage helpPage = new HowToPlayPage(getSize(), getLocation());
        helpPage.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrontPageDynamic().setVisible(true));
    }
}

// ================= LOGO =================

class StaticLogo extends JComponent {

    public StaticLogo(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int cx = getWidth() / 2;
        int cy = getHeight() / 2;

        Polygon bolt = new Polygon();

        int[][] points = {
                { 20, -45 },
                { -25, 5 },
                { 5, 5 },
                { -20, 45 },
                { 25, -5 },
                { -5, -5 }
        };

        double scale = 1.3;

        for (int[] p : points) {
            int px = (int) (p[0] * scale);
            int py = (int) (p[1] * scale);
            bolt.addPoint(cx + px, cy + py);
        }

        for (int i = 6; i >= 1; i--) {
            int alpha = (i == 1) ? 255 : (40 / i);
            g2.setColor(new Color(100, 200, 255, alpha));
            g2.setStroke(new BasicStroke(i * 3.5f));
            g2.draw(bolt);
        }

        g2.setColor(new Color(220, 245, 255));
        g2.setStroke(new BasicStroke(3.5f));
        g2.draw(bolt);

        g2.dispose();
    }
}