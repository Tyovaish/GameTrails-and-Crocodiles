package Controller;

import Controller.Commands.RemoveCommand;
import Controller.Commands.TilePlacementCommand;
import Controller.Commands.TileTypeCommand;
import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.Sea.Sea;
import Model.Tile.FeatureTypes.Terrain.*;
import com.sun.org.apache.xalan.internal.utils.FeatureManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/27/2017.
 */
public class FeatureTypeMenuState implements State {
    ArrayList<FeatureType> featureTypeList;
    TileTypeCommand tileTypeCommand;
    State previousState;
    State nextState;
    int tempState;
    public FeatureTypeMenuState(State state,TilePlacementCommand  tilePlacementCommand, TileTypeCommand tileTypeCommand){
        featureTypeList.add(new Desert());
        featureTypeList.add(new Mountain());
        featureTypeList.add(new Pasture());
        featureTypeList.add(new Rock());
        featureTypeList.add(new Woods());
        featureTypeList.add(new Sea());
        this.tileTypeCommand=tileTypeCommand;
        nextState=new RiverMenuState(this,tilePlacementCommand,tileTypeCommand);
        previousState=state;
    }
    public void nextState(){
        tempState++;
        if(tempState>=featureTypeList.size()){
            tempState=0;
        }
        tileTypeCommand.setFeatureType(featureTypeList.get(tempState));
    }
    public void previousState(){
        tempState--;
        if(tempState<0){
            tempState=featureTypeList.size()-1;
        }
        tileTypeCommand.setFeatureType(featureTypeList.get(tempState));
    }
    public State back(){
        return previousState;
    }
    public State forward(){
        if(tileTypeCommand.getFeatureType().equals(new Sea())) {
            return nextState;
        }
        return this;
    }

}
