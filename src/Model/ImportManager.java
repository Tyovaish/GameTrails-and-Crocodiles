/**
 * Created by larry on 3/28/2017.
 */

package Model;

import Controller.Commands.TilePlacementCommand;
import Model.Tile.FeatureTypes.FeatureType;
import Model.Tile.FeatureTypes.River.NormalRiver;
import Model.Tile.FeatureTypes.River.SourceRiver;
import Model.Tile.FeatureTypes.Sea.Sea;
import Model.Tile.FeatureTypes.Terrain.*;
import Model.Tile.TileBuilder;
import Model.Tile.TileEdge;
import Model.Tile.TileOrientation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;

class ImportManager {
    private Map impMap = new Map();
    private TilePlacementCommand tilePlacementCommand = new TilePlacementCommand();
    private TileBuilder tileBuilder = new TileBuilder();

    ImportManager()
    {
        File mapFile;
        String file = "src/Model/mapTest.txt";
        String currentLine;
        //could create string input here to get any txt file
        Boolean executable;
        Boolean correctFile;

        try
        {
            mapFile = new File(file);
            System.out.println(mapFile.getAbsolutePath());
            FileReader fileReader = new FileReader(mapFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            executable = mapFile.canExecute(); //if File is excuteable
            currentLine = bufferedReader.readLine();//read the first line
            correctFile = checkFileStart(currentLine);//check for "Start Map" else text file is wrong
            if(executable && correctFile) {
                currentLine = bufferedReader.readLine();
                while ( !currentLine.equals("End Map")) {
                    convertTextToCommands(currentLine);
                    currentLine = bufferedReader.readLine();
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

    private Boolean checkFileStart(String firstLine){
        return firstLine.equals("Begin Map");
    }

    private void convertTextToCommands(String line){

        int numOfRivers = 0;
        //first get location
        Location location;
        int x;
        int y;
        int z;
        int row;
        int col;
        FeatureType featureType;
        TileEdge tileEdges[] = new TileEdge[6];
        TileOrientation orientation = new TileOrientation(0);
        String smallString; //slowly holds less of the string
        String substr = line.substring(8, line.indexOf(" "));
        x = Integer.parseInt(substr);
        smallString = line.substring(line.indexOf(" ")+1);//start of y
        substr = smallString.substring(0, smallString.indexOf(" "));
        y = Integer.parseInt(substr);
        smallString = smallString.substring(substr.length()+1);//start of z
        substr = smallString.substring(0, smallString.indexOf(")"));
        System.out.println(substr);
        z = Integer.parseInt(substr);
        row = z + (x - (x+1)) / 2;
        col = x;
        location = new Location(row,col);
        tilePlacementCommand.setLocation(location);

        //next get terrain type
        String terrainType;
        smallString = smallString.substring(substr.length()+2);//start of terrainType
        System.out.println(smallString);
        substr = smallString.substring(0, smallString.indexOf(" "));
        System.out.println(substr);
        terrainType = substr;
        if(terrainType.equals("desert")) {
            featureType = new Desert();
        }
        else if(terrainType.equals("mountain")){
            featureType = new Mountain();
        }
        else if(terrainType.equals("pasture")) {
            featureType = new Pasture();
        }
        else if(terrainType.equals("rock")) {
            featureType = new Rock();
        }
        else if(terrainType.equals("woods")){
            featureType = new Woods();
        }
        else{
            featureType = new Sea();
        }

        //next attempt to get rivers
        System.out.println(line);
        System.out.println(line.endsWith("()"));
        System.out.println(terrainType.equals("sea"));
        if (!line.endsWith("()") || terrainType.equals("sea")){
            //get River faces
            int riverFace[] = new int[3];
            smallString = smallString.substring(substr.length()+2);//start of first River face
            substr = smallString.substring(0, 1);//1-6, therefore length = 1
            riverFace[numOfRivers] = Integer.parseInt(substr);
            numOfRivers++;
            smallString = smallString.substring(2);//start of second River face
            if (!smallString.equals(")")){//more Rivers!
                substr = smallString.substring(0, 1);
                riverFace[numOfRivers] = Integer.parseInt(substr);
                numOfRivers++;
                smallString = smallString.substring(2);//start of second River face
                if (!smallString.equals(")")) {//more Rivers!
                    substr = smallString.substring(0, 1);
                    riverFace[numOfRivers] = Integer.parseInt(substr);
                    numOfRivers++;
                }
            }
            if (numOfRivers != 0 && numOfRivers != 1){
                for(int i = 0; i < numOfRivers; i++){
                    NormalRiver river = new NormalRiver();
                    tileEdges[riverFace[i]].setFeatureType(river);
                }
            }
            else if(numOfRivers == 1){
                FeatureType river = new SourceRiver();
                tileEdges[riverFace[0]].setFeatureType(river);
            }
            for(int i = 0;i < 6; i++){
                if(tileEdges[i].getFeatureType() == null){
                    tileEdges[i].setFeatureType(featureType);
                }
            }
        }
        impMap.map[row][col] = tileBuilder.createTile(featureType, tileEdges, orientation);
    }

}



