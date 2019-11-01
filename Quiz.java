import java.awt.*;

public class Quiz extends Assessment{
    public Quiz(){
        super();
    }
    @Override
    public void draw(Graphics2D g2d){
        int x = (int) position.x;
        int y = (int) position.y;
        g2d.setPaint(Color.blue);
        Polygon poly = new Polygon(
                new int[]{x, x+10, x+20},
                new int[]{y+20, y, y+20},
                3);
        g2d.fill(poly);
        Integer pnts = points;
        g2d.setPaint(Color.BLACK);
        g2d.drawString(pnts.toString(), x+6, y+16);
    }
}
