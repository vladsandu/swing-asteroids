package asteroids.asteroid;

import asteroids.math.Vector2;
import asteroids.settings.Settings;

import java.util.Random;

public class AsteroidFactory {
    private final Random random;
    private int xMaxBound, speedMaxBound, sizeMaxBound, speedMinBound, sizeMinBound;

    public AsteroidFactory() {
        this(new Random());
    }

    // TODO: Consider injecting a Settings object versus using static constants for improved testability
    public AsteroidFactory(Random random) {
        xMaxBound = Settings.WIDTH;
        speedMinBound = Settings.MIN_SPEED;
        speedMaxBound = Settings.MAX_SPEED;
        sizeMinBound = Settings.MIN_SIZE;
        sizeMaxBound = Settings.MAX_SIZE;
        this.random = random;
    }

    public Asteroid makeAsteroid() {
        int x = random.nextInt(xMaxBound);
        int speed = speedMinBound + random.nextInt(speedMaxBound - speedMinBound);
        int size = sizeMinBound + random.nextInt(sizeMaxBound - sizeMinBound);
        return new Asteroid(new Vector2(x, -size), speed, size);
    }

    public int getxMaxBound() {
        return xMaxBound;
    }

    public void setxMaxBound(int xMaxBound) {
        this.xMaxBound = xMaxBound;
    }

    public int getSpeedMaxBound() {
        return speedMaxBound;
    }

    public void setSpeedMaxBound(int speedMaxBound) {
        this.speedMaxBound = speedMaxBound;
    }

    public int getSizeMaxBound() {
        return sizeMaxBound;
    }

    public void setSizeMaxBound(int sizeMaxBound) {
        this.sizeMaxBound = sizeMaxBound;
    }

    public int getSpeedMinBound() {
        return speedMinBound;
    }

    public void setSpeedMinBound(int speedMinBound) {
        this.speedMinBound = speedMinBound;
    }

    public int getSizeMinBound() {
        return sizeMinBound;
    }

    public void setSizeMinBound(int sizeMinBound) {
        this.sizeMinBound = sizeMinBound;
    }
}
