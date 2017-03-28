package Model.Tile;

import Model.Tile.FeatureTypes.FeatureType;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/26/2017.
 */
public class GroundTile extends Tile {

    public FeatureType getFeatureAtTileEdge(int tileEdgePosition) {
        return null;
    }

    public boolean checkEdgeCompatabilty(int tileEdgePositionToCheck, FeatureType otherTilesFeature){
        return true;
    }
    public void setFeature(FeatureType feature){
        this.feature=feature;
    }
    public void setTileEdges(FeatureType feature){
        this.feature=feature;
    }
}
