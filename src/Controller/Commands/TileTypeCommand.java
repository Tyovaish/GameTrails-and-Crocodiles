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
    public TileTypeCommand(TilePlacementManager tilePlacementManager){
        this.tilePlacementManager=tilePlacementManager;
    }
    public void execute(){
        tilePlacementManager.execute(this);
        featureType=null;
        rivers=null;
    }
    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }
    public ArrayList<River> getRivers() {
        return rivers;
    }

    public void setRivers(ArrayList<River> rivers) {
        this.rivers = rivers;
    }
}
