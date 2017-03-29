package Controller.Commands;

import Model.Location;
import Model.TilePlacementManager;

/**
 * Created by Trevor on 3/28/2017.
 */
public class RemoveCommand {
   Location location;
    public void setLocation(int x,int y){
        location.setX(x);
        location.setY(y);
    }
    public void setLocation(Location location){
        this.location=location;
    }
    public Location getLocation(){return location;}
}
