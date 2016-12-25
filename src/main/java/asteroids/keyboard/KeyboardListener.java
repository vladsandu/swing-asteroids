package asteroids.keyboard;

import asteroids.state.CurrentData;
import asteroids.state.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener{
    private final CurrentData currentData;

    public KeyboardListener(CurrentData currentData) {
        this.currentData = currentData;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        processKey(e.getKeyChar());
    }

    public void keyReleased(KeyEvent e) {

    }

    public void processKey(char character) {
        switch (character){
            case 'W':
            case 'w':
                currentData.movePlayer(Direction.UP);
                break;
            case 'S':
            case 's':
                currentData.movePlayer(Direction.DOWN);
                break;
            case 'A':
            case 'a':
                currentData.movePlayer(Direction.LEFT);
                break;
            case 'D':
            case 'd':
                currentData.movePlayer(Direction.RIGHT);
                break;
        }
    }
}
