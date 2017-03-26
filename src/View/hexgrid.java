package View;

import View.dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Lazaro on 3/21/2017.
 */
public class hexgrid extends JPanel {

    final  int BSIZE = 21; //board size.
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
        JFrame frame = new JFrame("Hex Testing 4");
        dashboard dash = new dashboard();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

        panel.setPreferredSize(new Dimension(5000,5000));
        JScrollPane screen = new JScrollPane(panel);
        screen.setPreferredSize(new Dimension(3000, 1100));
        screen.setWheelScrollingEnabled(false);
        screen.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(screen);
        frame.add(dash, BorderLayout.EAST);
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
            //MyMouseWheelListener w1 = new MyMouseWheelListener();
           // addMouseWheelListener(w1);


        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g2 = (Graphics2D) g.create();
            dim = this.getSize();




            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);



           //draw grid
            for (int i=0;i<BSIZE;i++) {
                for (int j=0;j<BSIZE;j++) {
                    hex.drawHex(i,j,g2 );
                }
            }

            //insert tiles
            for (int i=0;i<BSIZE;i++) {
                for (int j=0;j<BSIZE;j++) {
                    hex.fillHex(i,j,board[i][j],g2);
                }
            }


        }

        class MyMouseListener extends MouseAdapter	{	//inner class inside DrawingPanel
            public void mouseClicked(MouseEvent e) {

                Point p = new Point( hex.pxtoHex(e.getX(),e.getY()) );
                if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE){
                    System.out.println("OUTSIDE");
                    return;
                }
               // System.out.println("X: " + p.x + " " + "Y: " + p.y);
                board[p.x][p.y] = (int)'X';
                repaint();
            }
        } //end of MyMouseListener class









    } // end of DrawingPanel class



    public hexgrid()
    {

        createGrid();
        createAndShowGUI();


    }



}
