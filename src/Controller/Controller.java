package Controller;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/26/2017.
 */
public class Controller implements State{
ArrayList<State> menuStates;
//TilePlacementCommand tilePlacementCommand;
//SeaTileTypeCommand  seaTileTypeCommand;
//GroundTileTypeCommand groundTileTypeCommand;
State currentState;
int tempState;
Controller(){
    menuStates.add(new FeatureTypeMenuState());
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
public void execute(){
    if(currentState!=this) {
        currentState.execute();
    }
}

}
