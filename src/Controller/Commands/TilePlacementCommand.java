package Controller.Commands;

import Model.Location;
import Model.Tile.TileOrientation;
import Model.TilePlacementManager;
import javafx.geometry.Orientation;

/**
 * Created by Trevor on 3/28/2017.
 */
public class TilePlacementCommand {
    Location location;

    public TilePlacementCommand(){}
    public TilePlacementCommand(Location location, TileOrientation orientation){
        this.location = location;
    }
    public void execute(){
        // tilePlacementManager.execute(this);
        location=null;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location){ this.location=location; }

}
