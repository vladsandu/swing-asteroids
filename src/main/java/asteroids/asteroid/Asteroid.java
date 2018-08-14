package asteroids.asteroid;

import asteroids.math.Vector2;
import asteroids.render.IDrawer;
import asteroids.settings.Settings;
import javafx.scene.shape.Circle;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Asteroid {
    private Vector2 position;
    private int speed, size;

    public Asteroid() {
        this(new Vector2(0, -1), Settings.MIN_SPEED, Settings.MIN_SIZE);
    }

    public Asteroid(Vector2 position, int speed, int size) {
        this.position = position;
        this.speed = speed;
        this.size = size;
    }

    public void update() {
        position.translate(0, speed);
    }

    public void show(IDrawer drawer) {
        drawer.fillCircle(position, size, Settings.ASTEROID_COLOR);
    }

    public boolean isOffScreen() {
        return position.getY() > Settings.HEIGHT;
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSize() {
        return size;
    }

    public Ellipse2D getCollisionBox() {
        return new Ellipse2D.Float(position.getX(), position.getY(), size, size);
    }
}
