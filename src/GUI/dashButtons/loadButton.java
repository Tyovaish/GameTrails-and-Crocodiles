package GUI.dashButtons;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lazaro on 4/3/2017.
 */
public class loadButton extends JButton {

    private void createButton(){
    new JButton("Load");
    setText("LOAD");
    setPreferredSize(new Dimension(140,50));
    }

    loadButton(){
        createButton();
    }
}
