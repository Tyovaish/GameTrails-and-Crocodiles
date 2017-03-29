package Model.Tile.FeatureTypes;

import Model.Tile.TileEdge;

/**
 * Created by khariollivierre on 3/29/17.
 */
public class RiverLink {
    private TileEdge prev;
    private TileEdge next;

    public RiverLink(){
        prev = null;
        next = null;
    }
    public RiverLink(TileEdge prev){
        this.prev = prev;
        this.next = null;
    }

    public TileEdge getPrev() { return prev; }
    public TileEdge getNext() { return next; }

    public void setPrev(TileEdge prev) { this.prev = prev; }
    public void setNext(TileEdge next) { this.next = next; }
}
