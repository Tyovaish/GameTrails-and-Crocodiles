package Model;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Trevor on 3/29/2017.
 */
public class ExportManager {
    private Map map;
    public ExportManager(Map map){
        this.map=map;
    }
    public void export(){
        try{
            File ExFile = new File("./src/newFile.txt");
            PrintWriter writer = new PrintWriter(ExFile, "UTF-8");
            writer.println("Tile::=( ");
            for(int i=0;i<map.BSIZE;i++){
                for (int j=0;j<map.BSIZE;j++){
                    if(map.getTile(i,j)!=null){
                        int xPosition=i;
                        int yPosition=j;
                        int zPosition=-1*(i+j);
                        writer.println( xPosition + " " + yPosition + " " + zPosition + ") "+map.getTile(i,j).printForExport());
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

}
