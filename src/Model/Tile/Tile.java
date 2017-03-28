package Model.Tile;

import Model.Location;
import Model.Tile.FeatureTypes.FeatureType;

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

    public Location getSouthWest(Location location) {
        if (location.y % 2 == 0)
            return new Location(location.x, location.y + 1);
        else
            return new Location(location.x+1, location.y + 1);
    }

    public Location getNorthWest(Location location) {
        if (location.y % 2 == 0)
            return new Location(location.x-1, location.y + 1);
        else
            return new Location(location.x, location.y+ 1);
    }

    public Location getNorth(Location location) {
        return new Location(location.x - 1, location.y);
    }

    public Location getNorthEast(Location location) {
        if (location.y % 2 == 0)
            return new Location(location.x-1, location.y - 1);
        else
            return new Location(location.x, location.y - 1);
    }

    public Location getSouth(Location location) {
        return new Location( location.x + 1, location.y);
    }

    public Location getSouthEast(Location location) {
        if (location.y % 2 == 0)
            return new Location(location.x, location.y - 1);
        else
            return new Location(location.x + 1, location.y - 1);
    }

    public boolean checkEdgeCompatabilty(int tileEdgePositionToCheck, FeatureType otherTilesFeature){
        return true;
    }

}
