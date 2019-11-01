import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.JPanel;

public class Display extends JPanel{
    public Common common;
    public Display(){
        super();
        common = new Common();
    }
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(800, 500);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        common.drawAllEntities(g2d);
        common.stepAllEntities();
    }
}
