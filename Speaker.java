import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Speaker extends Entity{
    public boolean isVisible;
    public Speaker(){
        super();
        isVisible = false;
    }
    @Override
    public void draw(Graphics2D g2d){
        if (isVisible==true){
            String pathTokayev="KassymJomartTokayev.gif";
            String pathNazarbayev="NursultanNazarbayev.gif";
            String filepath;
            if (name.equals("Tokayev"))
                filepath = pathTokayev;
            else 
                filepath = pathNazarbayev;
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(filepath));
            } catch (IOException ex) {
                Logger.getLogger(Speaker.class.getName()).log(Level.SEVERE, null, ex);
            }
            g2d.drawImage(img, (int) this.position.x, (int) this.position.y, 40, 50, null);
            g2d.drawString(this.name, (int) this.position.x-6, (int) this.position.y-5);   
        }
    };
}
