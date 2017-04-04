package GUI;


import GUI.dashButtons.buttonPanel;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Lazaro on 3/24/2017.
 */
public class dashboard extends JPanel {




    dashboard(){
        buttonPanel btnPnl = new buttonPanel();

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 1300));
        add(btnPnl, BorderLayout.SOUTH);
    }
}
