package Controller;


import Controller.Commands.TilePlacementCommand;
import Controller.Commands.TileTypeCommand;
import Model.Tile.FeatureTypes.River.NormalRiver;
import Model.Tile.FeatureTypes.River.River;
import Model.Tile.FeatureTypes.River.SourceRiver;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/27/2017.
 */
public class RiverMenuState implements State {
    final int maxAmountOfRivers=3;
    ArrayList<ArrayList<River>> riverList;
    TileTypeCommand tileTypeCommand;
    State previousState;
    State nextState;
    int tempState;
    public RiverMenuState(State state, TilePlacementCommand tilePlacementCommand, TileTypeCommand tileTypeCommand){
        for(int i=0;i<=maxAmountOfRivers;i++){
            ArrayList<River> tempRiver=new ArrayList<River>();
            if(i!=1) {
                for (int j = 0; j < i; j++) {
                    tempRiver.add(new NormalRiver());
                }
            } else {
                tempRiver.add(new SourceRiver());
            }
            riverList.add(tempRiver);
        }
        this.tileTypeCommand=tileTypeCommand;
        nextState=new OrientationMenuState(this,tilePlacementCommand);
        previousState=state;
    }
    public void nextState(){
        tempState++;
        if(tempState>=riverList.size()){
            tempState=0;
        }
        tileTypeCommand.setRivers(riverList.get(tempState));
    }
    public void previousState(){
        tempState--;
        if(tempState<0){
            tempState=riverList.size()-1;
        }
        tileTypeCommand.setRivers(riverList.get(tempState));
    }
    public State back(){
        return previousState;
    }
    public State forward(){
        return nextState;
    }
}
