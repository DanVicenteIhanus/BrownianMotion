import javax.swing.*;
import java.awt.*;

public class ParticleView extends JPanel {
    ParticleModel model;

    public ParticleView(ParticleModel modelIn, Color bgColor) {
        model = modelIn;
        // set the size and color of background in panel
        setPreferredSize(new Dimension(model.getWidth(), model.getHeight()));
        setBackground(bgColor);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Particle[] particles = model.getParticles();
        for (Particle p : particles) {
            int x = (int) p.getX();
            int y = (int) p.getY();
            g2.setColor(p.getColor());
            int r = p.getRadius();
            g2.fillOval(x, y, 2*r, 2*r);
        }
    }



}