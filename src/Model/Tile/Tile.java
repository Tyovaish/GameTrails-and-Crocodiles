package Model.Tile;



import Model.Location;
import Model.Tile.FeatureTypes.FeatureType;

import java.util.ArrayList;


public abstract class Tile {
    FeatureType feature;
    ArrayList<TileEdge> tileEdges;



    public TileEdge getTileEdge(int tileEdgePosition){
        return tileEdges.get(tileEdgePosition);
    }

    public Location getSouthWest(Location location) {
        if (location.getY() % 2 == 0)
            return new Location(location.getX(), location.getY() + 1);
        else
            return new Location(location.getX()+1, location.getY() + 1);
    }

    public Location getNorthWest(Location location) {
        if (location.getY() % 2 == 0)
            return new Location(location.getX()-1, location.getY() + 1);
        else
            return new Location(location.getX(), location.getY()+ 1);
    }

    public Location getNorth(Location location) {
        return new Location(location.getX() - 1, location.getY());
    }

    public Location getNorthEast(Location location) {
        if (location.getY() % 2 == 0)
            return new Location(location.getX()-1, location.getY() - 1);
        else
            return new Location(location.getX(), location.getY() - 1);
    }

    public Location getSouth(Location location) {
        return new Location( location.getX() + 1, location.getY());
    }

    public Location getSouthEast(Location location) {
        if (location.getY() % 2 == 0)
            return new Location(location.getX(), location.getY() - 1);
        else
            return new Location(location.getX() + 1, location.getY() - 1);
    }

    public boolean checkEdgeCompatabilty(int tileEdgePositionToCheck, FeatureType otherTilesFeature){
        return true;
    }

}
