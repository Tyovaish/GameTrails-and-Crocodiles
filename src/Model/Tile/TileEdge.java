package Model.Tile;

import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.NormalRiver;
import Model.Tile.FeatureTypes.River.SourceRiver;
import Model.Tile.FeatureTypes.RiverLink;
import Model.Tile.FeatureTypes.Sea.Sea;

/**
 * Created by Trevor on 3/25/2017.
 */
public class TileEdge {
   private FeatureType feature;
   private String type;
   private RiverLink riverLink;

   public TileEdge(){}
   public TileEdge(FeatureType feature){
       this.feature=feature;
       this.riverLink = new RiverLink();
   }

    public RiverLink getRiverLink(){ return riverLink; }
    public void setLinkPrev(TileEdge edge){ riverLink.setPrev(edge); }
    public void setLinkNext(TileEdge edge){ riverLink.setNext(edge); }

    public void setFeatureType(FeatureType feature){
       this.feature=feature;
    }
    public FeatureType getFeatureType(){
        return feature;
    }
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
