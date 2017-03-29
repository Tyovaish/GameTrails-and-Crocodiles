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
    public Tile execute(TileTypeCommand command){
        return createTile(command.getFeatureType(), command.getTileEdgeList(), command.getOrientation());
    }

   private static Tile createTile(FeatureType featureType,TileEdge[] tileEdges, TileOrientation orientation){
      for(int i=0;i<tileEdges.length;i++){
         if(tileEdges[i]==null){
            System.out.println("We good");
            tileEdges[i]=new TileEdge();
            tileEdges[i].setFeatureType(featureType);
         }
      }
      return new Tile(featureType,tileEdges,orientation);
   }
}
