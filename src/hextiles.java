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
    public  int height = 100;
    public  int width = 70;
    public File img = new File("./src/B.PNG");


    public int r = height / 2;
   public  int  t = (int) (r / 1.73205);// t = (h/2) tan30 = (h/2) 1/sqrt(3) = h / (2 sqrt(3)) = r / sqrt(3)

    public Polygon setHex(int row, int col){
            int[] cx, cy;
            int x = row ;
            int y = col ;

        cx = new int[] {x+t,x+width+t,x+width+t+t,x+width+t,x+t,x};	//this is for the whole hexagon to be below and to the right of this point
        cy = new int[] {y,y,y+r,y+r+r,y+r+r,y+r};
        return new Polygon(cx,cy,6);
    }

    public void scale(Graphics2D g2, Dimension dim, double zoom) {
        System.out.println("hello");
        g2.dispose();



    }



    public  void drawHex(int i, int j, Graphics2D g2) {
        int x = i * (width+t);
        int y = j * height + (i%2) * height/2;
        Polygon poly = setHex(x,y);
        g2.setColor(Color.WHITE);
        g2.fillPolygon(poly);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(5));
        g2.drawPolygon(poly);

    }
    public void fillHex(int i, int j, int n, Graphics2D g2) {
        int x = i * (width+t);
        int y = j * height + (i%2) * height/2;

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



        }
    }


    public  Point pxtoHex(int mx, int my) {
        Point p = new Point(-1,-1);

        int x =  (mx / (width+t)); //this gives a quick value for x. It works only on odd cols and doesn't handle the triangle sections. It assumes that the hexagon is a rectangle with width s+t (=1.5*s).
        int y =  ((my - (x%2)*r)/height); //this gives the row easily. It needs to be offset by h/2 (=r)if it is in an even column


        //dx,dy are the number of pixels from the hex boundary. (ie. relative to the hex clicked in)
        int dx = mx - x*(width+t);
        int dy = my - y*height;

        if (my - (x%2)*r < 0) return p;


        //even columns
        if (x%2==0) {
            if (dy > r) {	//bottom half of hexes
                if (dx * r /t < dy - r) {
                    x--;
                }
            }
            if (dy < r) {	//top half of hexes
                if ((t - dx)*r/t > dy ) {
                    x--;
                    y--;
                }
            }
        } else {  // odd columns
            if (dy > height) {	//bottom half of hexes
                if (dx * r/t < dy - height) {
                    x--;
                    y++;
                }
            }
            if (dy < height) {	//top half of hexes
                if ((t - dx)*r/t > dy - r) {
                    x--;
                }
            }
        }
        p.x=x;
        p.y=y;
        return p;
    }





}

