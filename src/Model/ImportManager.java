/**
 * Created by larry on 3/28/2017.
 */
package Model;

import Controller.Commands.TilePlacementCommand;
import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.NormalRiver;
import Model.Tile.FeatureTypes.River.River;
import Model.Tile.FeatureTypes.River.SourceRiver;
//import Model.TileCommandDistributer;
import Controller.Commands.TileTypeCommand;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;

public class ImportManager {
    TilePlacementCommand tilePlacementCommand = new TilePlacementCommand();
    //TileCommandDistributer tileCommandDistributer;
    TileTypeCommand tileTypeCommand = new TileTypeCommand();
    private FeatureType featureType;
    public ImportManager()
    {
        File mapFile = null;
        String file = "mapTest.txt";
        String currentLine;
        //could create string input here to get any txt file
        Boolean executable;
        Boolean correctFile;

        try
        {
            mapFile = new File(file);
            FileReader fileReader = new FileReader(mapFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            executable = mapFile.canExecute(); //if File is excuteable
            currentLine = bufferedReader.readLine();//read the first line
            correctFile = checkFileStart(currentLine);//check for "Start Map" else text file is wrong
            if(executable && correctFile == true) {
                while ((currentLine = bufferedReader.readLine()) != null) {
                    convertTextToCommands(currentLine);
                }
            }
            else
                System.out.println("An incorrect file has been selected.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public Boolean checkFileStart(String firstLine){
        if(firstLine == "Begin Map"){
            return true;
        }
        else
            return false;
    }

    public void convertTextToCommands(String line){
        int numOfRivers = 0;
        //first get location
        Location location;
        int x;
        int y;
        int z;
        int row;
        int col;
        String smallString; //slowly holds less of the string
        String substr = line.substring(8, line.indexOf(" "));
        x = Integer.parseInt(substr);
        smallString = line.substring(line.indexOf(" ")+1);//start of y
        substr = smallString.substring(0, smallString.indexOf(" "));
        y = Integer.parseInt(substr);
        smallString = smallString.substring(substr.length()+1);//start of z
        substr = smallString.substring(0, smallString.indexOf(" "));
        z = Integer.parseInt(substr);
        row = z + (x - (x+1)) / 2;
        col = x;
        location = new Location(row,col);
        tilePlacementCommand.setLocation(location);
        //next get terrain type
        String terrainType;
        smallString = smallString.substring(substr.length()+2);//start of terrainType
        substr = smallString.substring(0, smallString.indexOf(" "));
        terrainType = substr;
        featureType.addType(terrainType);
        //next attempt to get rivers
        if (line.endsWith("()") == false || terrainType != "sea"){
            //get River faces
            int riverFace[] = new int[3];
            smallString = smallString.substring(substr.length()+2);//start of first River face
            substr = smallString.substring(0, 1);//1-6, therefore length = 1
            riverFace[numOfRivers] = Integer.parseInt(substr);
            numOfRivers++;
            smallString = smallString.substring(2);//start of second River face
            if (smallString != ")"){//more Rivers!
                substr = smallString.substring(0, 1);
                riverFace[numOfRivers] = Integer.parseInt(substr);
                numOfRivers++;
                smallString = smallString.substring(2);//start of second River face
                if (smallString != ")") {//more Rivers!
                    substr = smallString.substring(0, 1);
                    riverFace[numOfRivers] = Integer.parseInt(substr);
                    numOfRivers++;
                }
            }
            if (numOfRivers != 0 && numOfRivers != 1){
                for(int i = 0; i < numOfRivers; i++){
                    NormalRiver river = new NormalRiver();
                    tileTypeCommand.setRivers(river, riverFace[i]);
                }
            }
            else if(numOfRivers == 1){
                SourceRiver river = new SourceRiver();
                tileTypeCommand.setRivers(river, riverFace[0]);
            }
        }
    //tileCommandDistributer.addNewTile(tileTypeCommand, tilePlacementCommand);
    }

}

