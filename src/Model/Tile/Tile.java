package Model.Tile;



import Model.Location;
import Model.Tile.FeatureTypes.FeatureType;
import javafx.geometry.Orientation;

import java.util.ArrayList;


public class Tile {
    FeatureType feature;
    ArrayList<TileEdge> tileEdges;
    TileOrientation orientation;

    public Tile(){
        for(int i=0;i<6;i++){
            tileEdges.add(new TileEdge());
        }
    }
    public Tile(FeatureType feature,ArrayList<TileEdge> tileEdges, TileOrientation orientation){
        this.feature=feature;
        this.tileEdges=new ArrayList<TileEdge>(6);
        this.orientation=orientation;
        for(int i=0;i<this.tileEdges.size();i++){
            this.tileEdges.add(i,tileEdges.get((i+orientation.getRotations())%this.tileEdges.size()));
        }
        rotate();
    }

    public TileEdge getTileEdge(int tileEdgePosition){
        return tileEdges.get(tileEdgePosition);
    }
    public ArrayList<TileEdge> getTileEdges(){ return tileEdges; }

    public void  setTileEdgeFeature(int tileEdgeFeature, FeatureType feature){tileEdges.add(new TileEdge(feature));}
    public FeatureType getTileEdgeFeature(int tileEdgePosition){
        return tileEdges.get(tileEdgePosition).getFeatureType();
    }

    public boolean checkEdgeCompatabilty(int tileEdgePositionToCheck, FeatureType otherTilesFeature){
        return tileEdges.get(tileEdgePositionToCheck).equals(otherTilesFeature);
    }

    public void rotate(){
        for (int i = 0; i < orientation.getRotations(); i++){
            tileEdges.add(0, tileEdges.remove(5));
        }
    }
}
