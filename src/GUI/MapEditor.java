package GUI;

import Controller.Controller;
import Model.Map;

/**
 * Created by Lazaro on 3/29/2017.
 */
public class MapEditor {
    private Map map;
    private Display display;
    private Controller ctrl;

    public MapEditor(){
        map = new Map();
        ctrl  = new Controller(map);
        display = new Display(map,ctrl);
    }
}
