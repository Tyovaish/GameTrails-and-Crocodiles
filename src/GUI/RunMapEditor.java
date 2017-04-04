package GUI;

/**
 * Created by Lazaro on 3/22/2017.
 */
public class RunMapEditor {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
             new MapEditor();
            }

    });
    }
}
