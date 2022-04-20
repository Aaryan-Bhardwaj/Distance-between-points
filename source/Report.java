



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Report implements MouseListener {
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int m=e.getX()-21;
        int n=e.getY()-55;
        Repo.getIns().addPoint(m,y);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
