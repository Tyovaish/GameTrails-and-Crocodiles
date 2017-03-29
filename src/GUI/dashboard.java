package GUI;

import Model.Tile.Tile;
import Controller.Controller;
import javax.swing.*;
import java.awt.*;



/**
 * Created by Lazaro on 3/24/2017.
 */
public class dashboard extends JPanel {
   private PaintHex hex = new PaintHex();
   private Controller ctrl;
   private Tile dashboardTile = new Tile();
   private int typeIdx= -1;

   public void setController(Controller controller){this.ctrl = controller;}



    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;

        graphics.setFont(new Font("Times New Roman", Font.BOLD, 50));
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        int x = (500 - metrics.stringWidth(ctrl.getType())) / 2;
        graphics.drawString(ctrl.getType(), x,250);

        graphics.translate(150,300);
        hex.drawHex(0,0,graphics);
        System.out.println(ctrl.getType());
        hex.fillHex(0,0,0,ctrl.getType(), graphics);


    }



    dashboard(Controller controller){

        setController(controller);
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(500,920));
        setMinimumSize(new Dimension(500,720));
        setMaximumSize(new Dimension(500,1080));

    }
}
