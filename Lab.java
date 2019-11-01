import java.awt.*;

public class Lab extends Assessment{
    public Lab(){
        super();
    }
    @Override
    public void draw(Graphics2D g2d){
        int x=(int)position.x;
        int y=(int)position.y;
        g2d.setPaint(Color.RED);
        g2d.fillOval(x, y, 20, 20);
        Integer pnts = points;
        g2d.setPaint(Color.BLACK);
        g2d.drawString(pnts.toString(), x+8, y+14);
    }
}
