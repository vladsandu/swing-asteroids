package asteroids.player;

import asteroids.math.Vector2;
import asteroids.render.IDrawer;
import asteroids.state.Direction;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PlayerTest {
    @Test
    public void Move_WhenCalled_MovesPlayer(){
        Player player = new Player(new Vector2(0, 0), 5, 3);
        player.move(Direction.UP);
        Vector2 position = player.getPosition();
        assertEquals(-5, position.getY());
    }

    @Test
    public void Show_WhenCalled_CallsDrawer(){
        Vector2 position = new Vector2(0, 0);
        Player player = new Player(position, 5, 3);
        IDrawer drawer = mock(IDrawer.class);
        player.show(drawer);
        verify(drawer, times(1)).fillRect(eq(position), eq(player.getSize()), any(Color.class));
    }
}
