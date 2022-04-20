


import javax.swing.*;
import java.awt.*;

    Main(){
        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        Canvas can=new Canvas();
        Report r=new Report();
        add(can, BorderLayout.CENTER);
        addMouseListener(r);
        Repo.getIns().addObserver(canvas);
    }

    
    public static void main(String[] args){
        new Main();
    }
}
