package Model.Tile.FeatureTypes;

import Model.Tile.TileEdge;

/**
 * Created by khariollivierre on 3/29/17.
 */
public class RiverLink {
    private FeatureType prev;
    private FeatureType next;

    public RiverLink(){
        prev = null;
        next = null;
    }
    public RiverLink(FeatureType prev){
        this.prev = prev;
        this.next = null;
    }

    public FeatureType getPrev() { return prev; }
    public FeatureType getNext() { return next; }

    public void setPrev(FeatureType prev) { this.prev = prev; }
    public void setNext(FeatureType next) { this.next = next; }
}
