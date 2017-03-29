package Model.Tile.FeatureTypes;

import Model.Tile.TileEdge;

/**
 * Created by Trevor on 3/25/2017.
 */
public abstract class FeatureType {
        private String featureType;
        private RiverLink riverLink = new RiverLink();


    public void addType(String type){
            this.featureType= type;
        }


    public String getType(){
            return this.featureType;
        }
    public RiverLink getRiverLink(){ return riverLink; }
    public FeatureType getLinkPrev(){ return riverLink.getPrev(); }
    public FeatureType getLinkNext(){ return riverLink.getNext(); }

    public void setRiverLink(RiverLink riverLink) { this.riverLink = riverLink; }
    public void setLinkPrev(FeatureType feature){ riverLink.setPrev(feature); }
    public void setLinkNext(FeatureType feature){ riverLink.setNext(feature); }

    abstract public void print();

}
