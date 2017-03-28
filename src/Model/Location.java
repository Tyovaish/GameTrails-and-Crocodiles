package Model;


/**
 * Created by Trevor on 3/25/2017.
 */
public class Location {

    private int x;
    private int y;


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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
