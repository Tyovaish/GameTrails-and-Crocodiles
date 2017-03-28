package Controller;

import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.Terrain.Terrain;
import com.sun.org.apache.xalan.internal.utils.FeatureManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/27/2017.
 */
public class FeatureTypeMenuState implements State {
    ArrayList<FeatureType> featureTypeList;
    State previousState;
    State nextState;
    int tempState;
    public void nextState(){
        tempState++;
        if(tempState>=featureTypeList.size()){
            tempState=0;
        }
    }
    public void previousState(){
        tempState--;
        if(tempState<0){
            tempState=featureTypeList.size()-1;
        }
    }
    public State back(){
        return previousState;
    }
    public State forward(){
        if(true) {
            return nextState;
        }
        return this;
    }
    public void execute(){

    }

}
