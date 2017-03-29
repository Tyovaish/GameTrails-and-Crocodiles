package Model;

import Controller.Commands.RemoveCommand;
import Controller.Commands.TilePlacementCommand;
import Controller.Commands.TileTypeCommand;
import Model.Tile.Tile;
import Model.Tile.TileBuilder;
import Model.Tile.TileOrientation;

/**
 * Created by Trevor on 3/25/2017.
 */
public class TilePlacementManager {
    Map map;
   public TilePlacementManager(Map map){
        this.map=map;
    }

    public void execute(RemoveCommand removeCommand){}
    public void execute(Tile tile, TileTypeCommand tileTypeCommand){}
    public void execute(Tile tile, TilePlacementCommand tilePlacementCommand){
        Location location = tilePlacementCommand.getLocation();
        map.insertTile(tile, location);
    }



}
