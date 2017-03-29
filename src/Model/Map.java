package Model;

import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.NormalRiver;

import Model.Tile.Tile;
import Model.Tile.TileEdge;


/**
 * Created by Trevor on 3/25/2017.
 */
public class Map {
    TilePlacementManager tilePlacementManager;
    RiverConnectionManager riverConnectionManager;
    final int BSIZE = 10;
    protected Tile[][] map;


    //CREATING THE GAME MAP
    public Map(){
        map = new Tile[BSIZE][BSIZE];
    }

    public String getTileType(int x, int y){
        if(map[x][y] != null)
        return map[x][y].getTileType();
    else
        return null;
    }
    public int getTileOrientation(int x, int y){
        if(map[x][y]!=null) {
            return map[x][y].getTileOrientation();
        }
        return 0;
    }
    public int getTileNumberOfRivers(int x, int y){
        if(map[x][y]!=null) {
            return map[x][y].getNumberOfRivers();
        }
        return 0;
    }

    public boolean checkcoordinates(int x, int y){
        if(x < 0 || x >= map[0].length)
            return false;
        else if(y < 0 || y >= map[1].length)
            return false;
        else
            return true;
    }

    public void insertTile(Tile tile, Location location) {
        if (riverLinking(tile, location)){ map[location.getX()][location.getY()]=tile; }
    }

    private Boolean riverLinking(Tile tile, Location location){
        TileEdge[] edges = tile.getTileEdges();
        Tile[] neighbors = getNeighbors(location);
        Tile neighbor;
        TileEdge neighborEdge;
        String type;
        String tileType = tile.getFeature().getType();
        Boolean valid = false;
        Boolean noRiver = true;

        int edgeCounter = 0;
        for (TileEdge edge : edges){
            if (edge.getFeatureType().getType() != tileType){
                noRiver = false;
            }
        }
        if(noRiver){ return noRiver; }

        for(TileEdge edge : edges){
            type = edge.getFeatureType().getType();
            neighbor = neighbors[edgeCounter];
            try{
                switch (edgeCounter) {
                    case 0: neighborEdge = neighbor.getTileEdge(3);
                    case 1: neighborEdge = neighbor.getTileEdge(4);
                    case 2: neighborEdge = neighbor.getTileEdge(5);
                    case 3: neighborEdge = neighbor.getTileEdge(0);
                    case 4: neighborEdge = neighbor.getTileEdge(1);
                    case 5: neighborEdge = neighbor.getTileEdge(2);
                    default: neighborEdge = null;
                }
            } catch (NullPointerException e){ neighborEdge = null; }
            if(type == "sea"){
                if(neighborEdge.getLinkPrev() == null || neighborEdge == null){ edge.setLinkPrev(edge); }
                else{
                    edge.setLinkPrev(neighborEdge);
                    neighborEdge.setLinkNext(edge);
                    valid = true;
                }
            }
            if(type == "source"){
                if(neighborEdge.getLinkPrev() == null || neighborEdge == null){ edge.setLinkPrev(edge); }
                else{
                    edge.setLinkPrev(neighborEdge);
                    neighborEdge.setLinkNext(edge);
                    valid = true;
                }
            }
            if(type == "normalriver" && neighborEdge != null){
                if (edge.getLinkPrev() == null){
                    if(neighborEdge.getLinkPrev() == null){ valid = false; }
                    else{
                        edge.setLinkPrev(neighborEdge);
                        neighborEdge.setLinkNext(edge);
                        for (TileEdge nestedEdge : edges){
                            if (nestedEdge != edge
                                    && nestedEdge.getFeatureType().getType() == "normalriver"
                                    && nestedEdge.getLinkPrev() == null){
                                nestedEdge.setLinkPrev(edge);
                            }
                        }
                        valid = true;
                    }
                }
            }
            edgeCounter++;
        }
        if (!valid) System.out.println("INVALID PLACEMENT");
        return valid;
    }
/*    private boolean checkTileInsertionEligibilty(Tile tile, Location location,TileOrientation orientation){
        Tile[] tilesToBeChecked=getNeighbors(location);
        for(int i=0;i<tilesToBeChecked.length;i++) {
            Tile tileToBeCheckedBasedOnTileInserted = tilesToBeChecked[i];
            if(!(tileToBeCheckedBasedOnTileInserted==null)) {
                if (!tile.getTileEdge(i).tileEdgeFeatureEqual(tileToBeCheckedBasedOnTileInserted.getTileEdge((i + 3) % 6).getFeatureType())){
                    return false;
                }
            }

        }
        return true;
    } */
    private Tile[] getNeighbors(Location location){
        //This is bad need to change eventually.  TDA but I havent figured a better way
        Tile[] tileToBeReturned=new Tile[6];
        Location northLocation=location.getNorth();
        Location southLocation=location.getSouth();
        Location southEastLocation=location.getSouthEast();
        Location southWestLocation=location.getSouthWest();
        Location northEastLocation=location.getNorthEast();
        Location northWestLocation=location.getNorthWest();
        if(checkcoordinates(northLocation.getX(),northLocation.getY())){
            tileToBeReturned[0]=map[northLocation.getX()][northLocation.getY()];
            
        } else {
            tileToBeReturned[0]=null;
        }
        if(checkcoordinates(northEastLocation.getX(),northEastLocation.getY())){
            tileToBeReturned[1]=map[northEastLocation.getX()][northEastLocation.getY()];

        } else {
            tileToBeReturned[1]=(null);
        }
        if(checkcoordinates(southEastLocation.getX(),southEastLocation.getY())){
            tileToBeReturned[2]=map[southEastLocation.getX()][southEastLocation.getY()];

        } else {
            tileToBeReturned[2]=null;
        }

        if(checkcoordinates(southLocation.getX(),southLocation.getY())){
            tileToBeReturned[3]=map[southLocation.getX()][southLocation.getY()];

        } else {
            tileToBeReturned[3]=null;
        }
        if(checkcoordinates(southWestLocation.getX(),southWestLocation.getY())){
            tileToBeReturned[4]=map[southWestLocation.getX()][southWestLocation.getY()];

        } else {
            tileToBeReturned[4]=null;
        }
        if(checkcoordinates(northWestLocation.getX(),northWestLocation.getY())){
            tileToBeReturned[5]=map[northWestLocation.getX()][northWestLocation.getY()];

        } else {
            tileToBeReturned[5]=null;
        }
        return tileToBeReturned;
    }
    public void removeTile(Location location){
        map[location.getX()][location.getY()]=null;
    }
    public void print(){
        for(int i=0;i<BSIZE;i++){
            for(int j=0;j<BSIZE;j++){
                if(map[i][j]!=null){
                    System.out.println("Position: "+i+","+j);
                    map[i][j].print();
                }
            }
        }
    }

}
