package asteroids;

import asteroids.asteroid.AsteroidFactory;
import asteroids.render.Canvas;
import asteroids.settings.Settings;
import asteroids.state.CurrentData;
import asteroids.thread.UpdateRunnable;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainRunner
{
    public static void main( String[] args )
    {
        AsteroidFactory factory = new AsteroidFactory();
        CurrentData currentData = new CurrentData(factory);
        Canvas canvas = new Canvas(currentData);
        try {
            createFrame(canvas);
            ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);
            executor.scheduleAtFixedRate((Runnable) () -> {
                EventQueue.invokeLater(canvas::repaint);
            }, 0, 16, TimeUnit.MILLISECONDS);
            executor.scheduleAtFixedRate(new UpdateRunnable(currentData), 0, 16, TimeUnit.MILLISECONDS);
        } catch (InvocationTargetException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void createFrame(JComponent component) throws InvocationTargetException, InterruptedException {
        EventQueue.invokeAndWait(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().add(component);
            f.setSize(Settings.WIDTH, Settings.HEIGHT);
            f.setTitle("I need more sleep...");
            f.setLocationRelativeTo(null);
            f.setResizable(false);
            f.setVisible(true);
        });
    }
}
