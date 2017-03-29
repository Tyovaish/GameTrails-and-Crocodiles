package Model.Tile;



import Model.Location;
import Model.Tile.FeatureTypes.FeatureType;
import javafx.geometry.Orientation;

import java.util.ArrayList;


public class Tile {
    FeatureType feature;
    TileEdge [] tileEdges;
    TileOrientation orientation;

    public Tile(){
      tileEdges=new TileEdge[6];
    }
    public Tile(FeatureType feature,TileEdge [] tileEdges, TileOrientation orientation){
        this.feature=feature;
        this.tileEdges=new TileEdge[6];
        this.orientation=orientation;
        for(int i=0;i<this.tileEdges.length;i++){
            this.tileEdges[i]=tileEdges[((i-orientation.getRotations()+6)%this.tileEdges.length)];
        }
        rotate();
    }
    public TileEdge getTileEdge(int tileEdgePosition){
        return tileEdges[tileEdgePosition];
    }
    public TileEdge[] getTileEdges(){ return tileEdges; }

    public void  setTileEdgeFeature(int tileEdgeFeaturePosition, FeatureType feature){tileEdges[tileEdgeFeaturePosition].setFeatureType(feature);}
    public FeatureType getTileEdgeFeature(int tileEdgePosition){
        return tileEdges[tileEdgePosition].getFeatureType();
    }

    public boolean checkEdgeCompatabilty(int tileEdgePositionToCheck, FeatureType otherTilesFeature){
        return tileEdges[tileEdgePositionToCheck].equals(otherTilesFeature);
    }
    public void print(){
        for(int i=0;i<tileEdges.length;i++){
            System.out.print(i);
            tileEdges[i].print();
        }
    }

    public void rotate(){
        for (int i = 0; i < orientation.getRotations(); i++){
            tileEdges.add(0, tileEdges.remove(5));
        }
    }
}
