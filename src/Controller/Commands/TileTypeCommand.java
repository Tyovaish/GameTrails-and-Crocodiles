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
    TileEdge[] tileEdgeList;

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

    public void setRivers(River river,int tileEdgePosition) {
        tileEdgeList[tileEdgePosition].setFeatureType(river);
    }
    public TileEdge [] getTileEdgeList(){
        return tileEdgeList;
    }
    public void clearTileEdgeList(){
        tileEdgeList=new TileEdge[6];
    }
    public void clearOrientation() { orientation = null;}
}
