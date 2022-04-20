


public class Repo extends Observable {

    private static Repo repo;
    HashMap<Point,Integer> map=new HashMap();
    Stack<Point> points=new Stack<>();
    Stack<Line> lines=new Stack<>();

    
    public static Repo getInstance() {
        if (repo==null){
            repo=new Repo();
            Knowledge ks=new Knowledge();
            Control cont=new Control();
            repo.addObserver(ks);
            repo.addObserver(cont);
        }
        return repository;
    }
    public HashMap<Point, Integer> getMap() {
        return map;
    }

    
    public Stack<Point> getPoints() {
        return points;
    }

    
    public Stack<Line> getLines() { return lines; }

    
    public void addLine(Point m,Point n){
        lines.push(new Line(a,b));
        map.merge(m, 1, Integer::sum);
        map.merge(n, 1, Integer::sum);
    }

    
    public void addPoint(int m,int n){
        points.push(new Point(m,n));
        setChanged();
        notifyObservers();
    }
}
