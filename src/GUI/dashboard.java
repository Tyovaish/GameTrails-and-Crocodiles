package GUI;


import GUI.dashButtons.buttonPanel;
import Model.Map;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Lazaro on 3/24/2017.
 */
public class dashboard extends JPanel {




    dashboard(Map board){
        buttonPanel btnPnl = new buttonPanel(board);

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 1300));
        add(btnPnl, BorderLayout.SOUTH);
    }
}
