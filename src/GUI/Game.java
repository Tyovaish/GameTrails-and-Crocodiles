package GUI;

import Controller.Controller;
import Model.Map;

/**
 * Created by Lazaro on 3/29/2017.
 */
public class Game {
    private Map map;
    private Display display;
    private Controller ctrl;

    public Game(){
        map = new Map();
        ctrl  = new Controller(map);
        display = new Display(map,ctrl);
    }
}
