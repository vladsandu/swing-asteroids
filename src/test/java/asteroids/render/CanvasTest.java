package asteroids.render;

import asteroids.state.CurrentData;
import org.junit.Test;

import java.awt.*;

import static org.mockito.Mockito.*;

public class CanvasTest {
    @Test
    public void PaintComponent_NoGameOver_ShowsAllEntities(){
        CurrentData currentData = mock(CurrentData.class);
        when(currentData.isGameOver()).thenReturn(false);
        Canvas canvas = new Canvas(currentData);
        canvas.paintComponent(mock(Graphics2D.class));
        verify(currentData, times(1)).showEntities(any(IDrawer.class));
    }

    @Test
    public void PaintComponent_GameOver_ShowsAllEntities(){
        CurrentData currentData = mock(CurrentData.class);
        when(currentData.isGameOver()).thenReturn(true);
        Canvas canvas = new Canvas(currentData);
        Graphics2D graphicsMock = mock(Graphics2D.class);
        when(graphicsMock.getFontMetrics(any(Font.class))).thenReturn(mock(FontMetrics.class));
        canvas.paintComponent(graphicsMock);
        verify(currentData, times(0)).showEntities(any(IDrawer.class));
    }
}
