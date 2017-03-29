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
    TileOrientation orientation;


    public  TileTypeCommand(){
        tileEdgeList=new TileEdge[6];
    }
    public FeatureType getFeatureType() {
        return featureType;
    }

    public int getNumberOfRivers(){
        int numberOfRivers=0;
        for(int i=0;i<tileEdgeList.length;i++){
            if(tileEdgeList[i]!=null){
                numberOfRivers++;
            }
        }
        return numberOfRivers;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }

    public void setRivers(River river,int tileEdgePosition) {
        tileEdgeList[tileEdgePosition] = new TileEdge();
        tileEdgeList[tileEdgePosition].setFeatureType(river);
    }
    public TileEdge [] getTileEdgeList(){
        return tileEdgeList;
    }
    public void clearTileEdgeList(){
        tileEdgeList=new TileEdge[6];
    }
    public void clearFeatureType(){
        featureType=null;
    }
    public void print(){ //DEBUG purpose will delete
            System.out.println("FeatureType: ");
            featureType.print();
            System.out.println("Orientation: "+orientation.getRotations());

        for(int i=0;i<tileEdgeList.length;i++){
            if(tileEdgeList[i]!=null){
                System.out.print(i+": ");
                tileEdgeList[i].print();
            }
        }
    }
    public TileOrientation getOrientation() {
        return orientation;
    }
    public void clearOrientation(){
        orientation.reset();
    }
    public void setOrientation(TileOrientation orientation) {
        this.orientation = orientation;
    }
}
