package Controller;

/**
 * Created by Trevor on 3/26/2017.
 */
public interface State {
    public void nextState();
    public void previousState();
    public State back();
    public State forward();
}
