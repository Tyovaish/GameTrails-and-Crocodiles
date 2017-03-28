package Controller.Commands;

import Model.Location;
import Model.TilePlacementManager;
import javafx.geometry.Orientation;

/**
 * Created by Trevor on 3/28/2017.
 */
public class TilePlacementCommand implements Command {
    TilePlacementManager tilePlacementManager;
    Location location;
    Orientation orientation;
}
