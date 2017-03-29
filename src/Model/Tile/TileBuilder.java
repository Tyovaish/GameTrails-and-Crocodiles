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
   static Tile TileBuilder(FeatureType featureType,ArrayList<TileEdge> tileEdges, TileOrientation orientation){
      for(int i=0;i<tileEdges.size();i++){
         if(tileEdges.get(i)==null){
            tileEdges.get(i).setFeatureType(featureType);
         }
      }
       return new Tile(tileEdges,orientation);
   }

   public Tile execute(TileTypeCommand command){
       Tile tileToBeCreated = new Tile();
       FeatureType featureType = command.getFeatureType();
       ArrayList<River> rivers = command.getRivers();

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
}
