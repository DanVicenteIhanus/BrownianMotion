import java.awt.*;
import java.util.*;

public class Particle {
    private double x;
    private double y;
    private boolean moving = true;
    private Color color;
    private final Random rand = new Random();
    private int radius = 1;
    private int L = 5;
    private int width;
    private int height;

    public Particle(float xIn, float yIn) {
        x = xIn; y = yIn;
        color = Color.white;
    }
    public Particle(int widthIn, int heightIn) {
        // generate random position in grid
        width = widthIn; height = heightIn;
        float xRand = (float) width/2 + rand.nextFloat()*width/16;
        float yRand = (float) height/2 + rand.nextFloat()*height/16;
        x = xRand; y = yRand;
        color = Color.white;
    }
    public void move() {
        // set moving to true, create a pseudorandom phi.
        moving = true;
        double phi = rand.nextDouble(2*Math.PI);

        // Update the position with the phi generated above
        x = getX() + L*Math.cos(phi);
        y = getY() + L*Math.sin(phi);

    }
    // setters/getters
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double xIn) {
        x = xIn;
    }
    public void setY(double yIn) {
        y = yIn;
    }
    public void setMoving(boolean movingIn) {
        moving = movingIn;
    }
    public boolean getMoving() {
        return moving;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public int getRadius() {
        return radius;
    }
    public void setL(int l) {
        L = l;
    }
    public int getL() {
        return L;
    }
}
