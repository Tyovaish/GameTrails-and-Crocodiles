package Controller;

import Controller.Commands.RemoveCommand;
import Controller.Commands.TilePlacementCommand;
import Controller.Commands.TileTypeCommand;
import GUI.Display;
import Model.Location;
import Model.Map;
import Model.Tile.TileBuilder;
import Model.TileCommandDispatcher;
import Model.TilePlacementManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/26/2017.
 */
public class Controller implements State{
    private TileCommandDispatcher tileCommandDispatcher;
    private ArrayList<State> menuStates;
    private TilePlacementCommand tilePlacementCommand;
    private TileTypeCommand tileTypeCommand;
    private RemoveCommand removeCommand;
    private State currentState;
    int tempState;


    public Controller(Map map){
        this.tileCommandDispatcher=new TileCommandDispatcher(new TileBuilder(), new TilePlacementManager(map));
        this.tileTypeCommand=new TileTypeCommand();
        this.removeCommand=new RemoveCommand();
        this.tilePlacementCommand=new TilePlacementCommand();
        this.menuStates.add(new FeatureTypeMenuState(this,tilePlacementCommand,tileTypeCommand));
        this.currentState=menuStates.get(0);
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
        currentState=currentState.forward();
        } else {
            currentState=menuStates.get(tempState);
        }
        return null;
    }
    public void onLeftClick(int x,int y){
        tilePlacementCommand.setLocation(new Location(x,y));
        tileCommandDispatcher.addNewTile(tileTypeCommand, tilePlacementCommand);
        tileTypeCommand.clearTileEdgeList();
        tileTypeCommand.clearFeatureType();
        tileTypeCommand.clearOrientation();
    }
    public void onRightClick(int x, int y){
        removeCommand.setLocation(new Location(x,y));
        tileCommandDispatcher.removeTile(removeCommand);
    }
    //TODO Maybe
    public void displayTile(){

    }

}
