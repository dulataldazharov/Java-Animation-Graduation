import java.util.Random;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
public class Academician extends Entity{
    public Academician(){
        super();
    }
    @Override
    public void draw(Graphics2D g2d){
        String pathTemizer="SelimTemizer.gif";
        String pathKatsu="ShigeoKatsu.gif";
        String pathNeville="HansDeNivelle.gif";
        String pathTourassis="VassiliosTourassis.gif";
        String filepath = "";
        switch (name) {
            case "Temizer":
                filepath = pathTemizer;
                break;
            case "Katsu":
                filepath = pathKatsu;
                break;
            case "Neville":
                filepath = pathNeville;
                break;
            case "Tourassis":
                filepath = pathTourassis;
                break;
        }
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File (filepath));
        } catch (IOException ex) {
            Logger.getLogger(Academician.class.getName()).log(Level.SEVERE, null, ex);
        }
        g2d.drawImage(img, (int) this.position.x, (int) this.position.y, 40, 50, null);
        if (name.equals("Tourassis")){
         g2d.drawString(this.name, (int) this.position.x-6, (int) this.position.y-5);   
        }
        else if (name.equals("Katsu")){
            g2d.drawString(this.name, (int) this.position.x+3, (int) this.position.y-5);
        }
        else g2d.drawString(this.name, (int) this.position.x, (int) this.position.y-5);
        if (stateName.equals("Rest")){
            g2d.drawString(this.stateName, (int) this.position.x+10, (int) this.position.y+63);
        }
        else g2d.drawString(this.stateName, (int) this.position.x, (int) this.position.y+63);
    }
    public Assessment createAssessment(){
        Random rand = new Random();
        int num = rand.nextInt(3);
        int x = rand.nextInt(100);
        int y = rand.nextInt(100);
        x-=50;
        y-=50;
        Vector2D newPosition = new Vector2D();
        newPosition.x+=this.position.x+x;
        newPosition.y+=this.position.y+y;
        if (num==0){
            LabFactory factory = new LabFactory();
            return factory.createAssessment(newPosition);
        }
        if (num==1){
            QuizFactory factory = new QuizFactory();
            return factory.createAssessment(newPosition);
        }
        HomeworkFactory factory = new HomeworkFactory();
        return factory.createAssessment(newPosition);
    }
}
