package Model;

import Controller.Controller;
import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.NormalRiver;
import Model.Tile.FeatureTypes.Terrain.Mountain;
import Model.Tile.FeatureTypes.Terrain.Woods;
import Model.Tile.Tile;
import Model.Tile.TileBuilder;
import Model.Tile.TileEdge;
import Model.Tile.TileOrientation;

import javax.naming.ldap.Control;
import java.util.ArrayList;

/**
 * Created by Trevor on 3/28/2017.
 */
public class TestClass {
    public static void main(String args[]){
       Controller controller=new Controller(new Map(new MapObserver()));
       controller.nextState();
       controller.nextState();
       controller.nextState();
       controller.nextState();
       controller.forward();
       for(int i=0;i<7;i++) {
           controller.nextState();
       }
    }
}
