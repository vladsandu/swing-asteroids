package asteroids.render;

import asteroids.math.Vector2;

import java.awt.*;

public interface IDrawer {
    void fillRect(Vector2 position, int size, Color color);
    void fillCircle(Vector2 position, int size, Color color);

    void drawGameOverScreen(Graphics g);
}
