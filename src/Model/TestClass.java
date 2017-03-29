package Model;

import Controller.Controller;
import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.NormalRiver;
import Model.Tile.FeatureTypes.River.River;
import Model.Tile.FeatureTypes.River.SourceRiver;
import Model.Tile.FeatureTypes.Terrain.Mountain;
import Model.Tile.FeatureTypes.Terrain.Woods;
import Model.Tile.Tile;
import Model.Tile.TileBuilder;
import Model.Tile.TileEdge;
import Model.Tile.TileOrientation;
import javafx.geometry.Orientation;

import javax.naming.ldap.Control;
import java.util.ArrayList;

/**
 * Created by Trevor on 3/28/2017.
 */
public class TestClass {
    public static void main(String args[]){
        FeatureType featureType=new Woods();
        TileEdge [] tileEdges=new TileEdge[6];
        tileEdges[0]=new TileEdge();
        FeatureType t=new SourceRiver();
        FeatureType A=new Mountain();
        System.out.println(t.getClass().equals(A.getClass()));
        tileEdges[0].setFeatureType(new SourceRiver());
        TileOrientation orientation=new TileOrientation(0);
        FeatureType featureType1=new Mountain();
        TileEdge [] tileEdges1=new TileEdge[6];
        tileEdges1[2]=new TileEdge();
        tileEdges1[2].setFeatureType(new SourceRiver());
        TileOrientation orientation1=new TileOrientation(1);
        Map map=new Map();
        Location location=new Location(3,2);
        map.insertTile(TileBuilder.createTile(featureType,tileEdges,orientation), new Location(3,2));
        map.insertTile(TileBuilder.createTile(featureType1,tileEdges1,orientation1), location.getNorth());
        map.print();

    }
}
