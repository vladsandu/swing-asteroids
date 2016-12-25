package asteroids.render;

import asteroids.math.Vector2;
import org.junit.Test;

import java.awt.*;
import static org.mockito.Mockito.*;

public class DrawerTest {
    @Test
    public void DrawRect_WhenCalled_CallsGraphicsWithProperData(){
        Graphics2D graphics = mock(Graphics2D.class);
        Drawer drawer = new Drawer(graphics);
        drawer.fillRect(new Vector2(0,0), 10, Color.BLACK);
        verify(graphics, times(1)).setColor(Color.BLACK);
        verify(graphics, times(1)).fillRect(0, 0, 10, 10);
    }

    @Test
    public void DrawCircle_WhenCalled_CallsGraphicsWithProperData(){
        Graphics2D graphics = mock(Graphics2D.class);
        Drawer drawer = new Drawer(graphics);
        drawer.fillCircle(new Vector2(0,0), 10, Color.BLACK);
        verify(graphics, times(1)).setColor(Color.BLACK);
        verify(graphics, times(1)).fillOval(0, 0, 10, 10);
    }
}
