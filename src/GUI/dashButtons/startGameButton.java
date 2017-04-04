package GUI.dashButtons;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lazaro on 4/4/2017.
 */
public class startGameButton extends JButton {

    private void createButton(){
        new JButton("start");
        setText("START");
        setPreferredSize(new Dimension(140,50));
    }

    startGameButton(){
        createButton();
    }
}
