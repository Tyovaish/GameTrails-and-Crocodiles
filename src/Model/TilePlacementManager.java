package Model;

import Controller.Commands.RemoveCommand;
import Controller.Commands.TilePlacementCommand;
import Controller.Commands.TileTypeCommand;
import Model.Tile.Tile;
import Model.Tile.TileBuilder;
import Model.Tile.TileEdge;

/**
 * Created by Trevor on 3/25/2017.
 */
public class TilePlacementManager {
    Map map;
   public TilePlacementManager(Map map){
        this.map=map;
    }

    public void execute(RemoveCommand removeCommand){
        map.removeTile(removeCommand.getLocation());
    }

    public void execute(Tile tile, TilePlacementCommand command){
        if(riverLinking(tile, command.getLocation())) map.insertTile(tile, command.getLocation());
    }

    public Boolean riverLinking(Tile tile, Location location){
        TileEdge[] edges = tile.getTileEdges();
        Tile[] neighbors = map.getNeighbors(location);
        Tile neighbor;
        TileEdge neighborEdge;
        String type;
        String tileType = tile.getFeature().getType();
        Boolean valid = true;
        Boolean noRiver = true;

        for (TileEdge edge : edges){
            if(edge.hasRiver()){ noRiver = false; }
        }
        if(noRiver){ return noRiver; }

        int edgeCounter = 0;
        for(TileEdge edge : edges) {
            type = edge.getFeatureType().getType();
            neighbor = neighbors[edgeCounter];
            try {
                switch (edgeCounter) {
                    case 0:
                        neighborEdge = neighbor.getTileEdge(3);
                    case 1:
                        neighborEdge = neighbor.getTileEdge(4);
                    case 2:
                        neighborEdge = neighbor.getTileEdge(5);
                    case 3:
                        neighborEdge = neighbor.getTileEdge(0);
                    case 4:
                        neighborEdge = neighbor.getTileEdge(1);
                    case 5:
                        neighborEdge = neighbor.getTileEdge(2);
                    default:
                        neighborEdge = null;
                }
            } catch (NullPointerException e) { neighborEdge = new TileEdge(); }

            if (edge.isSource()){ return true; }
            if(edge.hasRiver() && !edge.isSource() && neighborEdge != null){
                if (neighborEdge.isSource()){
                    System.out.println("Neighbor is source");
                    for (TileEdge edge1 : edges){
                        if (edge1.hasRiver()){
                            System.out.println("River source set");
                            edge1.setSource(true);
                        }
                    }
                    return true;
                } else valid = false;
            } else if (edge.hasRiver() && neighborEdge == null){ valid = false; }
            edgeCounter++;
        }
        if(!valid){ System.out.println("INVALID PLACEMENT"); }
        return valid;
    }



}
