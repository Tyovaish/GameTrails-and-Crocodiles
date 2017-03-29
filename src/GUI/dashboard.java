package GUI;

import Controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Created by Lazaro on 3/24/2017.
 */
public class dashboard extends JPanel {
   private PaintHex hex = new PaintHex();
   private Controller ctrl;


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("Times New Roman", Font.BOLD, 50));
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        int x = (500 - metrics.stringWidth(ctrl.getType().toUpperCase())) / 2;
        g2.drawString(ctrl.getType().toUpperCase(), x,475);

        g2.translate(150,500);
        hex.drawHex(0,0,g2);
        hex.fillHex(0,0,ctrl.getOrientation(),ctrl.getType(), ctrl.getNumberOfRivers(),g2);





    }



    dashboard(Controller controller){

        ctrl = controller;
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(500,1500));
        setMinimumSize(new Dimension(500,1500));
        setMaximumSize(new Dimension(500,1500));

    }
}
