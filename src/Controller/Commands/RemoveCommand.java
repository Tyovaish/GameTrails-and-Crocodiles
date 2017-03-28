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
   public RemoveCommand(TilePlacementManager tilePlacementManager){
       this.tilePlacementManager=tilePlacementManager;
   }
    public void execute(){
        tilePlacementManager.execute(this);
    }
    public void setLocation(int x,int y){
        location.setX(x);
        location.setY(y);
    }
    public void setLocation(Location location){
        this.location=location;
    }
}
