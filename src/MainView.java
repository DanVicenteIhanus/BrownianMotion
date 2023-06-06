import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class MainView extends JFrame {

    private final ParticleView particleView;
    private final ControlView controlView;

    public MainView(Controller controllerIn, int width, int height, Color bgColor) {
        ParticleModel model = controllerIn.getModel();
        particleView = new ParticleView(model, bgColor);
        controlView = new ControlView(controllerIn);

        setTitle("Brownian Motion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        add(particleView, BorderLayout.CENTER);
        add(controlView, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public ParticleView getParticleView() {
        return particleView;
    }

}
