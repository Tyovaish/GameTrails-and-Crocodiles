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
    SourceRiver sourceRiver;
    NormalRiver normalRiver;
    TileTypeCommand tileTypeCommand;
    State previousState;
    State nextState;
    int tempState;
    int riverPositionCounter;

    public RiverMenuState(State state, TilePlacementCommand tilePlacementCommand, TileTypeCommand tileTypeCommand){
        tempState=0;
        sourceRiver=new SourceRiver();
        normalRiver=new NormalRiver();
        this.tileTypeCommand=tileTypeCommand;
        nextState=new OrientationMenuState(this,tilePlacementCommand);
        previousState=state;
    }
//This is bad, need to change if time
    public void nextState(){
        tempState++;
        if(tempState>3){
            tempState=0;
        }
        if(tempState==0){
            tileTypeCommand.clearTileEdgeList();
            return;
        }else if(tempState==1){
            tileTypeCommand.setTileEdge(sourceRiver,0);
            tempState++;
            return;
        }else if(tempState==2&&riverPositionCounter<=3){
            tileTypeCommand.setTileEdge(normalRiver,0);
            tileTypeCommand.setTileEdge(normalRiver,riverPositionCounter);
            riverPositionCounter++;
            return;
        } else if(tempState==3){
            tileTypeCommand.setTileEdge(normalRiver,5);
            tileTypeCommand.setTileEdge(normalRiver,1);
            tileTypeCommand.setTileEdge(normalRiver,3);
        }
        riverPositionCounter=0;
    }

    public void previousState(){
        tempState--;
        if(tempState<0){
            tempState=3;
        }
        if(tempState==0){
            tileTypeCommand.clearTileEdgeList();
            return;
        }else if(tempState==1){
            tileTypeCommand.setTileEdge(sourceRiver,0);
            tempState++;
        }else if(tempState==2&&riverPositionCounter>=0){
            tileTypeCommand.setTileEdge(normalRiver,0);
            tileTypeCommand.setTileEdge(normalRiver,riverPositionCounter);
            riverPositionCounter--;
            return;
        } else if(tempState==3){
            tileTypeCommand.setTileEdge(normalRiver,5);
            tileTypeCommand.setTileEdge(normalRiver,1);
            tileTypeCommand.setTileEdge(normalRiver,3);
        }
        riverPositionCounter=3;
    }

    public State back(){
        tileTypeCommand.clearTileEdgeList();
        tempState=0;
        riverPositionCounter=0;
        return previousState;
    }

    public State forward(){
        return nextState;
    }
}
