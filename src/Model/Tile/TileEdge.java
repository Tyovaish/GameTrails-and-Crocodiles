package Model.Tile;

import Model.Tile.FeatureTypes.FeatureType;

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

       return true;
    }

    //SETTERS
    public void setNorthType(){

    }
    public void setSouthType(){

    }
    public void setFeatureType(FeatureType feature){
       this.feature=feature;
    }
    public void setNWType(){

    }
    public void setNEType(){

    }
    public void setSWType(){

    }
    public void setSEType(){

    }

    //GETTERS
    public void getNorthType(){

    }
    public void getSouthType(){

    }
    public void getNWType(){

    }
    public void getNEType(){

    }
    public void getSWType(){

    }
    public void getSEType(){

    }
}
