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
   public boolean equalTileEdgeFeatureType(FeatureType feature){
       SourceRiver sourceRiver=new SourceRiver();
       NormalRiver normalRiver=new NormalRiver();
       Sea sea =new Sea();

       if((this.feature.getClass().equals(normalRiver.getClass())||this.feature.getClass().equals(sourceRiver.getClass()))&&!(feature.getClass().equals(normalRiver.getClass())||feature.getClass().equals(sourceRiver.getClass())||feature.getClass().equals(sea.getClass()))){
           System.out.println("Im sorry");
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
    public void print(){
        feature.print();
    }
}
