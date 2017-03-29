package Model.Tile.FeatureTypes.River;

import Model.Tile.FeatureTypes.RiverLink;

/**
 * Created by Trevor on 3/25/2017.
 */
public class SourceRiver extends River {
    String type = "source";
    public SourceRiver(){
        addType(type);
        setLinkPrev(this);
    }
}
