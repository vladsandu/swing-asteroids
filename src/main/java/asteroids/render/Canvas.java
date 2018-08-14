package asteroids.render;

import asteroids.keyboard.KeyboardListener;
import asteroids.state.CurrentData;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JComponent {
    private final CurrentData currentData;

    public Canvas(CurrentData currentData) {
        this.currentData = currentData;
        addKeyListener(makeKeyboardListener(currentData));
    }

    public KeyboardListener makeKeyboardListener(CurrentData currentData) {
        return new KeyboardListener(currentData);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocus();
        Drawer drawer = new Drawer((Graphics2D) g);
        if (!currentData.isGameOver()) {
            currentData.showEntities(drawer);
        } else {
            drawer.drawGameOverScreen(g);
        }
    }
}
