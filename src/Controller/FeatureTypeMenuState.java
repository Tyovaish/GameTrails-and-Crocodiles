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
    public FeatureTypeMenuState(State state,TileTypeCommand tileTypeCommand){
        tempState=0;
        featureTypeList=new ArrayList<FeatureType>();
        featureTypeList.add(new Desert());
        featureTypeList.add(new Mountain());
        featureTypeList.add(new Pasture());
        featureTypeList.add(new Rock());
        featureTypeList.add(new Woods());
        featureTypeList.add(new Sea());
        this.tileTypeCommand=tileTypeCommand;
        tileTypeCommand.setFeatureType(featureTypeList.get(0));
        nextState=new RiverMenuState(this,tileTypeCommand);
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
        tileTypeCommand.setFeatureType(featureTypeList.get(0));
        tempState=0;
        return this;
    }
    public State forward(){
        if(tileTypeCommand.getFeatureType().equals(new Sea())) {
            return this;
        }
        return nextState;
    }

}
