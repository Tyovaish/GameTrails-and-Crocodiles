package Model;

import Model.Tile.Tile;
import Model.Tile.TileEdge;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by khariollivierre on 3/28/17.
 */
public class RiverManager {
    /*
        RIVER LINKED LIST
            If TileEdge is source or sea...
                Start new linked list OR Add it to existing linked list
            If TileEdge is normal river...
                Add to existing linked list OR not valid placement
     */
    public boolean checkValidity(Tile tile){
        ArrayList<TileEdge> edges = tile.getTileEdges();
        for (TileEdge edge : edges){
            if (edge.getFeatureType() )
        }
    }

}
