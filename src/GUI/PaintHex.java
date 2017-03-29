package GUI;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * Created by Lazaro on 3/21/2017.
 */

public class PaintHex extends JPanel{
    final int radius = 100; //radius
    final int width = radius * 2;
    final int height = (int) (Math.sqrt(3)/2 * width);



    public Polygon setHex(int row, int col){
            int[] cx, cy;
            int x = row ;
            int y = col ;


        cx = new int[] { (int) (x + radius * Math.cos(2 * Math.PI * 1/6)),(int) (x + radius * Math.cos(2 * Math.PI * 2/6)),
                (int) (x + radius * Math.cos(2 * Math.PI * 3/6)),(int) (x + radius * Math.cos(2 * Math.PI * 4/6)),
                (int) (x + radius * Math.cos(2 * Math.PI * 5/6)),(int) (x + radius * Math.cos(2 * Math.PI ))};

        cy = new int[] {(int) (y + radius * Math.sin(2 * Math.PI* 1/6)),(int) (y + radius * Math.sin(2 * Math.PI* 2/6)),
                (int) (y + radius * Math.sin(2 * Math.PI* 3/6)),(int) (y + radius * Math.sin(2 * Math.PI* 4/6)),
                (int) (y + radius * Math.sin(2 * Math.PI* 5/6)),(int) (y + radius * Math.sin(2 * Math.PI))};
        //CREATES THE HEX IN TWO HALVES WITH EQUAL SIDES
        return new Polygon(cx,cy,6);
    }



    public  void drawHex(int i, int j, Graphics2D g2) {

        int vert;
        int horiz = radius +(j*((width/4*3)));
        if(j % 2 == 0)
             vert = radius +(i * height);
        else
        vert = 10 + ((i+1) * (height));


        Polygon poly = setHex(horiz, vert);
        g2.setColor(Color.WHITE);
        g2.fillPolygon(poly);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(5));
        g2.drawPolygon(poly);

    }

    public void drawCursor(int i, int j, Graphics2D g2){

        int vert;
        int horiz = radius +(j*((width/4*3)));
        if(j % 2 == 0)
            vert = radius +(i * height);
        else
            vert = 10 + ((i+1) * (height));


        Polygon poly = setHex(horiz, vert);
        if(i == -1)
            g2.setColor(Color.black);
        else
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(5));
        g2.drawPolygon(poly);
    }

    public void fillHex(int i, int j, int rot, String type, Graphics2D g2) {
        int vert;
        int horiz = radius +(j*((width/4*3)));
        if(j % 2 == 0)
            vert = radius +(i * height);
        else
            vert = 10 + ((i+1) * (height));

            File img = new File("./GameTrails-and-Crocodiles/src/GUI/" + type + ".jpg");
            BufferedImage bi = null;
        if(type == null) {return;}
        else{
            try {
                bi = ImageIO.read(img);
            } catch (IOException e) {
                System.err.println("Could not load image file!");
            }
        }

        if(rot > -1) {
            g2.rotate(Math.toRadians(rot * 60), horiz, vert);
            g2.setClip(setHex(horiz, vert));
            g2.drawImage(bi.getScaledInstance(230, 320, 0), horiz - radius, vert - 150, null);
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(10));
            g2.draw(setHex(horiz, vert));
        }


    }


    public  Point pxtoHex(int mx, int my) {
        Point p = new Point(-1,-1);
        int  t = (int) (radius / 1.73205);//(2 sqrt(3)) = r / sqrt(3)
        int x;
        int y =  (mx / (t + radius))  ; //this gives a quick value for x. It works only on odd cols and doesn't handle the triangle sections. It assumes that the hexagon is a rectangle with width s+t (=1.5*s).
        //this gives the row easily. It needs to be offset by h/2 (=r)if it is in an even column
        if(y%2 == 0) {
            x = (my  / height);
        }
        else
            x = (my - radius)/height;

        p.x=x;
        p.y=y;

        return p;
    }





}

