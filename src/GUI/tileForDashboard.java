package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lazaro on 4/3/2017.
 */
public class tileForDashboard extends JPanel {
    private PaintHex hex = new PaintHex();
    private String State = "Select Tile Type";
    private Controller ctrl;

    public void setState(String ST){State = ST;}
    public void CenteredText(String Text, Graphics2D g2, int height){
        g2.setFont(new Font("Times New Roman", Font.BOLD, 50));
        FontMetrics metrics = g2.getFontMetrics(g2.getFont());
        int x = 50 + (500 - metrics.stringWidth(Text)) / 2;
        g2.drawString(Text, x,height);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;



        CenteredText(State, g2, 400);
        CenteredText(ctrl.getType().toUpperCase(), g2, 475);
        g2.translate(190,500);
        hex.drawHex(0,0,g2);
        hex.fillHex(0,0,ctrl.getOrientation(),ctrl.getType(), ctrl.getNumberOfRivers(),g2);

    }

    tileForDashboard(Controller controller){
        ctrl = controller;
        setBackground(Color.gray);
    }
}
