package Model;

import Controller.Commands.RemoveCommand;
import Controller.Commands.TilePlacementCommand;
import Controller.Commands.TileTypeCommand;
import Model.Tile.Tile;
import Model.Tile.TileBuilder;

public class TileCommandDispatcher {
    private TileBuilder tileBuilder;
    private TilePlacementManager tilePlacementManager;
    private Tile currentTile;

    public TileCommandDispatcher(TileBuilder tileBuilder, TilePlacementManager tilePlacementManager) {
        this.tileBuilder = tileBuilder;
        this.tilePlacementManager = tilePlacementManager;
    }

    public void addNewTile(TileTypeCommand typeCommand, TilePlacementCommand placementCommand){
        execute(typeCommand);
        execute(placementCommand);
    }
    public void removeTile(RemoveCommand command){ execute(command); }

    private void execute(TileTypeCommand command){ currentTile = tileBuilder.execute(command); }
    private void execute(TilePlacementCommand command){
        tilePlacementManager.execute(currentTile, command);
        currentTile = null;
    }
    private void execute(RemoveCommand command){ tilePlacementManager.execute(command); }

    public TileBuilder getTileBuilder() { return tileBuilder; }
    public TilePlacementManager getTilePlacementManager() { return tilePlacementManager; }
    public Tile getCurrentTile() { return currentTile; }

    public void setTileBuilder(TileBuilder tileBuilder) { this.tileBuilder = tileBuilder; }
    public void setTilePlacementManager(TilePlacementManager tilePlacementManager) { this.tilePlacementManager = tilePlacementManager; }
    public void setCurrentTile(Tile currentTile) { this.currentTile = currentTile; }
}
