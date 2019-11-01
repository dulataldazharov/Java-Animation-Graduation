public class GotoXY extends State{
    public double x;
    public double y;
    @Override
    public void step(Entity e){
        if (x>e.position.x){
            e.position.x++;
        }
        if (x<e.position.x){
            e.position.x--;
        }
        if (y>e.position.y){
            e.position.y++;
        }
        if (y<e.position.y){
            e.position.y--;
        }
    }
}
