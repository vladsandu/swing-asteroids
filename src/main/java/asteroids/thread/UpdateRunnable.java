package asteroids.thread;

import asteroids.settings.Settings;
import asteroids.state.CurrentData;

import java.util.Random;

public class UpdateRunnable implements Runnable{
    private final CurrentData currentData;
    private int spawnChance;
    private Random random;

    public UpdateRunnable(CurrentData currentData) {
        this.currentData = currentData;
        this.spawnChance = Settings.SPAWN_CHANCE;
        this.random = new Random();
    }

    @Override
    public void run() {
        trySpawnAsteroid();
        currentData.updateAsteroids();
        currentData.cleanAsteroids();
        currentData.checkCollisions();
    }

    private void trySpawnAsteroid() {
        int value = random.nextInt(100);
        if(value <= spawnChance)
            currentData.addAsteroid();
    }

    public void setSpawnChance(int spawnChance) {
        this.spawnChance = spawnChance;
    }
}
