package Model;

import Controller.Commands.RemoveCommand;
import Controller.Commands.TilePlacementCommand;
import Controller.Commands.TileTypeCommand;
import Model.Tile.TileBuilder;

/**
 * Created by Trevor on 3/25/2017.
 */
public class TilePlacementManager {
    Map map;
   public TilePlacementManager(Map map){
        this.map=map;
    }
    public void execute(RemoveCommand removeCommand){

    }

    public void execute(TilePlacementCommand tilePlacementCommand, TileTypeCommand tileTypeCommand){
        TileBuilder.createTile(tileTypeCommand.getFeatureType(),tileTypeCommand.getTileEdgeList(),tilePlacementCommand.getOrientation());

    }



}
