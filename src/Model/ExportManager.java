package Model.Tile;

import Model.Map;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Trevor on 3/29/2017.
 */
public class ExportManager {
    Map map;
    public ExportManager(Map map){

    }
    public void export(){
        try{
            PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");

            writer.close();
        } catch (IOException e) {
            // do something
        }
    }

}
