package Model.Tile;

import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.NormalRiver;
import Model.Tile.FeatureTypes.River.SourceRiver;
import Model.Tile.FeatureTypes.RiverLink;
import Model.Tile.FeatureTypes.Sea.Sea;
import com.sun.org.apache.xalan.internal.utils.FeatureManager;

/**
 * Created by Trevor on 3/25/2017.
 */
public class TileEdge {
   private FeatureType feature;
   private String type;
   private Boolean hasRiver;
   private Boolean source;

   public TileEdge(){
       hasRiver = false;
       source = false;
   }
   public TileEdge(FeatureType feature){
       this.feature=feature;
       hasRiver = false;
       source = false;
   }

    public void setFeatureType(FeatureType feature){
       this.feature=feature;
       String type = feature.getType();
       if (type == "sea") { source = true; }
       if (type == "normalriver" || type == "source"){
           hasRiver = true;
           if (type == "source"){
               source = true;
           } else source = false;
       } else hasRiver = false;
    }
    public FeatureType getFeatureType(){ return feature; }

    public Boolean hasRiver(){ return hasRiver; }
    public void setHasRiver(Boolean hasRiver){ this.hasRiver = hasRiver; }

    public Boolean isSource(){ return source; }
    public void setSource(Boolean source){ this.source = source; }

    public boolean tileEdgeFeatureEqual(FeatureType featureType){
        FeatureType sourceRiver=new SourceRiver();
        FeatureType normalRiver=new NormalRiver();
        FeatureType sea =new Sea();

        if(feature.getClass().equals(sourceRiver.getClass())||feature.getClass().equals(normalRiver.getClass())){
            if(!featureType.getClass().equals(sourceRiver.getClass())&&!featureType.getClass().equals(sea.getClass())&&!featureType.getClass().equals(normalRiver.getClass())){
                return false;
            }
        } else{
            if(featureType.getClass().equals(sourceRiver.getClass())||featureType.getClass().equals(sea.getClass())||featureType.getClass().equals(normalRiver.getClass())){
                return false;
            }
        }
        return true;
    }

    public void print(){
        feature.print();
    }
}
