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
      int rotation =0;
      System.out.println("hel"+ riverEdges.length);
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

      switch (riverEdges.length){
         case 1:{
            rotation = riverEdges[0];
            break;
         }
         case 2:{
            if(riverEdges[0] == 1 && riverEdges[1]==3)
               rotation = 0;
            else if(riverEdges[0] == 2 && riverEdges[1]==4)
               rotation = 1;
            else if(riverEdges[0] == 3 && riverEdges[1]==5)
               rotation = 2;
            else if(riverEdges[0] == 4 && riverEdges[1]==6)
               rotation = 3;
            else if(riverEdges[0] == 5 && riverEdges[1]==1)
               rotation = 4;
               else if(riverEdges[0] == 6 && riverEdges[1]==2)
                  rotation = 5;
            break;
         }
         case 3:{
            if(riverEdges[0] == 6 && riverEdges[1]==2 && riverEdges[2]==4)
               rotation = 0;
            else if(riverEdges[0] == 1 && riverEdges[1]==3 && riverEdges[2]==5)
               rotation = 1;
            else if(riverEdges[0] == 2 && riverEdges[1]==4 && riverEdges[2]==6)
               rotation = 2;
            else if(riverEdges[0] == 3 && riverEdges[1]==5 && riverEdges[2]==1)
               rotation = 3;
            else if(riverEdges[0] == 4 && riverEdges[1]==6 && riverEdges[2]==2)
               rotation = 4;
            else if(riverEdges[0] == 5 && riverEdges[1]==1 && riverEdges[2]==3)
               rotation = 5;
            break;
         }
      }
      return new Tile(featureType,copyTileEdges,new TileOrientation(rotation),riverEdges.length);
   }
}
