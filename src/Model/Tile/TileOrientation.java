package Model.Tile;

/**
 * Created by Trevor on 3/27/2017.
 */
public class TileOrientation {
    int degrees;
    public TileOrientation(int degrees){ this.degrees=degrees; }

    public void rotate(int degrees){
        this.degrees+=degrees;
    }
    public void reset(){
        degrees=0;
    }
}
