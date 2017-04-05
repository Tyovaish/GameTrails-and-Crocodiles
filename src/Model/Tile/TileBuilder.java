package Model.Tile;

import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.NormalRiver;
import Model.Tile.FeatureTypes.River.River;
import Model.Tile.FeatureTypes.Sea.Sea;
import Model.Tile.FeatureTypes.Terrain.Woods;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/28/2017.
 */
public class TileBuilder {
   public static Tile createTile(FeatureType featureType,TileEdge[] tileEdges, TileOrientation orientation){
      int numberOfRivers=0;
      TileEdge [] copyTileEdges =new TileEdge[6];
      for(int i=0;i<tileEdges.length;i++){
         if(tileEdges[i]==null){
            tileEdges[i]=new TileEdge();
            tileEdges[i].setFeatureType(featureType);
         } else {
            numberOfRivers++;
         }
      }
      for(int i=0;i<6;i++){
         copyTileEdges[i]=new TileEdge();
         copyTileEdges[i].setFeatureType(tileEdges[i].getFeatureType());
      }
     TileOrientation  copyOrientation=new TileOrientation(orientation.getRotations());

      return new Tile(featureType,copyTileEdges,copyOrientation,numberOfRivers);
   }
   public static Tile createTile(FeatureType featureType,int[] riverEdges){
      TileEdge [] copyTileEdges=new TileEdge[6];
      for(int i=0;i<6;i++){
        for(int j=0;j<riverEdges.length;j++){
           if(i==riverEdges[j]){
              TileEdge temp=new TileEdge();
              copyTileEdges[i]=temp;
              temp.setFeatureType(new NormalRiver());
           }
        }
      }
      for(int i=0;i<6;i++){
        if(copyTileEdges[i]==null){
           TileEdge temp=new TileEdge();
           copyTileEdges[i]=temp;
           temp.setFeatureType(featureType);
        }
      }
      return new Tile(featureType,copyTileEdges,new TileOrientation(0),riverEdges.length);
   }
}
