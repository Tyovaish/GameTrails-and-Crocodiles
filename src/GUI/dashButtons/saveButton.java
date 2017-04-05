package GUI.dashButtons;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lazaro on 4/4/2017.
 */
public class saveButton extends JButton {

    private void createButton(){
        new JButton("Save");
        setText("SAVE");
        setPreferredSize(new Dimension(140,50));
    }

    saveButton(){
        createButton();
    }
}
