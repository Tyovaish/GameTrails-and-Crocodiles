package Controller.Commands;

import Model.Location;
import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.River;
import Model.TilePlacementManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/28/2017.
 */
public class RemoveCommand implements Command {
    TilePlacementManager tilePlacementManager;
   Location location;
   RemoveCommand(){
       location=new Location(0,0);
   }
    public void execute(){
        tilePlacementManager.execute(this);
    }
    public void setLocation(int x,int y){
        location.setX(x);
        location.setY(y);
    }
}
