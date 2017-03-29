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


    public RiverMenuState(State state,TileTypeCommand tileTypeCommand){
        tempState=0;
        sourceRiver=new SourceRiver();
        normalRiver=new NormalRiver();
        this.tileTypeCommand=tileTypeCommand;
        nextState=new OrientationMenuState(this,tileTypeCommand);
        previousState=state;
    }
//This is bad, need to change if time
    public void nextState(){
        tileTypeCommand.clearTileEdgeList();
        tempState++;
        if(tempState>3){
            tempState=0;
        }

        if(tempState==0){
        }else if(tempState==1){
            tileTypeCommand.setRivers(sourceRiver,0);
        }else if(tempState==2){
           tileTypeCommand.setRivers(normalRiver,0);
           tileTypeCommand.setRivers(normalRiver,2);
        } else if(tempState==3){
            tileTypeCommand.setRivers(normalRiver,5);
            tileTypeCommand.setRivers(normalRiver,1);
            tileTypeCommand.setRivers(normalRiver,3);
        }

    }

    public void previousState(){
        tileTypeCommand.clearTileEdgeList();
            tempState--;
        if(tempState<0){
            tempState=3;
        }
        if(tempState==0){
        }else if(tempState==1){
            tileTypeCommand.setRivers(sourceRiver,0);
        }else if(tempState==2){
            tileTypeCommand.setRivers(normalRiver,0);
            tileTypeCommand.setRivers(normalRiver,2);
        } else if(tempState==3){
            tileTypeCommand.setRivers(normalRiver,1);
            tileTypeCommand.setRivers(normalRiver,3);
            tileTypeCommand.setRivers(normalRiver,5);
        }

    }

    public State back(){
        tileTypeCommand.clearTileEdgeList();
        tempState=0;
        return previousState;
    }

    public State forward(){
        return nextState;
    }
}
