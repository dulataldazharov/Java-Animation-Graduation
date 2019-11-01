import java.awt.*;

public class Homework extends Assessment{
    public Homework(){
        super();
    }
    @Override
    public void draw(Graphics2D g2d){
        int x = (int) position.x;
        int y = (int) position.y;
        g2d.setPaint(Color.GREEN);
        g2d.fillRect(x, (int) y, 20, 20);
        Integer pnts = points;
        g2d.setPaint(Color.BLACK);
        g2d.drawString(pnts.toString(), x+7, y+14);
    }
}
