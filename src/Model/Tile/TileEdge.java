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
   public boolean equals(FeatureType feature){
       if((this.feature.getClass().equals(new NormalRiver())||this.feature.getClass().equals(new SourceRiver()))&&(feature.getClass().equals(new NormalRiver())||feature.getClass().equals(new SourceRiver())||feature.getClass().equals(new Sea()))){
           return false;
       }
       return true;
    }

    public void setFeatureType(FeatureType feature){
       this.feature=feature;
    }
    public FeatureType getFeatureType(){
        return feature;
    }
}
