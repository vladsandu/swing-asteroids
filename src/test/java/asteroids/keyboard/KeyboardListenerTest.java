package asteroids.keyboard;

import asteroids.math.Vector2;
import asteroids.state.CurrentData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class KeyboardListenerTest {
    @Test
    public void KeyPressed_WithProperKey_MovesPlayer() {
        CurrentData currentData = new CurrentData(null);
        Vector2 playerPosition = currentData.getPlayer().getPosition();
        int oldY = playerPosition.getY();
        int speed = currentData.getPlayer().getSpeed();
        KeyboardListener listener = new KeyboardListener(currentData);
        listener.processKey('W');
        listener.processKey('w');
        assertEquals(oldY - speed * 2, playerPosition.getY());
    }

    @Test
    public void KeyPressed_WithInvalidKey_DoesNothing() {
        CurrentData currentData = new CurrentData(null);
        Vector2 playerPosition = currentData.getPlayer().getPosition();
        int oldY = playerPosition.getY();
        KeyboardListener listener = new KeyboardListener(currentData);
        listener.processKey('P');
        assertEquals(oldY, playerPosition.getY());
    }

    @Test
    public void KeyPressed_RKeyPressed_ResetsGame() {
        CurrentData currentData = new CurrentData(null);
        currentData.setGameOver(true);
        KeyboardListener listener = new KeyboardListener(currentData);
        listener.processKey('r');
        boolean actual = currentData.isGameOver();
        assertFalse(actual);
    }
}
