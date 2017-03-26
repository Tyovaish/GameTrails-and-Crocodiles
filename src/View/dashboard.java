package View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by Lazaro on 3/24/2017.
 */
public class dashboard extends JPanel {
    hextiles hex = new hextiles();

    private JPanel tilePanel (){
        JPanel tile = new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);

                Dimension size = this.getSize();

                Graphics2D graphics = (Graphics2D) g;


                //hex.drawHex(0,0,graphics);
                //hex.fillHex(0,0,1,graphics);



                repaint();
            }
        };
        tile.setPreferredSize(new Dimension(300,300));
        return tile;
    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
    }

    dashboard(){
        setBackground(Color.GRAY);
        add(tilePanel(), BorderLayout.SOUTH);
        setPreferredSize(new Dimension(500,920));
        setMinimumSize(new Dimension(500,720));
        setMaximumSize(new Dimension(50,1080));

    }
}
