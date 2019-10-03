import javax.swing.*;
import java.awt.*;

/**
 * this adds functions to the buttons created in the GUI form and returns them to the main panel.
 */

public class GUI extends Container {
    private JPanel mainPanel;
    private JButton pauseButton;
    private JButton quitButton;
    private JButton restartButton;
    private JButton selectLevelButton;
    private Main main;

    public GUI (GameWorld world, Main main){
        // pause button

        this.main = main;
        pauseButton.addActionListener(e -> {
         if(world.isRunning()){
                world.stop();
            }else {
                world.start();
            }
        });
        // quit button
        quitButton.addActionListener(e -> System.exit(0));

// restart button
        restartButton.addActionListener(e -> {
            world.stop();
            world.start();
        });
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
 }
