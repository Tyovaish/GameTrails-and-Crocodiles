package Model;

import Model.Map;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Trevor on 3/29/2017.
 */
public class ExportManager {
    Map map;
    public ExportManager(Map map){
        this.map=map;
    }
    public void export(){
        try{
            PrintWriter writer = new PrintWriter("map.txt", "UTF-8");
            for(int i=0;i<map.BSIZE;i++){
                for (int j=0;j<map.BSIZE;j++){
                    if(map.getTile(i,j)!=null){
                        int xPosition=i;
                        int yPosition=j;
                        int zPosition=-1*(i+j);
                        writer.println("("+xPosition+" "+yPosition+" "+zPosition+") "+map.getTile(i,j).printForExport());
                    }
                }
            }
            for(int i=0;i<map.BSIZE;i++){
                for (int j=0;j<map.BSIZE;j++){
                    if(map.getTile(i,j)!=null){
                        int xPosition=i;
                        int yPosition=j;
                        int zPosition=-1*(i+j);
                        writer.println("("+xPosition+" "+yPosition+" "+zPosition+") "+map.getTile(i,j).printForExport());
                    }
                }
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

}
