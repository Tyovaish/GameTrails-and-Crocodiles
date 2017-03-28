package Model.Tile;

import Model.FeatureTypes.FeatureType;

/**
 * Created by Trevor on 3/26/2017.
 */
public class SeaTile extends Tile {
    Sea sea;
    public FeatureType getFeatureAtTileEdge(int tileEdgePosition) {
        return sea;
    }
    public boolean checkEdgeCompatabilty(int tileEdgePositionToCheck, FeatureType otherTilesFeature){
        return true;
    }

}
