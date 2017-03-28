package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Created by Lazaro on 3/24/2017.
 */
public class dashboard extends JPanel {
   private PaintHex hex = new PaintHex();
   private String typeSelected = "b.jpg";
   private int typeIdx= -1;
   private int rot;

    public String getSelectedType(int index){
      String type = "b.jpg";
        switch(index){
            case 0:{
                type = "desert.jpg";
                break;
            }
            case 1:{
                type = "rock.jpg";
                break;
            }
            case 2:{
                type = "mountain.jpg";
                break;
            }
            case 3:{
                type = "sea.jpg";
                break;
            }
            case 4:{
                type = "woods.jpg";
                break;
            }

            case 5:{
                break;
            }
            /*
            case 6:{
                break;
            }
            case 7:{
                break;
            }
            case 8:{
                break;
            }
            case 9:{
                break;
            }*/
        }
        return type;
    }

    public void setRotation(int rotation){
        rot = rotation;
    }
    public void setIndex(int Index){
        typeIdx = Index;
    }
    public int getIndex(){return typeIdx;}
    public void incrementIndex(){typeIdx++;}

    public void setTileType(String Type){typeSelected = Type;}


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;

        graphics.setFont(new Font("Times New Roman", Font.BOLD, 50));
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        int x = (500 - metrics.stringWidth(typeSelected)) / 2;
        graphics.drawString(typeSelected, x,250);

        graphics.translate(150,300);
        hex.drawHex(0,0,graphics);
        hex.fillHex(0,0,rot,graphics, typeSelected);




        repaint();
    }



    dashboard(){

        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(500,920));
        setMinimumSize(new Dimension(500,720));
        setMaximumSize(new Dimension(500,1080));

    }
}
