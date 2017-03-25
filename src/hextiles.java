import java.awt.*;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * Created by Lazaro on 3/21/2017.
 */

public class hextiles extends JPanel{
    public int size = 100; //radius
    public  int width = size * 2;
    public  int height = (int) (Math.sqrt(3)/2 * width);
    public File img = new File("./GameTrails-and-Crocodiles/src/B.PNG");
    public  int  t = (int) (size / 1.73205);//(2 sqrt(3)) = r / sqrt(3)

    public Polygon setHex(int row, int col){
            int[] cx, cy;
            int x = row ;
            int y = col ;


        cx = new int[] { (int) (x + size * Math.cos(2 * Math.PI * 1/6)),(int) (x + size * Math.cos(2 * Math.PI * 2/6)),
                (int) (x + size * Math.cos(2 * Math.PI * 3/6)),(int) (x + size * Math.cos(2 * Math.PI * 4/6)),
                (int) (x + size * Math.cos(2 * Math.PI * 5/6)),(int) (x + size * Math.cos(2 * Math.PI ))};	//this is for the whole hexagon to be below and to the right of this point
        cy = new int[] {(int) (y + size * Math.sin(2 * Math.PI* 1/6)),(int) (y + size * Math.sin(2 * Math.PI* 2/6)),
                (int) (y + size * Math.sin(2 * Math.PI* 3/6)),(int) (y + size * Math.sin(2 * Math.PI* 4/6)),
                (int) (y + size * Math.sin(2 * Math.PI* 5/6)),(int) (y + size * Math.sin(2 * Math.PI))};
        return new Polygon(cx,cy,6);
    }

    public void scale(Graphics2D g2, Dimension dim, double zoom) {


        g2.scale(2,2);
        AffineTransform old = g2.getTransform();
        old.scale(3, 3);
        g2.scale(2,2);
        g2.setTransform(old);
    }

    public  void drawHex(int i, int j, Graphics2D g2) {
       int vert;
        int horiz = size+(j*((width/4*3)));

        if(j % 2 == 0)
             vert = size+(i * height);
        else
        vert = 10 + ((i+1) * (height));




        Polygon poly = setHex(horiz, vert);
        g2.setColor(Color.WHITE);
        g2.fillPolygon(poly);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(5));
        g2.drawPolygon(poly);

    }
    public void fillHex(int i, int j, int n, Graphics2D g2) {
        int x = (i * (width));
        int y = (int) ((j * height + (i%2) * height/2)*0.89);

        BufferedImage bi = null;

        try{
             bi = ImageIO.read(img);
        }
        catch (IOException e) { System.err.println("Could not load image file!");}

        if (n > 0) {

            g2.setClip(setHex(x,y));
            g2.drawImage(bi.getScaledInstance(130,100,0),x+1,y,null);
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(5));
            g2.draw(setHex(x,y));


          /*
            AffineTransform at = new AffineTransform();
            at.rotate(Math.toRadians(60.6), x+58, y+58); //<- your question: rotate around specified point
            g2.setTransform(at); //<- tell the graphics to transform before painting

            g2.setClip(setHex(x,y));
            g2.drawImage(bi.getScaledInstance(130,100,0),x+1,y,null);
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(5));
            g2.draw(setHex(x,y));*/



        }
    }


    public  Point pxtoHex(int mx, int my) {
        Point p = new Point(-1,-1);

        int x =  (mx / (width+t))  ; //this gives a quick value for x. It works only on odd cols and doesn't handle the triangle sections. It assumes that the hexagon is a rectangle with width s+t (=1.5*s).
        int y =  ((my - (x%2)*size)/height); //this gives the row easily. It needs to be offset by h/2 (=r)if it is in an even column


        //dx,dy are the number of pixels from the hex boundary. (ie. relative to the hex clicked in)
        int dx = mx - ((x*(width+t)));
        int dy = my - y*height;

        if (my - (x%2)*size < 0) return p;


        //even columns
        if (x%2==0) {
            if (dy > size) {	//bottom half of hexes
                if (dx * size /t < dy - size) {
                    x--;
                }
            }
            if (dy < size) {	//top half of hexes
                if ((t - dx)*size/t > dy ) {
                    x--;
                    y--;
                }
            }
        } else {  // odd columns
            if (dy > height) {	//bottom half of hexes
                if (dx * size/t < dy - height) {
                    x--;
                    y++;
                }
            }
            if (dy < height) {	//top half of hexes
                if ((t - dx)*size/t > dy - size) {
                    x--;
                }
            }
        }
        p.x=x;
        p.y=y;
        return p;
    }





}

