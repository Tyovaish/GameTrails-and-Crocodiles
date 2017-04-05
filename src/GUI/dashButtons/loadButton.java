package GUI.dashButtons;

import Model.ImportManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lazaro on 4/3/2017.
 */
public class loadButton extends JButton implements ActionListener{

    ImportManager importman;
    private void createButton(){
    new JButton("Load");
    setText("LOAD");
    setPreferredSize(new Dimension(140,50));
    }

    public void actionPerformed(ActionEvent e){
        importman = new ImportManager();

    }

    loadButton(){
        createButton();
        addActionListener(this);
    }
}
