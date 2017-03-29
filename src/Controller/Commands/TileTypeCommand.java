package Controller.Commands;

import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.River;
import Model.Tile.TileEdge;
import Model.Tile.TileOrientation;
import Model.TilePlacementManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/28/2017.
 */
public class TileTypeCommand {
    FeatureType  featureType;
    ArrayList<TileEdge> tileEdgeList;
    TileOrientation orientation;

    public TileTypeCommand(){}

    public TileTypeCommand(FeatureType featureType, ArrayList<TileEdge> tileEdgeList, TileOrientation orientation){
        this.featureType = featureType;
        this.tileEdgeList = tileEdgeList;
        this.orientation = orientation;
    }


    public FeatureType getFeatureType() {
        return featureType;
    }
    public ArrayList<TileEdge> getTileEdgeList() { return tileEdgeList; }
    public TileOrientation getOrientation() { return orientation; }

    public void setFeatureType(FeatureType featureType) { this.featureType = featureType; }
    public void setTileEdge(FeatureType featureType,int tileEdgePosition) {
        tileEdgeList.get(tileEdgePosition).setFeatureType(featureType);
    }
    public void setOrientation(TileOrientation orientation){ this.orientation = orientation; }

    public void clearFeatureType(){
        featureType=null;
    }
    public void clearTileEdgeList(){
        tileEdgeList=new ArrayList<TileEdge>(6);
    }
    public void clearOrientation() { orientation = null;}
}
