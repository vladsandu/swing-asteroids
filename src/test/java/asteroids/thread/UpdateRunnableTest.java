package asteroids.thread;

import asteroids.asteroid.Asteroid;
import asteroids.asteroid.AsteroidFactory;
import asteroids.state.CurrentData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UpdateRunnableTest {
    @Test
    public void Run_MaxSpawnChance_AddsAsteroid(){
        CurrentData currentData = new CurrentData(new AsteroidFactory());
        UpdateRunnable updater = new UpdateRunnable(currentData);
        updater.setSpawnChance(100);
        assertEquals(0, currentData.getAsteroidCount());
        updater.run();
        assertEquals(1, currentData.getAsteroidCount());
    }

    @Test
    public void Run_WhenCalled_UpdatesAsteroids(){
        Asteroid asteroid = mock(Asteroid.class);
        AsteroidFactory factory = mock(AsteroidFactory.class);
        when(factory.makeAsteroid()).thenReturn(asteroid);
        CurrentData currentData = new CurrentData(factory);
        currentData.addAsteroid();
        UpdateRunnable updater = new UpdateRunnable(currentData);

        updater.run();

        verify(asteroid, times(1)).update();
    }

    @Test
    public void Run_WhenCalled_CleansAsteroids(){
        CurrentData currentData = mock(CurrentData.class);
        UpdateRunnable updater = new UpdateRunnable(currentData);

        updater.run();

        verify(currentData, times(1)).cleanAsteroids();
    }
}
