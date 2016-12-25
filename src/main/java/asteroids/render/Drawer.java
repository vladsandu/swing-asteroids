package asteroids.render;

import asteroids.math.Vector2;
import asteroids.settings.Settings;

import java.awt.*;
import java.util.Set;

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

    @Override
    public void drawGameOverScreen(Graphics g) {
        String message = "Game over!";
        int fontSize = 30;
        Font defaultFont = new Font("Helvetica", Font.PLAIN, fontSize);
        FontMetrics fontMetrics = g.getFontMetrics(defaultFont);
        int stringWidth = fontMetrics.stringWidth(message);
        graphics.setFont(defaultFont);
        graphics.drawString("Game over!", Settings.WIDTH/2 - stringWidth/2, Settings.HEIGHT/2 - fontSize/2);
    }
}
