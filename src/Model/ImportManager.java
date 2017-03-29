/**
 * Created by larry on 3/28/2017.
 */
package Model;

import Controller.Commands.TilePlacementCommand;
import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.NormalRiver;
import Model.Tile.FeatureTypes.River.SourceRiver;
import Model.TilePlacementManager;
import Controller.Commands.TileTypeCommand;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;

public class ImportManager {
    Map map;
    TilePlacementCommand tilePlacementCommand = new TilePlacementCommand();
    TilePlacementManager tilePlacementManager = new TilePlacementManager(map);
    TileTypeCommand tileTypeCommand = new TileTypeCommand();
    public ImportManager(Map map)
    {
        this.map = map;
        File mapFile = null;
        String file = "C:\\Users\\larry\\Desktop\\GameTrails-and-Crocodiles-master\\src\\Model\\mapTest.txt";
        String currentLine;
        //could create string input here to get any txt file
        Boolean executable;
        Boolean correctFile;

        try
        {
            mapFile = new File(file);
            System.out.println(mapFile.getCanonicalPath());
            FileReader fileReader = new FileReader(mapFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            executable = mapFile.canExecute(); //if File is excuteable
            System.out.println(String.valueOf(executable));
            currentLine = bufferedReader.readLine();//read the first line
            System.out.println(currentLine);
            correctFile = checkFileStart(currentLine);//check for "Start Map" else text file is wrong
            System.out.println(String.valueOf(correctFile));
            if(executable && correctFile == true) {
                System.out.println("Reading file...");
                currentLine = bufferedReader.readLine();
                while (!currentLine.equals("End Map") && checkCorrectPhrasing(currentLine)) {
                    convertTextToCommands(currentLine);
                    currentLine = bufferedReader.readLine();
                }
            }
            else
                System.out.println("An incorrect file has been selected.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private boolean checkCorrectPhrasing(String currentLine) {
        if(currentLine.contains("Tile::=(")){
            return true;
        }
        else
            return false;
    }

    public Boolean checkFileStart(String firstLine){
        if(firstLine.equals("Begin Map")){
            return true;
        }
        else
            return false;
    }

    public void convertTextToCommands(String line){
        System.out.println(line);
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
        System.out.println(substr);
        x = Integer.parseInt(substr);
        smallString = line.substring(line.indexOf(" ")+1);//start of y
        substr = smallString.substring(0, smallString.indexOf(" "));
        System.out.println(substr);
        y = Integer.parseInt(substr);
        smallString = smallString.substring(substr.length()+1);//start of z
        substr = smallString.substring(0, smallString.indexOf(" "));
        System.out.println(substr);
        z = Integer.parseInt(substr);
        row = z + (x - (x+1)) / 2;
        col = x;
        location = new Location(row,col);
        tilePlacementCommand.setLocation(location);
        //next get terrain type
        String terrainType;
        smallString = smallString.substring(substr.length()+3);//start of terrainType
        substr = smallString.substring(0, smallString.indexOf(" "));
        System.out.println(substr);
        terrainType = substr;
        System.out.println(terrainType);//test1
        //tileTypeCommand.setFeatureType(terrainType); NEED FEATURE, BROKEN
        //next attempt to get rivers
        if (!terrainType.equals("sea") || line.endsWith("()") == false){
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
        //tilePlacementManager.execute(tilePlacementCommand, tileTypeCommand); causes nullPointerException
    }

}


