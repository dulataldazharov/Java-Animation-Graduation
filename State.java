public abstract class State {
    public boolean isOver;
    public boolean isVisible = true;
    public abstract void step(Entity e);
}
