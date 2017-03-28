package Model;

import Model.Tile.Tile;

/**
 * Created by Trevor on 3/25/2017.
 */
public class Map {
    TilePlacementManager tilePlacementManager;
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

    public boolean insertTile(Tile tile, Location location) {
        return true;
    }
    public boolean checkTileInsertionEligibilty(Tile tile, Location location){
        return true;
    }


}
