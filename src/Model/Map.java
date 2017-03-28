package Model;

import Model.Tile.Tile;

import java.util.HashMap;

/**
 * Created by Trevor on 3/25/2017.
 */
public class Map {
    TilePlacementManager tilePlacementManager;
    final int BSIZE = 10;
    protected Tile [][] map;


    //CREATING THE GAME MAP
    Map(){
        map = new Tile[BSIZE][BSIZE];

    }

    public Tile[][] getMap(){return this.map;}
    public Tile getTile(int x, int y){return this.map[x][y];}
    public String getTileType(int x, int y){return this.map[x][y].getType();}
    public boolean checkcoordinates(int x, int y){
        if(x < 0 || x >= map[0].length)
            return false;
        else if(y < 0 || y >= map[1].length)
            return false;
        else
            return true;
    }

    public boolean insertTile(Tile tile, Location location) {

        return true;
    }
    public boolean checkTileInsertionEligibilty(Tile tile, Location location){
        return true;
    }


}
