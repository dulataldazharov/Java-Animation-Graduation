
import java.awt.Graphics2D;

public abstract class Entity{
    public String name;
    public Vector2D position;
    public State state;
    public String stateName;
    public Common common;
    public Entity(){
        position = new Vector2D();
        name = new String();
        stateName = new String();
    }
    public abstract void draw(Graphics2D g2d);
    public void step(){
        state.step(this);
    }
}
