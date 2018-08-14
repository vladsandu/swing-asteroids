package asteroids.player;

import asteroids.asteroid.Asteroid;
import asteroids.math.Vector2;
import asteroids.render.IDrawer;
import asteroids.settings.Settings;
import asteroids.state.Direction;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Player {
    private final Vector2 position;
    private int speed, size;

    public Player() {
        this(new Vector2(Settings.WIDTH / 2, Settings.HEIGHT / 2), Settings.PLAYER_SPEED, Settings.PLAYER_SIZE);
    }

    public Player(Vector2 position, int speed, int size) {
        this.position = position;
        this.speed = speed;
        this.size = size;
    }

    public void move(Direction direction) {
        switch (direction) {
            case UP:
                position.translate(0, -speed);
                break;
            case DOWN:
                position.translate(0, speed);
                break;
            case LEFT:
                position.translate(-speed, 0);
                break;
            case RIGHT:
                position.translate(speed, 0);
                break;
        }
        position.bound(0, Settings.WIDTH - size, 0, Settings.HEIGHT - size);
    }

    public void show(IDrawer drawer) {
        drawer.fillRect(position, size, Settings.PLAYER_COLOR);
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

    public boolean intersects(Asteroid asteroid) {
        Ellipse2D asteroidBox = asteroid.getCollisionBox();
        Rectangle playerBox = getCollisionBox();
        return asteroidBox.intersects(playerBox);
    }

    private Rectangle getCollisionBox() {
        return new Rectangle(position.getX(), position.getY(), size, size);
    }
}
