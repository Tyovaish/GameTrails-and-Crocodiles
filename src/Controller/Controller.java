package Controller;

import Controller.Commands.RemoveCommand;
import Controller.Commands.TilePlacementCommand;
import Controller.Commands.TileTypeCommand;
import GUI.Display;
import Model.Location;
import Model.Map;
import Model.TilePlacementManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/26/2017.
 */
public class Controller implements State{
TilePlacementManager tilePlacementManager;
ArrayList<State> menuStates;
TilePlacementCommand tilePlacementCommand;
TileTypeCommand tileTypeCommand;
RemoveCommand removeCommand;
State currentState;
int tempState;

public Controller(Map map){
    tilePlacementManager=new TilePlacementManager(map);
    tileTypeCommand=new TileTypeCommand();
    removeCommand=new RemoveCommand();
    tilePlacementCommand=new TilePlacementCommand();
    menuStates=new ArrayList<State>();
    menuStates.add(new FeatureTypeMenuState(this,tileTypeCommand));
    currentState=menuStates.get(0);
    tempState=0;
}
public void nextState(){
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
public void previousState(){
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
public State back(){
    if(currentState!=this) {
        currentState = currentState.back();
    } else {
        currentState=this;
    }
    return null;
}
public State forward(){
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
    tileTypeCommand.clearFeatureType();
}
public void onRightClick(int x, int y){
    removeCommand.setLocation(new Location(x,y));
    tilePlacementManager.execute(removeCommand);
}
//TODO Maybe
public void displayTile(){

}

}
