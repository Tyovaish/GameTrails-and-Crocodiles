package GUI.dashButtons;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lazaro on 4/3/2017.
 */
public class buttonPanel extends JPanel {
    private loadButton load = new loadButton();
    private saveButton save = new saveButton();
    private startGameButton start = new startGameButton();

    private void createPanel(){
        setPreferredSize(new Dimension(500, 100));
        setBackground(Color.black);
        add(save);
        add(load);
        add(start);
    }

    public buttonPanel(){
        createPanel();
    }
}
