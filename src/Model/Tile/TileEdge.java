package Model.Tile;

import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.Sea.Sea;
import Model.Tile.FeatureTypes.Terrain.Woods;
import com.sun.org.apache.xalan.internal.utils.FeatureManager;

/**
 * Created by Trevor on 3/25/2017.
 */
public class TileEdge {
   FeatureType feature;
   TileEdge(FeatureType feature){
       this.feature=feature;
   }
   public boolean equals(FeatureType feature){
       return this.feature.getClass().equals(feature.getClass());
    }

}
