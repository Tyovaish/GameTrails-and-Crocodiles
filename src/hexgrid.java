import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Lazaro on 3/21/2017.
 */
public class hexgrid extends JPanel {

    final  int BSIZE = 15; //board size.
    hextiles hex = new hextiles();
    DrawingPanel panel = new DrawingPanel();
    int[][] board = new int[BSIZE][BSIZE];


    void createGrid(){
        for (int i=0;i<BSIZE;i++) {
            for (int j=0;j<BSIZE;j++) {
                board[i][j]= 0;
            }
        }
    }

    private void createAndShowGUI()
    {

        panel.setPreferredSize(new Dimension(1500, 1000));
        JFrame frame = new JFrame("Hex Testing 4");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().add(panel);
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
    }

    class DrawingPanel extends JPanel
    {
        public Graphics2D g2;
        public Dimension dim;
        public boolean check;
        public double zoom;

        public DrawingPanel()
        {
            setBackground(Color.blue);
            MyMouseListener ml = new MyMouseListener();
            addMouseListener(ml);
            MyMouseWheelListener w1 = new MyMouseWheelListener();
            addMouseWheelListener(w1);

        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g2 = (Graphics2D)g.create();
            dim = this.getSize();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


            //draw grid
            for (int i=0;i<BSIZE;i++) {
                for (int j=0;j<BSIZE;j++) {
                    hex.drawHex(i,j,g2);
                }
            }

            for (int i=0;i<BSIZE;i++) {
                for (int j=0;j<BSIZE;j++) {
                    hex.fillHex(i,j,board[i][j],g2);
                }
            }
            if(check) {
                hex.scale(g2, dim, zoom);
                check = false;
            }

        }

        class MyMouseListener extends MouseAdapter	{	//inner class inside DrawingPanel
            public void mouseClicked(MouseEvent e) {
                Point p = new Point( hex.pxtoHex(e.getX(),e.getY()) );
                if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE){
                    System.out.println("OUTSIDE");
                    return;
                }
                System.out.println("X: " + p.x + " " + "Y: " + p.y);
                board[p.x][p.y] = (int)'X';
                repaint();
            }


        } //end of MyMouseListener class

        class MyMouseWheelListener implements MouseWheelListener{
            public void mouseWheelMoved(MouseWheelEvent e){
                String message;
                int notches = e.getWheelRotation();
                if (notches < 0) {
                    zoom += 2.9;
                    check = true;


                    repaint();
                } else {
                    message = "Mouse wheel moved DOWN ";
                    //ZOOM OUT
                    System.out.println(message);

                }

            }

        }



    } // end of DrawingPanel class



    public hexgrid()
    {

        createGrid();
        createAndShowGUI();


    }



}
