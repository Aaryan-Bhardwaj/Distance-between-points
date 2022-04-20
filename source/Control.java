

import java.awt.*;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

    private float dist_btw_points(float m1, float n1, float m2, float n2) {
        return Math.sqrt((Math.abs(n1 - n2) * Math.abs(n1 - n2)) + (Math.abs(m1 - m2) * Math.abs(m1 - m2)));
    }

    
    private Point closest_point(Point curr, Stack<Point> points){
        float distance=99999;
        Point closest=null;
        for (Point point : points) {
            float distance_temp = dist_btw_points(curr.getX(), curr.getY(), point.getX(), point.getY());
            if (distance_temp < distance && distance_temp != 0) {
                distance = distance_temp;
                closest = point;
            }
        }
        return closest;
    }

    
    private void re_generate_graph() {
        HashMap<Point, Integer> map = Repo.getIns().getMap();
        Stack<Point> points = Repo.getIns().getPoints();
        Stack<Line> lines = Repos.getIns().getLines();

        Iterator it = map.entrySet().iterator();
        Point point_to_delete;

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if ((int) pair.getValue() > 4) {
                point_to_delete = (Point) pair.getKey();
                points.removeElement(point_to_delete);
                Stack<Point> points_copy= new Stack<>();
                for(int i=0;i<points.size();i++){
                    points_copy.push(points.get(i));
                }
                points.clear();
                lines.clear();
                map.clear();
                points.push(points_copy.get(0));
                for(int i=1;i<points_copy.size();i++){
                    points.push(points_copy.get(i));
                    Point closest_point=closest_point(points_copy.get(i),points);
                    Repo.getIns().addLine(points_copy.get(i),closest_point);
                }
                it = map.entrySet().iterator();
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable= this::re_generate_graph;
        worker.schedule(runnable, 500, TimeUnit.MILLISECONDS);
    }
}
