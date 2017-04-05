package GUI;


import Controller.Controller;
import Model.ExportManager;
import Model.Map;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

/**
 * Created by Lazaro on 3/26/2017.
 */
public class Display extends JPanel implements KeyListener, MouseListener, MouseMotionListener{

    final   int BSIZE = 5; //board size.
    private PaintHex hex = new PaintHex();
    private Point hoverP = new Point(0,0);
    private Map board ;
    private int count = 0;
    private Controller ctrl;
    private tileForDashboard tile;



    private void createAndShowGUI()
    {

        dashboard dash = new dashboard(board);
        dash.add(tile, BorderLayout.CENTER);
        JFrame frame = new JFrame("Phase 01");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setPreferredSize(new Dimension(3000,3000));

        JScrollPane screen = new JScrollPane(this);
        screen.setWheelScrollingEnabled(false);
        screen.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        screen.setPreferredSize(new Dimension(2000, 1300));
        frame.add(screen);
        frame.getContentPane().add(dash, BorderLayout.EAST);
        frame.setPreferredSize(new Dimension(2500, 1300));
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);

    }

    private boolean checkTileType(String type){
        switch(type){
            case "desert":{
                return true;
            }
            case "pasture":{
                return true;
            }
            case "woods":{
                return true;
            }
            case "rock":{
                return true;
            }
        }
        return false;
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
                    hex.fillHex(i, j, board.getTileOrientation(i, j), board.getTileType(i, j),
                            board.getTileNumberOfRivers(i,j) , g2);
                    hex.drawCursor(hoverP.x,hoverP.y,g2);
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
        //Fills In Hexes with Tile Images from the Board
        fillInHex(g2);
        //Drawing the cursor



    }

    public void mouseClicked(MouseEvent e) {
        Point p = new Point( hex.pxtoHex(e.getX(),e.getY()) );
        if(SwingUtilities.isRightMouseButton(e)){
            ctrl.onRightClick(p.x,p.y);
            this.repaint();
        }
        else {
            if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE) {
                System.out.println("OUTSIDE"); //IF USER CLICKS OUT OF THE MAP
                return;
            }
            System.out.println(p.x + " " + p.y);
            ctrl.onLeftClick(p.x, p.y);
            tile.setState("Select Tile Type");
            count = 0;
            this.repaint();
            tile.repaint();
        }



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
            tile.repaint();

        } if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_LEFT) {
          ctrl.previousState();
          tile.repaint();

        }
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_DOWN){
            count++;
            if(count == 1 && checkTileType(ctrl.getType())) tile.setState("Select River Type");
            else if(count == 2 && ctrl.getNumberOfRivers() > 0) tile.setState("Select Rotation");
            else count =1;
            ctrl.forward();
            tile.repaint();
        }
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_UP){
            count --;
            if(count < 0 ) count = 0;
            if(count == 1)tile.setState("Select River Type");
            else if(count == 2) tile.setState("Select Rotation");
            else{count = 0; tile.setState("Select Tile Type");}
            ctrl.back();
            tile.repaint();
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
        tile = new tileForDashboard(ctrl);
        setBackground(Color.BLACK);
        addMouseListener(this);
        addKeyListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        createAndShowGUI();

    }

}
