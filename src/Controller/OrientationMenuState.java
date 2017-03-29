package Controller;

import Controller.Commands.TilePlacementCommand;
import Controller.Commands.TileTypeCommand;
import Model.Tile.TileOrientation;
import javafx.geometry.Orientation;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/27/2017.
 */
public class OrientationMenuState implements State {
    ArrayList<TileOrientation> orientationList;
    TilePlacementCommand tilePlacementCommand;
    State previousState;
    State nextState;
    int tempState;
    public OrientationMenuState(State state, TilePlacementCommand tilePlacementCommand){
        this.tilePlacementCommand=tilePlacementCommand;
        orientationList=new ArrayList<TileOrientation>();
        for(int i=0;i<6;i++){
            orientationList.add(new TileOrientation(i));
        }
        nextState=this;
        previousState=state;
        tempState=0;
    }
    public void nextState(){
        tempState++;
        if(tempState>=orientationList.size()){
            tempState=0;
        }
        tilePlacementCommand.setOrientation(orientationList.get(tempState));
    }
    public void previousState(){
        tempState--;
        if(tempState<0){
            tempState=orientationList.size()-1;
        }
        tilePlacementCommand.setOrientation(orientationList.get(tempState));
    }
    public State back(){
        tilePlacementCommand.setOrientation(orientationList.get(0));
        tempState=0;
        return previousState;
    }
    public State forward(){
        return nextState;
    }
}

