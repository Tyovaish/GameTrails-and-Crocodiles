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
   static Tile TileBuilder(FeatureType featureType, ArrayList<River> rivers){
      Tile tileToBeCreated=new Tile();
      if(featureType.equals(new Sea())){
         for(int i=0;i<6;i++){
            tileToBeCreated.setTileEdgeFeature(i,featureType);
         }
      } else {
         for(int i=0;i<6;i++){
            tileToBeCreated.setTileEdgeFeature(i,featureType);
         }
         switch(rivers.size()){
            case 0: tileToBeCreated.setTileEdgeFeature(0,rivers.get(0));
               break;
            case 1: tileToBeCreated.setTileEdgeFeature(0,rivers.get(0));
               break;
            case 2: tileToBeCreated.setTileEdgeFeature(3,rivers.get(0));
                    tileToBeCreated.setTileEdgeFeature(5,rivers.get(1));
               break;
            case 3:
               tileToBeCreated.setTileEdgeFeature(3,rivers.get(0));
               tileToBeCreated.setTileEdgeFeature(5,rivers.get(1));
               tileToBeCreated.setTileEdgeFeature(1,rivers.get(2));
               break;
         }

      }
      return tileToBeCreated;
   }

   public Tile execute(TileTypeCommand command){}


}
