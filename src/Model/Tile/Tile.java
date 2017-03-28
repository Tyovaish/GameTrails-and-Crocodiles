package Model.Tile;



import Model.Location;
import Model.Tile.FeatureTypes.FeatureType;
import javafx.geometry.Orientation;

import java.util.ArrayList;


public class Tile {
    FeatureType feature;
    ArrayList<TileEdge> tileEdges;
    TileOrientation orientation;

    public Tile(){
        for(int i=0;i<6;i++){
            tileEdges.add(new TileEdge());
        }
    }
    public Tile(ArrayList<TileEdge> tileEdges, TileOrientation orientation){
        this.tileEdges=tileEdges;
        this.orientation=orientation;
    }

    public TileEdge getTileEdge(int tileEdgePosition){
        return tileEdges.get(tileEdgePosition);
    }

    public void  setTileEdgeFeature(int tileEdgeFeature, FeatureType feature){tileEdges.add(new TileEdge(feature));}

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
