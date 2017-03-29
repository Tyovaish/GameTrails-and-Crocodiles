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
    TileTypeCommand tileTypeCommand;
    State previousState;
    State nextState;
    int tempState;
    public OrientationMenuState(State state, TileTypeCommand tileTypeCommand){
        this.tileTypeCommand=tileTypeCommand;
        orientationList=new ArrayList<TileOrientation>();
        for(int i=0;i<6;i++){
            orientationList.add(new TileOrientation(i));
        }
        tileTypeCommand.setOrientation(orientationList.get(0));
        nextState=this;
        previousState=state;
        tempState=0;
    }
    public void nextState(){
        tempState++;
        if(tempState>5){
            tempState=0;
        }
        tileTypeCommand.setOrientation(orientationList.get(tempState));
    }
    public void previousState(){
        tempState--;
        if(tempState<0){
            tempState=5;
        }
        tileTypeCommand.setOrientation(orientationList.get(tempState));
    }
    public State back(){
        tileTypeCommand.setOrientation(orientationList.get(0));
        tempState=0;
        return previousState;
    }
    public State forward(){
        return nextState;
    }
}

