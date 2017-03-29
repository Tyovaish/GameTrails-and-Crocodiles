package Model.Tile;

/**
 * Created by Trevor on 3/27/2017.
 */
public class TileOrientation {
    int rotations;

    public TileOrientation(int degrees){
        this.rotations=degrees;
    }
    public void rotate(int degrees){
        this.rotations+=degrees;
    }
    public void reset(){
        rotations=0;
    }
    public int getRotations(){
        return rotations;
    }
}
