import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class ControlView extends JPanel {

    private final Controller controller;

    public ControlView(Controller controllerIn) {
        controller = controllerIn;

        setLayout(new BorderLayout());

        // Create and add a JSlider that controls the speed
        JSlider delaySlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        delaySlider.setMajorTickSpacing(10);
        delaySlider.setMinorTickSpacing(5);
        delaySlider.setPaintTicks(true);
        delaySlider.setPaintLabels(true);
        delaySlider.addChangeListener(e -> {
            int delayValue = 100 - delaySlider.getValue();
            controller.setTime(delayValue);
        });
        Hashtable<Integer, JLabel> delayLabels = new Hashtable<>();
        delayLabels.put(0, new JLabel("Slower"));
        delayLabels.put(100, new JLabel("Faster"));
        delaySlider.setLabelTable(delayLabels);
        add(delaySlider, BorderLayout.NORTH);

        // Create and add a JSlider that controls the step-length
        JSlider stepSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
        stepSlider.setMajorTickSpacing(5);
        stepSlider.setMinorTickSpacing(1);
        stepSlider.setPaintTicks(true);
        stepSlider.setPaintLabels(true);
        stepSlider.addChangeListener(e -> {
            int stepValue = stepSlider.getValue();
            controller.setL(stepValue);
        });
        Hashtable<Integer, JLabel> stepLabels = new Hashtable<>();
        stepLabels.put(0, new JLabel("L = 0"));
        stepLabels.put(10, new JLabel("L = 10"));
        stepSlider.setLabelTable(stepLabels);
        add(stepSlider, BorderLayout.CENTER);
    }
}