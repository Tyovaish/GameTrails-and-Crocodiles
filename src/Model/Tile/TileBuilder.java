package Model.Tile;

import Controller.Commands.TileTypeCommand;
import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.River;
import Model.Tile.FeatureTypes.Sea.Sea;
import Model.Tile.FeatureTypes.Terrain.Woods;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/28/2017.
 */
public class TileBuilder {
    public TileBuilder(){}

    public static Tile createTile(FeatureType featureType,ArrayList<TileEdge> tileEdges, TileOrientation orientation){
      for(int i=0;i<tileEdges.size();i++){
         if(tileEdges.get(i)==null){
            tileEdges.get(i).setFeatureType(featureType);
         }
      }
       return new Tile(featureType, tileEdges, orientation);
    }

    public Tile execute(TileTypeCommand command){
        FeatureType featureType = command.getFeatureType();
        ArrayList<TileEdge> tileEdges = command.getTileEdgeList();
        TileOrientation orientation = command.getOrientation();
        return new Tile(featureType, tileEdges, orientation);
    }
}
