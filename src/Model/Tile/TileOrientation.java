package Model.Tile;

/**
 * Created by Trevor on 3/27/2017.
 */
public class TileOrientation {
    int degrees;
    public void rotate(int degrees){
        this.degrees+=degrees;
    }
}