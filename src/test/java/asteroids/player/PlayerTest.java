package asteroids.player;

import asteroids.asteroid.Asteroid;
import asteroids.math.Vector2;
import asteroids.render.IDrawer;
import asteroids.state.Direction;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerTest {
    @Test
    public void Move_WhenCalled_MovesPlayer() {
        Player player = new Player(new Vector2(0, 0), 5, 3);
        player.move(Direction.DOWN);
        Vector2 position = player.getPosition();
        assertEquals(5, position.getY());
    }

    @Test
    public void Move_PositionOffScreen_DoesNotMove() {
        Player player = new Player(new Vector2(0, 0), 5, 3);
        player.move(Direction.LEFT);
        Vector2 position = player.getPosition();
        assertEquals(0, position.getX());
    }

    @Test
    public void Show_WhenCalled_CallsDrawer() {
        Vector2 position = new Vector2(0, 0);
        Player player = new Player(position, 5, 3);
        IDrawer drawer = mock(IDrawer.class);
        player.show(drawer);
        verify(drawer, times(1)).fillRect(eq(position), eq(player.getSize()), any(Color.class));
    }

    @Test
    public void Intersects_InsideAsteroid_ReturnsTrue() {
        Asteroid asteroid = new Asteroid(new Vector2(10, 10), 10, 10);
        Player player = new Player(new Vector2(10, 10), 10, 10);
        boolean actual = player.intersects(asteroid);
        assertTrue(actual);
    }

    @Test
    public void Intersects_OutsideAsteroid_ReturnsFalse() {
        Asteroid asteroid = new Asteroid(new Vector2(10, 10), 10, 10);
        Player player = new Player(new Vector2(100, 10), 10, 10);
        boolean actual = player.intersects(asteroid);
        assertFalse(actual);
    }
}
