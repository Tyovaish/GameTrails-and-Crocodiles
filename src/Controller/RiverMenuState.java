package Controller;

import Model.FeatureTypes.River.River;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/27/2017.
 */
public class RiverMenuState implements State {
    ArrayList<ArrayList<River>> riverList;
    State previousState;
    int tempState;
    public void nextState(){
        tempState++;
        if(tempState>=riverList.size()){
            tempState=0;
        }
    }
    public void previousState(){
        tempState--;
        if(tempState<0){
            tempState=riverList.size()-1;
        }
    }
    public State back(){
        return previousState;
    }
    public State forward(){
        return this;
    }
    public void execute(){

    }
}
