

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;
public class Knowledge implements Observer {
    
    private float dist_btw_points(float m1, float n1, float m2, float n2) {
        return Math.sqrt((Math.abs(n1 - n2) * Math.abs(n1 - n2)) + (Math.abs(m1 - m2) * Math.abs(m1 - m2)));
    }

    
    private Point closest_point(Point curr, Stack<Point> points){
        float distance=99999;
        Point closest=null;
        for(int i=0;i<points.size()-1;i++){
            float temp= dist_btw_points(curr.getX(),curr.getY(),points.get(i).getX(),points.get(i).getY());
            if (temp<distance){
                distance=temp;
                closest=points.get(i);
            }
        }
        return closest;
    }

    
    @Override
    public void update(Observable o, Object arg) {
        Stack<Point> points=Repository.getInstance().getPoints();
        if(points.size()>1){
            Point closest_point=closest_point(points.peek(),points);
            Repo.getIns().addLine(points.peek(),closest_point);
        }
    }
}