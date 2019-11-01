import java.awt.*;

public class Student extends Entity{
    public int grade;
    public Student(){
        super();
        grade = 0;
    }
    @Override
    public void draw(Graphics2D g2d){
        int x = (int) position.x;
        int y = (int) position.y;
        Color lightBlue = new Color(153, 225, 255);
        if (grade<100)
            g2d.setPaint(lightBlue);
        else
            g2d.setPaint(Color.pink);
        g2d.fillOval(x, y, 40, 40);
        g2d.setPaint(Color.BLACK);
        g2d.drawString(this.name, x+5, y-6); 
        Integer grd = grade;
        g2d.drawString(grd.toString(), x+15, y+25);
        g2d.drawString(this.stateName, (int) this.position.x, (int) this.position.y+50);
    }
}
