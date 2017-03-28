package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;

/**
 * Created by Lazaro on 3/26/2017.
 */
public class Display extends JPanel implements KeyListener, MouseListener{

    final   int BSIZE = 10; //board size.
    private dashboard dash = new dashboard();
    private PaintHex hex = new PaintHex();
    private int rot = 0;
    private int[][] board = new int[BSIZE][BSIZE];


    private void createAndShowGUI()
    {
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
    private void createGrid(){
        for (int i=0;i<BSIZE;i++) {
            for (int j=0;j<BSIZE;j++) {
                board[i][j]= -1;
            }
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);



        //draws GameBoard
        for (int i=0;i<BSIZE;i++) {
            for (int j=0;j<BSIZE;j++) {
                hex.drawHex(i,j,g2 );
            }
        }

        //FILLS IN HEX WHEN THE GAME-BOARD HAS A ROTATION VALUE
        for (int i=0;i<BSIZE;i++) {
            for (int j=0;j<BSIZE;j++) {
                AffineTransform old = g2.getTransform();
                hex.fillHex(i,j,board[i][j],g2);
                g2.setTransform(old);
            }
        }

    }

    public void mouseClicked(MouseEvent e) {

        Point p = new Point( hex.pxtoHex(e.getX(),e.getY()) );
        if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE){
            System.out.println("OUTSIDE"); //IF USER CLICKS OUT OF THE MAP
            return;
        }
        System.out.println(p.x + " " + p.y);
        board[p.x][p.y] = rot;
        repaint();


    }//end of mouseClicked method

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

        if( e.isControlDown() && e.getKeyCode() == KeyEvent.VK_R) {
            rotateCounterClockWise();
        }
        else if(e.getKeyCode() == KeyEvent.VK_R){
            rotateClockWise();
        }
    }
    @Override
    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e) {

    }

    private void rotateClockWise(){
        if (rot == 5)
            rot = 0;
        else
            rot += 1;
        dash.rot = rot;
    }

    private void rotateCounterClockWise(){
        if (rot == 0)
            rot = 5;
        else
            rot -= 1;
        dash.rot = rot;
    }

    Display()
    {
        setBackground(Color.blue);
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        createGrid();
        createAndShowGUI();

    }

}
