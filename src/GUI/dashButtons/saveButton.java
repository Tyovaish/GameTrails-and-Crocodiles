package GUI.dashButtons;

import Model.ExportManager;
import Model.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lazaro on 4/4/2017.
 */
public class saveButton extends JButton implements ActionListener{
    private ExportManager exportManager;
    private Map Board;

    private void createButton(){
        new JButton("Save");
        setText("SAVE");
        setPreferredSize(new Dimension(140,50));
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("hello");
        exportManager = new ExportManager(Board);
        exportManager.export();
    }

    saveButton(Map board){
        createButton();
        Board= board;
        addActionListener(this);
    }
}
