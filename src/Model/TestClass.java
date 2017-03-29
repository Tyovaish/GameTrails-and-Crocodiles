package Model;

import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.NormalRiver;
import Model.Tile.FeatureTypes.Terrain.Mountain;
import Model.Tile.FeatureTypes.Terrain.Woods;
import Model.Tile.Tile;
import Model.Tile.TileBuilder;
import Model.Tile.TileEdge;
import Model.Tile.TileOrientation;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/28/2017.
 */
public class TestClass {
    public static void main(String args[]){
        FeatureType featureType=new Woods();
        TileEdge[] testTileEdges= new TileEdge[6];
        testTileEdges[1]=new TileEdge();
        testTileEdges[1].setFeatureType(new NormalRiver());
        FeatureType featureType2=new Mountain();
        TileEdge [] tileEdges2=new TileEdge[6];
        TileOrientation orientation=new TileOrientation(0);
        Tile testTile= TileBuilder.createTile(featureType,testTileEdges,orientation);
        testTile.print();
    }
}
