package Controller.Commands;

import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.River;
import Model.Tile.Tile;
import Model.Tile.TileEdge;
import Model.TilePlacementManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/28/2017.
 */
public class TileTypeCommand implements Command {
    TilePlacementManager tilePlacementManager;
    FeatureType  featureType;
    ArrayList<TileEdge> tileEdgeList;
    public TileTypeCommand(TilePlacementManager tilePlacementManager){
        this.tilePlacementManager=tilePlacementManager;
    }
    public void execute(){
        tilePlacementManager.execute(this);
        featureType=null;
       clearRivers();
       clearFeatureType();
    }
    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }

    public void setRivers(River river,int tileEdgePosition) {
        tileEdgeList.get(tileEdgePosition).setFeatureType(river);
    }
    public void clearRivers(){
        tileEdgeList=new ArrayList<TileEdge>(6);
    }
    public void clearFeatureType(){
        featureType=null;
    }
}
