package Model.Tile;


import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.Sea.Sea;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/26/2017.
 */
public class SeaTile extends Tile{
    Sea sea;
    SeaTile(FeatureType feature,ArrayList<TileEdge> tileEdges){
        super(feature,tileEdges);
    }
    public FeatureType getFeatureAtTileEdge(int tileEdgePosition) {
        return sea;
    }
    public boolean checkEdgeCompatabilty(int tileEdgePositionToCheck, FeatureType otherTilesFeature){
        return true;
    }

}
