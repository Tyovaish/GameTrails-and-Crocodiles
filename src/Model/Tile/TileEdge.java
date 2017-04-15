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
    public boolean tileEdgeFeatureEqual(FeatureType featureType) {
        SourceRiver sourceRiver = new SourceRiver();
        NormalRiver normalRiver = new NormalRiver();
        Sea sea = new Sea();

        if (feature.getClass().equals(sourceRiver.getClass()) || feature.getClass().equals(normalRiver.getClass())) {
            System.out.println("Im a river");
            if (!featureType.getClass().equals(sourceRiver.getClass()) && !featureType.getClass().equals(sea.getClass()) && !featureType.getClass().equals(normalRiver.getClass())) {
                System.out.println("River does not match with tile's feature");
                return false;
            }

        } else if (!feature.getClass().equals(sea.getClass())) {
            System.out.println("Im not a river");
            if (featureType.getClass().equals(sourceRiver.getClass()) || featureType.getClass().equals(normalRiver.getClass())) {
                System.out.println("Terrain does not match with other tile's feature");
                return false;

            }
        }
        return true;
    }

    public void print(){
        feature.print();
    }
}
