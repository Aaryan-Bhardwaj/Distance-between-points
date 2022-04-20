

import java.awt.*;

public class Line {
    Point start;
    Point end;

    
    public Point getStart() {
        return start;
    }

    
    public Point getEnd() {
        return end;
    }

    
    public Line(Point start, Point end) {
        this.start = new Point(start);
        this.end = new Point(end);
    }
}