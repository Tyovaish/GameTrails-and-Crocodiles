package GUI;


import Controller.Controller;
import Model.Map;

import Model.Tile.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

/**
 * Created by Lazaro on 3/26/2017.
 */
public class Display extends JPanel implements KeyListener, MouseListener, MouseMotionListener{

    final   int BSIZE = 10; //board size.
    private PaintHex hex = new PaintHex();
    private Point hoverP = new Point(0,0);
    private Map board ;
    private Controller ctrl;
    private dashboard dash ;



    private void createAndShowGUI()
    {
        dash = new dashboard(ctrl);
        JFrame frame = new JFrame("Phase 01");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        setPreferredSize(new Dimension(5000,5000));
        JScrollPane screen = new JScrollPane(this);
        screen.setPreferredSize(new Dimension(3000, 1100));
        screen.setWheelScrollingEnabled(false);
        screen.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(screen);
        frame.add(dash, BorderLayout.EAST);
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);

    }


    private void drawGameBoard(Graphics2D g2){

            for (int i = 0; i < BSIZE; i++) {
                for (int j = 0; j < BSIZE; j++) {
                    hex.drawHex(i, j, g2);
                }
            }
    }


    private void fillInHex(Graphics2D g2){
        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
                    AffineTransform old = g2.getTransform();
                    hex.fillHex(i, j, board.getTileOrientation(i, j), board.getTileType(i, j), g2);
                    g2.setTransform(old);
            }
        }
    }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //draws GameBoard
        drawGameBoard(g2);
        //Fills In Hexes with Tile Images
        fillInHex(g2);
        if(hoverP.x >= 0 || hoverP.y >= 0 || hoverP.x < BSIZE || hoverP.y < BSIZE)
        hex.drawCursor(hoverP.x, hoverP.y,g2);

    }

    public void mouseClicked(MouseEvent e) {

        Point p = new Point( hex.pxtoHex(e.getX(),e.getY()) );
        if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE){
            System.out.println("OUTSIDE"); //IF USER CLICKS OUT OF THE MAP
            return;
        }
        System.out.println(p.x + " " + p.y);
        ctrl.onLeftClick(p.x,p.y);
        this.repaint();



    }//end of mouseClicked method

    public void mouseMoved(MouseEvent e){
        hoverP = hex.pxtoHex(e.getX(),e.getY());
        if (hoverP.x < 0 || hoverP.y < 0 || hoverP.x >= BSIZE || hoverP.y >= BSIZE){
            return;
        }
        this.repaint();
    }
    public void mouseDragged(MouseEvent e){

    }
    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {


        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ctrl.nextState();
            dash.repaint();

        } if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_LEFT) {
          ctrl.previousState();

        }
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_DOWN){
            ctrl.forward();
        }
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_UP){
            ctrl.back();
        }
    }
    @Override
    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e) {

    }


    Display(Map map, Controller controller)
    {
        board = map;
        ctrl = controller;
        setBackground(Color.blue);
        addMouseListener(this);
        addKeyListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        createAndShowGUI();

    }

}
