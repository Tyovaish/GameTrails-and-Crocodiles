package Model.Tile;

import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.NormalRiver;
import Model.Tile.FeatureTypes.River.SourceRiver;
import Model.Tile.FeatureTypes.Sea.Sea;

/**
 * Created by Trevor on 3/25/2017.
 */
public class TileEdge {
   FeatureType feature;
    String type;

   public TileEdge(){}
   public TileEdge(FeatureType feature){
       this.feature=feature;
   }


    public void setFeatureType(FeatureType feature){
       this.feature=feature;
    }
    public FeatureType getFeatureType(){
        return feature;
    }
    public boolean tileEdgeFeatureEqual(FeatureType featureType){
        FeatureType sourceRiver= new SourceRiver();
        FeatureType normalRiver= new NormalRiver();
        FeatureType sea =new Sea();

        if(feature.getClass().equals(sourceRiver.getClass())||feature.getClass().equals(normalRiver.getClass())) {
            if (!featureType.getClass().equals(sourceRiver.getClass()) && !featureType.getClass().equals(sea.getClass()) && !featureType.getClass().equals(normalRiver.getClass())) {
                return false;
            }

        } else if(!featureType.getClass().equals(sea.getClass())){
            if(featureType.getClass().equals(sourceRiver.getClass())||featureType.getClass().equals(normalRiver.getClass())){
                return false;

            }
        return true;
    }

    public void print(){
        feature.print();
    }
}
