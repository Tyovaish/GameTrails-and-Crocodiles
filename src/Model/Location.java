package Model;


/**
 * Created by Trevor on 3/25/2017.
 */
public class Location {
    public int x, y;


    public Location(int row, int col){
        this.x = row;
        this.y = col;
    }

    public Location(Location location){
        this.x = location.x;
        this.y = location.y;
    }

    //Check if the two coordinates of Location refers to the same tiles
    public boolean equals(Location diffTile) {
        return ((this.x == diffTile.x) && (this.y == diffTile.y));
    }

    //TODO CALCULATE DISTANCE BETWEEN COORDINATES

}
