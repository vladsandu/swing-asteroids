package asteroids.asteroid;

import asteroids.math.Vector2;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class AsteroidFactoryTest {
    @Test
    public void MakeAsteroid_WhenCalled_MakesAsteroid() {
        AsteroidFactory factory = new AsteroidFactory();
        Asteroid asteroid = factory.makeAsteroid();
        assertNotNull(asteroid);
    }

    @Test
    public void MakeAsteroid_WhenCalled_SetsYOutsideScreen() {
        AsteroidFactory factory = new AsteroidFactory();
        Asteroid asteroid = factory.makeAsteroid();
        Vector2 actualPosition = asteroid.getPosition();
        assertTrue(actualPosition.getY() < 0);
    }

    @Test
    public void MakeAsteroid_WhenCalled_SetsRandomValues() {
        Random random = mock(Random.class);
        AsteroidFactory factory = new AsteroidFactory(random);
        factory.setxMaxBound(10);
        factory.setSizeMaxBound(10);
        factory.setSpeedMaxBound(5);
        factory.setSizeMinBound(1);
        factory.setSpeedMinBound(1);
        when(random.nextInt(factory.getxMaxBound())).thenReturn(1);
        when(random.nextInt(factory.getSizeMaxBound() - factory.getSizeMinBound())).thenReturn(5);
        when(random.nextInt(factory.getSpeedMaxBound() - factory.getSpeedMinBound())).thenReturn(3);

        Asteroid asteroid = factory.makeAsteroid();

        Vector2 actualPosition = asteroid.getPosition();
        assertEquals(1, actualPosition.getX());
        assertEquals(factory.getSizeMinBound() + 5, asteroid.getSize());
        assertEquals(factory.getSpeedMinBound() + 3, asteroid.getSpeed());
    }

}
