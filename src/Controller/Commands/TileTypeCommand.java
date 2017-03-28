package Controller.Commands;

import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.River;
import Model.TilePlacementManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/28/2017.
 */
public class TileTypeCommand implements Command {
    TilePlacementManager tilePlacementManager;
    FeatureType  featureType;
    ArrayList<River> rivers;
    public void execute(){
        tilePlacementManager.execute(this);
    }
}
