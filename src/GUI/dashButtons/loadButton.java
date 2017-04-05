package GUI.dashButtons;

import Controller.Controller;
import GUI.Display;
import Model.ImportManager;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lazaro on 4/3/2017.
 */
public class loadButton extends JButton implements ActionListener{

    ImportManager importman;
    Display display;
    private void createButton(){
    new JButton("Load");
    setText("LOAD");
    setPreferredSize(new Dimension(140,50));
    }

    public void actionPerformed(ActionEvent e){
        importman = new ImportManager();
        Controller ctrl = new Controller(importman.getMap());
        display = new Display(importman.getMap(), ctrl);
    }

    loadButton(){
        createButton();
        addActionListener(this);
    }
}
