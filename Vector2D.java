public class Vector2D {
    public double x;
    public double y;
    public void set(Vector2D v){
        x=v.x;
        y=v.y;
    }
    public double distanceTo(Vector2D other){
        double horizontalDifference = x-other.x;
        double verticalDifference = y-other.y;
        return Math.sqrt(horizontalDifference*horizontalDifference+verticalDifference*verticalDifference);
    }
    public Vector2D plus(Vector2D other){
        Vector2D result = new Vector2D();
        result.x = x+other.x;
        result.y = y+other.y;
        return result;
    }
    public Vector2D minus(Vector2D other){
        Vector2D result = new Vector2D();
        result.x=x-other.x;
        result.y=y-other.y;
        return result;
    }
}
