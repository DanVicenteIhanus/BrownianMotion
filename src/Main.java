import java.awt.*;

public class Main {

    public static void main(String[] args) {

        // parameters to be set by user
        int N = 20000;
        int width = 400;
        int height = 400;
        int time = 50;
        int stickyRadius = 1;
        Color bgColor = Color.DARK_GRAY;
        boolean boundary = false;

        // create controller with the parameters above
        Controller controller = new Controller(N, width, height, boundary, stickyRadius, bgColor, time);

        // start the simulation
        controller.start();
    }

}
