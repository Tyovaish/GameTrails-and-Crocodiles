package Controller.Commands;

import Model.Location;
import Model.Tile.TileOrientation;
import Model.TilePlacementManager;
import javafx.geometry.Orientation;

/**
 * Created by Trevor on 3/28/2017.
 */
public class TilePlacementCommand implements Command {
    TilePlacementManager tilePlacementManager;
    Location location;

    TileOrientation orientation;
    public TilePlacementCommand(TilePlacementManager tilePlacementManager){
        this.tilePlacementManager=tilePlacementManager;
    }
    public void execute(){
        tilePlacementManager.execute(this);
        location=null;
        orientation.reset();
    }
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location){
      this.location=location;
    }
    public void setOrientation(Orientation orientation){
        orientation=orientation;
    }
    public TileOrientation getOrientation() {
        return orientation;
    }
    public void clearOrientation(){
        orientation.reset();
    }
    public void setOrientation(TileOrientation orientation) {
        this.orientation = orientation;
    }

}
