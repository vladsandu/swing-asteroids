package asteroids.asteroid;

import asteroids.math.Vector2;
import asteroids.player.Player;
import asteroids.render.IDrawer;
import asteroids.settings.Settings;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AsteroidTest {
    @Test
    public void Update_WhenCalled_UpdatesPositionBySpeed(){
        int x = 10, y = 10, speed = 5;
        Asteroid asteroid = new Asteroid(new Vector2(x, y), speed, 0);
        asteroid.update();
        Vector2 actualPosition = asteroid.getPosition();
        assertEquals(x, actualPosition.getX());
        assertEquals(y + speed, actualPosition.getY());
    }

    @Test
    public void Show_WhenCalled_CallsDrawer(){
        Vector2 position = new Vector2(0, 0);
        Asteroid asteroid = new Asteroid(position, 5, 3);
        IDrawer drawer = mock(IDrawer.class);
        asteroid.show(drawer);
        verify(drawer, times(1)).fillCircle(eq(position), eq(asteroid.getSize()), any(Color.class));
    }

    @Test
    public void IsOffScreen_IsAboveScreen_ReturnsFalse(){
        Asteroid asteroid = new Asteroid(new Vector2(0, -1), 10, 10);
        boolean actual = asteroid.isOffScreen();
        assertFalse(actual);
    }

    @Test
    public void IsOffScreen_IsBelowScreen_ReturnsTrue(){
        Asteroid asteroid = new Asteroid(new Vector2(0, Settings.HEIGHT + 1), 10, 10);
        boolean actual = asteroid.isOffScreen();
        assertTrue(actual);
    }
}
