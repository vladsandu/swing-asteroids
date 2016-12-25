package asteroids.state;

import asteroids.asteroid.Asteroid;
import asteroids.asteroid.AsteroidFactory;
import asteroids.math.Vector2;
import asteroids.player.Player;
import asteroids.render.IDrawer;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class CurrentDataTest {
    @Test
    public void AddAsteroid_WhenCalled_AddsToList(){
        CurrentData currentData = new CurrentData(new AsteroidFactory());
        int count = currentData.getAsteroidCount();
        assertEquals(0, count);
        currentData.addAsteroid();
        count = currentData.getAsteroidCount();
        assertEquals(1, count);
    }

    @Test
    public void MovePlayer_WhenCalled_MovesPlayer(){
        CurrentData currentData = new CurrentData(null);
        Player player = currentData.getPlayer();
        int speed = player.getSpeed();
        int oldY = player.getPosition().getX();
        currentData.movePlayer(Direction.RIGHT);
        assertEquals(oldY + speed, player.getPosition().getX());
    }

    @Test
    public void UpdateAsteroids_WhenCalled_UpdatesAllAsteroids(){
        AsteroidFactory factory = mock(AsteroidFactory.class);
        Asteroid asteroid1 = mock(Asteroid.class);
        Asteroid asteroid2 = mock(Asteroid.class);
        when(factory.makeAsteroid()).thenReturn(asteroid1, asteroid2);
        CurrentData currentData = new CurrentData(factory);
        currentData.addAsteroid();
        currentData.addAsteroid();
        currentData.updateAsteroids();
        verify(asteroid1, times(1)).update();
        verify(asteroid2, times(1)).update();
    }

    @Test
    public void ShowEntities_WhenCalled_CallsDrawerAppropriateNumberOfTimes(){
        IDrawer drawer = mock(IDrawer.class);
        CurrentData currentData = new CurrentData(new AsteroidFactory());
        for(int i = 0; i < 10; i++)
            currentData.addAsteroid();
        currentData.showEntities(drawer);
        verify(drawer, times(10)).fillCircle(any(Vector2.class), any(Integer.class), any(Color.class));
        verify(drawer, times(1)).fillRect(any(Vector2.class), any(Integer.class), any(Color.class));
    }

    @Test
    public void CleanAsteroids_WhenCalled_RemovesOffScreenAsteroids(){
        AsteroidFactory factory = mock(AsteroidFactory.class);
        Asteroid asteroid1 = mock(Asteroid.class);
        Asteroid asteroid2 = mock(Asteroid.class);
        when(asteroid1.isOffScreen()).thenReturn(true);
        when(asteroid2.isOffScreen()).thenReturn(false);
        when(factory.makeAsteroid()).thenReturn(asteroid1, asteroid2);
        CurrentData currentData = new CurrentData(factory);
        currentData.addAsteroid();
        currentData.addAsteroid();
        assertEquals(2, currentData.getAsteroidCount());
        currentData.cleanAsteroids();
        assertEquals(1, currentData.getAsteroidCount());
    }

    @Test
    public void CheckCollisions_CollisionExists_SetGameOver(){
        AsteroidFactory factory = mock(AsteroidFactory.class);
        CurrentData currentData = new CurrentData(factory);
        Asteroid asteroid1 = new Asteroid(currentData.getPlayer().getPosition(), 10, 10);
        Asteroid asteroid2 = new Asteroid(new Vector2(100, 100), 0, 0);
        when(factory.makeAsteroid()).thenReturn(asteroid1, asteroid2);
        assertFalse(currentData.isGameOver());
        currentData.addAsteroid();
        currentData.addAsteroid();
        currentData.checkCollisions();
        assertTrue(currentData.isGameOver());
    }

    @Test
    public void CheckCollisions_NoCollision_DoesNothing(){
        CurrentData currentData = new CurrentData(new AsteroidFactory());
        currentData.checkCollisions();
        assertFalse(currentData.isGameOver());
    }
}
