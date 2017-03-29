package Model.Tile;

/**
 * Created by Trevor on 3/27/2017.
 */
public class TileOrientation {
    int rotations;
    public TileOrientation(int rotations){
        this.rotations=rotations;
    }
    public void rotate(int rotations){
        this.rotations+=rotations;
    }
    public void reset(){
        rotations=0;
    }
    public int getRotations(){
        return rotations;
    }
}
