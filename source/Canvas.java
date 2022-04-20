


import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        Stack<Point> points= Repo.getIns().getPoints();
        for (Point point : points) {
            long m = (int) point.getX();
            long n = (int) point.getY();
            g.fillOval(m, n, 20, 20);
        }
        Stack<Line> lines=Repo.getInstance().getLines();
        for (Line line : lines) {
            Point pointX = line.getStart();
            Point pointY = line.getEnd();
            g.drawLine((int) pointX.getX(), (int) pointX.getY(), (int) pointY.getX(), (int) pointY.getY());
        }
    }

    
    @Override
    public void update(Observable o, Object arg) {
        final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable= this::repaint;
        worker.schedule(runnable, 500, TimeUnit.MILLISECONDS);
    }
}
