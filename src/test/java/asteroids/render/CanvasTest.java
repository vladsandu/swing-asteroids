package asteroids.render;

import asteroids.state.CurrentData;
import org.junit.Test;

import java.awt.*;

import static org.mockito.Mockito.*;

public class CanvasTest {
    @Test
    public void PaintComponent_WhenCalled_ShowsAllEntities(){
        CurrentData currentData = mock(CurrentData.class);
        Canvas canvas = new Canvas(currentData);
        canvas.paintComponent(mock(Graphics2D.class));
        verify(currentData, times(1)).showEntities(any(IDrawer.class));
    }
}
