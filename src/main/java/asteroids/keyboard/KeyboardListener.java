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
        character = Character.toUpperCase(character);
        switch (character){
            case 'W':
                currentData.movePlayer(Direction.UP);
                break;
            case 'S':
                currentData.movePlayer(Direction.DOWN);
                break;
            case 'A':
                currentData.movePlayer(Direction.LEFT);
                break;
            case 'D':
                currentData.movePlayer(Direction.RIGHT);
                break;
            case 'R':
                currentData.resetGame();
                break;
        }
    }
}
