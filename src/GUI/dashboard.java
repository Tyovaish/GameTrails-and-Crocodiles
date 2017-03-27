package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lazaro on 3/24/2017.
 */
public class dashboard extends JPanel  {
   private PaintHex hex = new PaintHex();
   public int rot;



    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        String text = "Image Type";
        graphics.setFont(new Font("Times New Roman", Font.BOLD, 50));
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        int x = (500 - metrics.stringWidth(text)) / 2;
        graphics.drawString(text, x,250);

        graphics.translate(150,300);
        hex.drawHex(0,0,graphics);
        hex.fillHex(0,0,rot,graphics);




        repaint();
    }




    dashboard(){

        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(500,920));
        setMinimumSize(new Dimension(500,720));
        setMaximumSize(new Dimension(500,1080));

    }
}
