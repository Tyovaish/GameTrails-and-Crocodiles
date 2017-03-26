package Model.Tile;

import Model.FeatureTypes.FeatureType;

import java.util.ArrayList;
/**
 * Created by Trevor on 3/25/2017.
 */
public abstract class Tile {
    FeatureType feature;
    ArrayList<TileEdge> tileEdges;
    Tile(FeatureType feature,ArrayList<TileEdge> tileEdges){
        this.feature=feature;
        this.tileEdges=tileEdges;
    }
    public TileEdge getTileEdge(int tileEdgePosition){
        return tileEdges.get(tileEdgePosition);
    }
    public boolean checkEdgeCompatabilty(int tileEdgePositionToCheck, FeatureType otherTilesFeature){
        return true;
    }

}
