package asteroids.render;

import asteroids.math.Vector2;

import java.awt.*;

public class Drawer implements IDrawer{
    private final Graphics2D graphics;

    public Drawer(Graphics2D graphics) {
        this.graphics = graphics;
    }

    public void fillRect(Vector2 position, int size, Color color) {
        graphics.setColor(color);
        graphics.fillRect(position.getX(), position.getY(), size, size);
    }

    public void fillCircle(Vector2 position, int size, Color color) {
        graphics.setColor(color);
        graphics.fillOval(position.getX(), position.getY(), size, size);
    }
}
