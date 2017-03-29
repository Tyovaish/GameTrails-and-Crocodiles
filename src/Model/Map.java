package Model;

import Model.Tile.FeatureTypes.River.NormalRiver;
import Model.Tile.Tile;
import Model.Tile.TileEdge;
import Model.Tile.TileOrientation;
import javafx.geometry.Orientation;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/25/2017.
 */
public class Map {
    TilePlacementManager tilePlacementManager;
    RiverConnectionManager riverConnectionManager;
    final int BSIZE = 10;
    protected Tile[][] map;


    //CREATING THE GAME MAP
    public Map(){
        //this.mapObserver=mapObserver;
        map = new Tile[BSIZE][BSIZE];


    }


    public String getTileType(int x, int y){
        if(map[x][y] != null)
        return map[x][y].getTileType();
    else
        return null;
    }
    public int getTileOrientation(int x, int y){
        if(map[x][y]!=null) {
            return map[x][y].getTileOrientation();
        }
        return 0;
    }

    public boolean checkcoordinates(int x, int y){
        if(x < 0 || x >= map[0].length)
            return false;
        else if(y < 0 || y >= map[1].length)
            return false;
        else
            return true;
    }

    public void insertTile(Tile tile, Location location) {
        map[location.getX()][location.getY()]=tile;
    // mapObserver.notify(this);
    }
/*    private boolean checkTileInsertionEligibilty(Tile tile, Location location,TileOrientation orientation){
        Tile[] tilesToBeChecked=getNeighbors(location);
        for(int i=0;i<tilesToBeChecked.length;i++){
            Tile tileToBeCheckedBasedOnTileInserted=tilesToBeChecked[i];
            if(!tile.getTileEdge(i).equals(tileToBeCheckedBasedOnTileInserted.getTileEdge((i+3)%6))){
                return false;
            }
        }
        return true;
    } */
    private Tile[] getNeighbors(Location location){
        //This is bad need to change eventually.  TDA but I havent figured a better way
        Tile[] tileToBeReturned=new Tile[6];
        Location northLocation=location.getNorth();
        Location southLocation=location.getSouth();
        Location southEastLocation=location.getSouthEast();
        Location southWestLocation=location.getSouthWest();
        Location northEastLocation=location.getNorthEast();
        Location northWestLocation=location.getNorthWest();
        if(checkcoordinates(northLocation.getX(),northLocation.getY())){
            tileToBeReturned[0]=map[northLocation.getX()][northLocation.getY()];
            
        } else {
            tileToBeReturned[0]=null;
        }
        if(checkcoordinates(northEastLocation.getX(),northEastLocation.getY())){
            tileToBeReturned[1]=map[northEastLocation.getX()][northEastLocation.getY()];

        } else {
            tileToBeReturned[1]=(null);
        }
        if(checkcoordinates(southEastLocation.getX(),southEastLocation.getY())){
            tileToBeReturned[2]=map[southEastLocation.getX()][southEastLocation.getY()];

        } else {
            tileToBeReturned[2]=null;
        }

        if(checkcoordinates(southLocation.getX(),southLocation.getY())){
            tileToBeReturned[3]=map[southLocation.getX()][southLocation.getY()];

        } else {
            tileToBeReturned[3]=null;
        }
        if(checkcoordinates(southWestLocation.getX(),southWestLocation.getY())){
            tileToBeReturned[4]=map[southWestLocation.getX()][southWestLocation.getY()];

        } else {
            tileToBeReturned[4]=null;
        }
        if(checkcoordinates(northWestLocation.getX(),northWestLocation.getY())){
            tileToBeReturned[5]=map[northWestLocation.getX()][northWestLocation.getY()];

        } else {
            tileToBeReturned[5]=null;
        }
        return tileToBeReturned;
    }
    public void removeTile(Location location){
        map[location.getX()][location.getY()]=null;
    }

}
