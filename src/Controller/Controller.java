package Controller;

import Controller.Commands.RemoveCommand;
import Controller.Commands.TilePlacementCommand;
import Controller.Commands.TileTypeCommand;
import Model.Location;
import Model.Map;
import Model.TilePlacementManager;


import java.util.ArrayList;

/**
 * Created by Trevor on 3/26/2017.
 */
public class Controller implements State{
    private ArrayList<State> menuStates;
    private TilePlacementCommand tilePlacementCommand;
    private TileTypeCommand tileTypeCommand;
    private TilePlacementManager tilePlacementManager;
    private RemoveCommand removeCommand;
    private State currentState;
    private int tempState;

public Controller(Map map){
    this.tilePlacementManager=new TilePlacementManager(map);
    tileTypeCommand=new TileTypeCommand();
    removeCommand=new RemoveCommand();
    tilePlacementCommand=new TilePlacementCommand();
    menuStates=new ArrayList<State>();
    menuStates.add(new FeatureTypeMenuState(this,tileTypeCommand));
    currentState=menuStates.get(0);
    tempState=0;
}
public void nextState(){ // FORWARD SELECTING FEATURE TYPE/ RIVERS TYPES /ORIENTATION
    if(currentState!=this) {
        currentState.nextState();
    } else {
        tempState++;
        if(tempState>=menuStates.size()){
            tempState=0;
        }
    }
    tileTypeCommand.print();
}
public String getType(){return tileTypeCommand.getFeatureType().getType();}
public int getOrientation(){return tileTypeCommand.getOrientation().getRotations();}
public int getNumberOfRivers(){return tileTypeCommand.getNumberOfRivers();}
public void previousState(){ //BACKWARDS SELECTING FEATURES TYPES / RIVERS TYPES / ORIENTATION
    if(currentState!=this) {
        currentState.previousState();
    } else {
        tempState--;
        if(tempState<0){
            tempState=menuStates.size()-1;
        }
    }
    tileTypeCommand.print();
}
public State back(){ //GOING FROM RIVER TYPE TO FEATURE or FEATURE TYPE TO ITSELF
    if(currentState!=this) {
        currentState = currentState.back();
    } else {
        currentState=this;
    }
    return null;
}
public State forward(){ //GOING FROM FEATURE TYPE TO FEATURE RIVER TO ORIENTATION
    if(currentState!=this){
        System.out.println("Trying to go farther");
    currentState=currentState.forward();
    } else {
        currentState=menuStates.get(tempState);
    }
    return null;
}
public void onLeftClick(int x,int y){
    tilePlacementCommand.setLocation(new Location(x,y));
    tilePlacementManager.execute(tilePlacementCommand,tileTypeCommand);
    tileTypeCommand.clearTileEdgeList();
    tileTypeCommand.clearOrientation();
    currentState=menuStates.get(0);

}
public void onRightClick(int x, int y){
    removeCommand.setLocation(new Location(x,y));
    tilePlacementManager.execute(removeCommand);
}
//TODO Maybe
public void displayTile(){

}

}
