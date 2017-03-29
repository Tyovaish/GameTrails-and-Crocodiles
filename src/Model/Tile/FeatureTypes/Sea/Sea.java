package Model.Tile.FeatureTypes.Sea;

import Model.Tile.FeatureTypes.FeatureType;

/**
 * Created by Trevor on 3/25/2017.
 */
public class Sea extends FeatureType {
    String type = "sea";

    public Boolean isLand(){ return false; }
    public Boolean riverEnd(){ return true; }
}
