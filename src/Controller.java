import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private ParticleModel model;
    private MainView view;
    private Timer timer;
    private Particle[] particles;

    public Controller(int N, int width, int height, boolean boundary, int stickyRadius, Color bgColor, int time) {
        model = new ParticleModel(N, width, height, boundary, stickyRadius);
        particles = model.getParticles();
        timer = new Timer(time, this);
        view = new MainView(this, width, height, bgColor);
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void setN(int N) {
        model.setN(N);
    }

    public void setTime(int n) {
        timer.setDelay(n);
    }

    public void stopTimer() {
        timer.stop();
    }

    public void setL(int n) {
        for (Particle p : particles) {
            p.setL(n);
        }
    }

    public void setRadius(int n) {
        for (Particle p : particles) {
            p.setRadius(n);
        }
    }

    public ParticleModel getModel() {
        return model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.update();
        view.getParticleView().repaint();
    }
}