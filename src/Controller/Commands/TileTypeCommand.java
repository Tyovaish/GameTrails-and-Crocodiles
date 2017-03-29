package Controller.Commands;

import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.River;
import Model.Tile.TileEdge;
import Model.TilePlacementManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/28/2017.
 */
public class TileTypeCommand {
    FeatureType  featureType;
    ArrayList<TileEdge> tileEdgeList;

    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }

    public void setRivers(River river,int tileEdgePosition) {
        tileEdgeList.get(tileEdgePosition).setFeatureType(river);
    }
    public ArrayList<TileEdge> getTileEdgeList(){
        return tileEdgeList;
    }
    public void clearTileEdgeList(){
        tileEdgeList=new ArrayList<TileEdge>(6);
    }
    public void clearFeatureType(){
        featureType=null;
    }
}
