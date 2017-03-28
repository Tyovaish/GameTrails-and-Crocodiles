package Controller;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/27/2017.
 */
public class FeatureTypeMenuState implements State {
    ArrayList<State> menuStates;
    State previousState;
    int tempState;
    public void nextState(){
        tempState++;
        if(tempState>=menuStates.size()){
            tempState=0;
        }
    }
    public void previousState(){
        tempState--;
        if(tempState<0){
            tempState=menuStates.size()-1;
        }
    }
    public State back(){
        return previousState;
    }
    public State forward(){
        return menuStates.get
    }
    public void execute(){

    }

}
