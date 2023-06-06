import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParticleModel {
    private int n;
    private final Particle[] particles;
    private final int width;
    private final int height;
    private boolean[][] stoppedMap;
    private final boolean extraBoundary;
    private final int stickyRadius;

    ParticleModel(int nIn, int widthIn, int heightIn, boolean bool, int radiusIn) {
        n = nIn;
        width = widthIn;
        height = heightIn;
        particles = genParticles();
        stoppedMap = new boolean[n][n];
        extraBoundary = bool;
        stickyRadius = radiusIn;
    }

    ParticleModel() {
        // Default constructor gives 5000 particles.
        n = 5000;
        width = 500;
        height = 500;
        particles = genParticles();
        extraBoundary = true;
        stickyRadius = 1;
    }

    private Particle[] genParticles() {
        Particle[] particles = new Particle[n];
        for (int i = 0; i < n; i ++ ) {
            particles[i] = new Particle(width, height);
        }
        return particles;
    }

    public void update() {

        for (Particle p : particles) {
            if (p.getMoving()) {
                p.move();
                int x = (int) p.getX(); int y = (int) p.getY(); // get coordinates of each particle

                // Check neighborhood to find nearby stopped particles
                for (int i = -stickyRadius; i <= stickyRadius; i ++ ) {
                    for (int j = -stickyRadius; j <= stickyRadius; j ++ ) {
                        if (x + i >= 0 && x + i < stoppedMap.length && y + j >= 0 &&
                                y + j < stoppedMap[0].length && stoppedMap[x + i][y + j]) {
                            p.setMoving(false);
                            p.setRadius(2); // nicer simulation with a color/size-change
                            p.setColor(Color.red); stoppedMap[x][y] = true;
                        }
                    }
                }

                // Boundary values
                if (Math.abs(p.getX()) > (width - 10) |
                        Math.abs(p.getY()) > (height - 10) |
                        p.getX() < 10 | p.getY() < 10)
                {p.setMoving(false);}

                // Extra boundary (semicircle in corner)
                if (extraBoundary) {
                    int r = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
                    double theta = Math.atan((float) y/x);
                    if(r <= width/3 & theta <= Math.PI) {
                        p.setMoving(false);
                    }
                }

                /*
                // make particles sticky <- this takes too long time
                if(!map.isEmpty()) {
                    for (Map.Entry<Particle, Integer[]> stopped : map.entrySet()) {
                        double distance = Math.sqrt(
                                Math.pow(stopped.getValue()[0] - p.getX(), 2)
                                + Math.pow(stopped.getValue()[1] - p.getY(), 2)
                        );
                        if (distance <= 10) {
                            p.setMoving(false);
                            p.setColor(Color.MAGENTA);
                        }
                    }
                }

                 */

            } else {
                int x = (int) p.getX(); int y = (int) p.getY();
                p.setRadius(1); p.setColor(Color.MAGENTA);
                stoppedMap[x][y] = true; // save "coordinate" of stopped particle
            }
        }
    }

    public Particle[] getParticles() {
        return particles;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
