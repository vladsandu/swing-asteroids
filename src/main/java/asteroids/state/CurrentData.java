package asteroids.state;

import asteroids.asteroid.Asteroid;
import asteroids.asteroid.AsteroidFactory;
import asteroids.player.Player;
import asteroids.render.IDrawer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CurrentData {
    private final AsteroidFactory factory;
    private final List<Asteroid> asteroids;
    private final Player player;
    private boolean gameOver;

    public CurrentData(){
        this(new AsteroidFactory());
    }

    public CurrentData(AsteroidFactory asteroidFactory) {
        this.factory = asteroidFactory;
        this.asteroids = new CopyOnWriteArrayList<>();
        this.player = new Player();
        resetGame();
    }

    public void addAsteroid() {
        Asteroid asteroid = factory.makeAsteroid();
        asteroids.add(asteroid);
    }

    public void movePlayer(Direction direction) {
        player.move(direction);
    }

    public void updateAsteroids() {
        for(Asteroid asteroid : asteroids)
            asteroid.update();
    }

    public void showEntities(IDrawer drawer) {
        for(Asteroid asteroid : asteroids)
            asteroid.show(drawer);
        player.show(drawer);
    }

    public int getAsteroidCount() {
        return asteroids.size();
    }

    public Player getPlayer() {
        return player;
    }

    public void cleanAsteroids() {
        for(int i = asteroids.size() - 1; i >= 0; i--)
            if(asteroids.get(i).isOffScreen())
                asteroids.remove(i);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void checkCollisions() {
        for(Asteroid asteroid : asteroids){
            if(player.intersects(asteroid)){
                gameOver = true;
                return;
            }
        }
    }

    public void resetGame() {
        gameOver = false;
        asteroids.clear();
    }
}
