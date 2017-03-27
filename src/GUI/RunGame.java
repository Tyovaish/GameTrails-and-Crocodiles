package GUI;

/**
 * Created by Lazaro on 3/22/2017.
 */
public class RunGame {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Display();
            }

    });
    }
}
