/**
 * Created by larry on 3/28/2017.
 */
package Model;
import Model.Tile.Tile;

import java.io.*;

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
                FileWriter writer = new FileWriter(mapFile);
                writer.write("BEGIN MAP\n");
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
                //currentLine = tileToString(tile, i, j);
                //writer.write(currentLine);
                //writer.write("\n");
            }
        }
    }

    public String tileToString(Tile tile, int row, int col){
        int riverFaces[] = new int[3];
        int numRivers = 0;

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
            else if (tile.getTileType().contains("river")){
                riverFaces[numRivers] = i;
                numRivers++;
            }
            else
                line+=tile.getTileType() + " ";
        }
        if(numRivers == 0){
            line+="()";
        }
        else {
            line += "(";
            for(int i = 0; i < numRivers; i++) {
                line += Integer.toString(riverFaces[i]) + " ";
            }
            line+=")";
        }
        return line;
    }
}

