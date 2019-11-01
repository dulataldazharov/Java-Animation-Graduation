public class Closest extends State{
    public int x;
    public int y;
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
