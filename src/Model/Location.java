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
        this.x = x;
        this.y = y;
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

    public Location getNorth() {
        return new Location(getX() - 1, getY());
    }
    public Location getSouth() {
        return new Location( getX() + 1, getY());
    }
    public Location getNorthWest() {
        if (getY() % 2 == 0)
            return new Location(getX() - 1, getY() - 1);
        else
            return new Location(getX(), getY() - 1);
    }
    public Location getSouthWest() {
        if (getY() % 2 == 0)
            return new Location(getX(), getY() - 1);
        else
            return new Location(getX() + 1, getY() - 1);
    }
    public Location getNorthEast() {
        if (getY() % 2 == 0)
            return new Location(getX() - 1, getY() + 1);
        else
            return new Location(getX(), getY() + 1);
    }
    public Location getSouthEast() {
        if (getY() % 2 == 0)
            return new Location(getX(), getY() + 1);
        else
            return new Location(getX() + 1, getY() + 1);
    }

}
