package Model.Tile.FeatureTypes.Sea;

import Model.Tile.FeatureTypes.FeatureType;

/**
 * Created by Trevor on 3/25/2017.
 */
public class Sea extends FeatureType {
    String type = "sea";
    public Sea(){addType(type);}
    public void print(){
        System.out.println(type);
    }

}
