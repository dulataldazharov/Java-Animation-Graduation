import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class UniversityMap extends Entity{
    @Override
    public void draw(Graphics2D g2d){
        String filepath="NUMap-Faded.jpg";
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filepath));
        } catch (IOException ex) {
            Logger.getLogger(UniversityMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        g2d.drawImage(img, 0, 0, 800, 500, null);
    }
}
