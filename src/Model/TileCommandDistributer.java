package Model;

import Controller.Commands.TilePlacementCommand;
import Controller.Commands.TileTypeCommand;
import Model.Tile.Tile;
import Model.Tile.TileBuilder;

public class TileCommandDistributer {
    private TileBuilder tileBuilder;
    private TilePlacementManager tilePlacementManager;
    private Tile currentTile;

    public TileCommandDistributer(TileBuilder tileBuilder, TilePlacementManager tilePlacementManager) {
        this.tileBuilder = tileBuilder;
        this.tilePlacementManager = tilePlacementManager;
    }

    public void execute(TileTypeCommand command){ currentTile = tileBuilder.execute(command); }
    public void execute(TilePlacementCommand command){ tilePlacementManager.execute(currentTile, command); }

    public TileBuilder getTileBuilder() { return tileBuilder; }
    public TilePlacementManager getTilePlacementManager() { return tilePlacementManager; }
    public Tile getCurrentTile() { return currentTile; }

    public void setTileBuilder(TileBuilder tileBuilder) { this.tileBuilder = tileBuilder; }
    public void setTilePlacementManager(TilePlacementManager tilePlacementManager) { this.tilePlacementManager = tilePlacementManager; }
    public void setCurrentTile(Tile currentTile) { this.currentTile = currentTile; }
}
