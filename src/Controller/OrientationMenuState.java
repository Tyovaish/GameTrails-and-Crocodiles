package Controller;

import Model.FeatureTypes.River.River;
import Model.Tile.TileOrientation;
import javafx.geometry.Orientation;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/27/2017.
 */
public class OrientationMenuState implements State {
    TileOrientation orientation;
    State previousState;
    int tempState;
    public void nextState(){
        orientation.rotate(60);
    }
    public void previousState(){
        orientation.rotate(-60);
    }
    public State back(){
        return previousState;
    }
    public State forward(){
        return this;
    }
    public void execute(){

    }
}

