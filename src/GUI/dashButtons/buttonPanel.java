package GUI.dashButtons;

import Model.Map;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lazaro on 4/3/2017.
 */
public class buttonPanel extends JPanel {
    private loadButton load = new loadButton();
    private saveButton save;
    private startGameButton start = new startGameButton();

    private void createPanel(){
        setPreferredSize(new Dimension(500, 100));
        setBackground(Color.black);
    }

    public buttonPanel(Map board){
        createPanel();
        save = new saveButton(board);
        add(save);
        add(load);
        add(start);
    }
}
