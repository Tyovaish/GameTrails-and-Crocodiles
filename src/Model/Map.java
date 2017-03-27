package Model;

import Model.Tile.Tile;

import java.util.HashMap;

/**
 * Created by Trevor on 3/25/2017.
 */
public class Map {
    TilePlacementManager tilePlacementManager;
    HashMap<Location,Tile> map;

    public boolean insertTile(Tile tile,Location location) {

        return true;
    }
    public boolean checkTileInsertionEligibilty(Tile tile, Location location){
        return true;
    }


}
