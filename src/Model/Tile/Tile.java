package Model.Tile;




import Model.Tile.FeatureTypes.FeatureType;



public class Tile {
    FeatureType feature;
    TileEdge [] tileEdges;
    TileOrientation orientation;
    int numberOfRivers;

    public Tile(){
      tileEdges=new TileEdge[6];
    }

    public Tile(FeatureType feature,TileEdge [] tileEdges, TileOrientation orientation,int numberOfRivers){
        this.feature=feature;
        this.numberOfRivers=numberOfRivers;
        this.tileEdges=new TileEdge[6];
        this.orientation=orientation;
        for(int i=0;i<this.tileEdges.length;i++){
            this.tileEdges[i]=tileEdges[((i-orientation.getRotations()+6)%this.tileEdges.length)];
        }
    }
    public TileEdge getTileEdge(int tileEdgePosition){
        return tileEdges[tileEdgePosition];
    }
    public TileEdge[] getTileEdges() { return tileEdges; }
    public String getTileType(){return this.feature.getType();}
    public int getTileOrientation(){return this.orientation.getRotations();}
    public int getNumberOfRivers(){return this.numberOfRivers;}
    public void  setTileEdgeFeature(int tileEdgeFeaturePosition, FeatureType feature){tileEdges[tileEdgeFeaturePosition].setFeatureType(feature);}
    public FeatureType getTileEdgeFeature(int tileEdgePosition){
        return tileEdges[tileEdgePosition].getFeatureType();
    }

    public boolean checkEdgeCompatabilty(int tileEdgePositionToCheck, FeatureType otherTilesFeature){
        return tileEdges[tileEdgePositionToCheck].equals(otherTilesFeature);
    }
    public void print(){
        for(int i=0;i<tileEdges.length;i++){
            System.out.print(i);
            tileEdges[i].print();
        }
    }

}
