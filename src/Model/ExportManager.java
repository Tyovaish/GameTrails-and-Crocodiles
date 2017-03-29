/**
 * Created by larry on 3/28/2017.
 */
/*package Model;
import Model.Tile.Tile;

import java.io.File;
import java.io.IOException;

public class ExportManager { //it isn't finished
    Map map;
    File mapFile = null;
    String file = "mapTest.txt";
    String currentLine;

    public void convertMapToText(Map map){
        try {
            mapFile = new File(file);
            if (mapFile.createNewFile()) {
                System.out.println("File is created!");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.map = map;
        for(int i = 0; i < 21; i++){
            for(int j = 0; j < 21; j++){
                //map.getTile(i, j);
                //when you get the first Tile that exists

            }
        }
    }

    public String tileToString(Tile tile, int row, int col){
        int numRivers;

        int x = col;
        int z = row - (col - (col+1)) / 2;
        int y = -x-z;

        String line = "Tile::=(" + Integer.toString(x);
        line += " " + Integer.toString(y);
        line += " " + Integer.toString(z) + ") ";

        for(int i = 0; i < 6; i++){
            if(tile.getTileType() == "sea"){
                i=6;
                line+="sea ()";
            }
            else if (tile.getTileType().contains("river") || tile.getTileType().contains("sourceRiver")|| tile.getTileType().contains("normalRiver")){

            }
        }
        return line;
    }
}
*/
