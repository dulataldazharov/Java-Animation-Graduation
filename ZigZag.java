
import java.util.Random;

public class ZigZag extends State {
    int dirX;
    int dirY;
    public ZigZag(){
        super();
        Random rand = new Random();
        int sign = rand.nextInt(2);
        if (sign==0){
            dirX=2;
        }
        else dirX=-2;
        sign = rand.nextInt(2);
        if (sign==0){
            dirY=2;
        }
        else dirY=-2;
    }
    @Override
    public void step(Entity e){
            if (e.position.x<0){
                dirX=2;
            }
            if (e.position.x>=770){
                dirX=-2;
            }
            if (e.position.y<0){
                dirY=2;
            }
            if (e.position.y>=470){
                dirY=-2;
            }
            e.position.x+=dirX;
            e.position.y+=dirY;
    }
}
