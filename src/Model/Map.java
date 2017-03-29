package Model;

import Model.Tile.FeatureTypes.River.NormalRiver;
import Model.Tile.Tile;
import Model.Tile.TileOrientation;
import javafx.geometry.Orientation;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/25/2017.
 */
public class Map {
    TilePlacementManager tilePlacementManager;
    MapObserver mapObserver;
    RiverConnectionManager riverConnectionManager;
    final int BSIZE = 10;
    protected Tile[][] map;


    //CREATING THE GAME MAP
    Map(){
        map = new Tile[BSIZE][BSIZE];

    }

    public Tile[][] getMap(){return this.map;}
    public Tile getTile(int x, int y){return this.map[x][y];}
    public boolean checkcoordinates(int x, int y){
        if(x < 0 || x >= map[0].length)
            return false;
        else if(y < 0 || y >= map[1].length)
            return false;
        else
            return true;
    }

    public void insertTile(Tile tile, Location location, TileOrientation orientation) {

    // mapObserver.notify(this);
    }
    private boolean checkTileInsertionEligibilty(Tile tile, Location location,TileOrientation orientation){
        ArrayList<Tile> tilesToBeChecked=getNeighbors(location);
        for(int i=0;i<tilesToBeChecked.size();i++){
            Tile tileToBeCheckedBasedOnTileInserted=tilesToBeChecked.get(i);
            if(!tile.getTileEdge(i).equals(tileToBeCheckedBasedOnTileInserted.getTileEdge((i+3)%6))){
                return false;
            }
        }

        return true;
    }
    private ArrayList<Tile> getNeighbors(Location location){
        //This is bad need to change eventually.  TDA but I havent figured a better way
        ArrayList<Tile> tileToBeReturned=new ArrayList<Tile>();
        Location northLocation=location.getNorth();
        Location southLocation=location.getSouth();
        Location southEastLocation=location.getSouthEast();
        Location southWestLocation=location.getSouthWest();
        Location northEastLocation=location.getNorthEast();
        Location northWestLocation=location.getNorthWest();
        if(checkcoordinates(northLocation.getX(),northLocation.getY())){
            tileToBeReturned.add(map[northLocation.getX()][northLocation.getY()]);
            
        } else {
            tileToBeReturned.add(null);
        }
        if(checkcoordinates(northEastLocation.getX(),northEastLocation.getY())){
            tileToBeReturned.add(map[northEastLocation.getX()][northEastLocation.getY()]);

        } else {
            tileToBeReturned.add(null);
        }
        if(checkcoordinates(southEastLocation.getX(),southEastLocation.getY())){
            tileToBeReturned.add(map[southEastLocation.getX()][southEastLocation.getY()]);

        } else {
            tileToBeReturned.add(null);
        }

        if(checkcoordinates(southLocation.getX(),southLocation.getY())){
            tileToBeReturned.add(map[southLocation.getX()][southLocation.getY()]);

        } else {
            tileToBeReturned.add(null);
        }
        if(checkcoordinates(southWestLocation.getX(),southWestLocation.getY())){
            tileToBeReturned.add(map[southWestLocation.getX()][southWestLocation.getY()]);

        } else {
            tileToBeReturned.add(null);
        }
        if(checkcoordinates(northWestLocation.getX(),northWestLocation.getY())){
            tileToBeReturned.add(map[northWestLocation.getX()][northWestLocation.getY()]);

        } else {
            tileToBeReturned.add(null);
        }
        return tileToBeReturned;
    }

}
