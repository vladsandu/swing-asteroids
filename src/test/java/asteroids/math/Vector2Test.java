package asteroids.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2Test {
    @Test
    public void Translate_WhenCalled_TranslatesVector() {
        int x = 10, y = 10, dx = 5, dy = 5;
        Vector2 vector = new Vector2(x, y);
        vector.translate(dx, dy);
        assertEquals(x + dx, vector.getX());
        assertEquals(y + dy, vector.getY());
    }

    @Test
    public void Bound_OutsideBound_SetsToClosestExtremity() {
        Vector2 vector = new Vector2(-2, 0);
        vector.bound(0, 10, 0, 10);
        assertEquals(0, vector.getX());
    }

    @Test
    public void Bound_InsideBound_DoesNothing() {
        Vector2 vector = new Vector2(0, 0);
        vector.bound(0, 10, 0, 10);
        assertEquals(0, vector.getX());
    }
}
