package Model.Tile;

import Model.FeatureTypes.FeatureType;

import java.util.ArrayList;
/**
 * Created by Trevor on 3/25/2017.
 */
public abstract class Tile {
    abstract public FeatureType getFeatureAtTileEdge(int tileEdgePosition);
    abstract public boolean checkEdgeCompatabilty(int tileEdgePositionToCheck, FeatureType otherTilesFeature);

}
