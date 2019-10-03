import city.cs.engine.DebugViewer;
import city.cs.engine.SoundClip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import java.awt.*;
import java.io.IOException;

/**
 * This runs the game also creating a window for the game and calls all the gui as well as the moths that load method levels 2-4.
 * It also contains the methods used for creating the system in which level transitions occur as well as the music for each level which is a new addition for milestone 3
 * @author Hamza Malik
 * @user aczh259
 */

public class Main {


    public GameWorld world;
    private int level;
    private Background background;
    private KeyHandler keyHandler;
    private MainCharacter mc;
    private Tracker tracker;
    private SoundClip lvl1Music;
    private SoundClip lvl2Music;
    private SoundClip lvl3Music;
    private SoundClip bossMusic;



    public Background getBackground() {
        return background;
    }
    public GameWorld getWorld() {
        return world;
    }
    public int getLevel() {
        return level;
    }

    public static JFrame window;

    public Main() {


        level = 1;


        System.out.println(level);
        world = new Level1(this);


        background = new Background(this, world, world.getMc(), 1440, 860);

        GUI gui = new GUI(world, this);
        background.add(gui.getMainPanel(), BorderLayout.NORTH);

        keyHandler = new KeyHandler(world);
        keyHandler.setMc(world.getMc());



        try {
            lvl1Music = new SoundClip("Sound/EmeraldHillZone.mp3");
            lvl1Music.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        window = new JFrame("Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationByPlatform(true);
        window.add(background);
        window.setResizable(true);
        window.pack();
        window.setVisible(true);
        window.addKeyListener(keyHandler);
        window.requestFocus();
        tracker = new Tracker(background, world.getMc());
        world.addStepListener(tracker);

        world.start();



    }

    public void goNextLevel() {
        // method for level transition

        //keeps the HP from previous levels
        int tempHitPoints = world.getMc().getHitPoints();
        int dragonHitPotnts = world.getDragonBoss().getDragonHP();

        level++;
        if(level == 2) {
            lvl1Music.stop();
            try {
                lvl2Music = new SoundClip("Sound/Robotnik.mp3");
                lvl2Music.loop();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }
        if(level == 3){
            lvl2Music.stop();
            try {
                lvl3Music = new SoundClip("Sound/CasinoNightZone.mp3");
                lvl3Music.loop();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }
        if(level == 4){
            lvl3Music.stop();
            try {
                bossMusic = new SoundClip("Sound/Boss.mp3");
                bossMusic.loop();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }
        world.stop();
        System.out.println(level);

        switch (level) {
            case 2:
                world = new Level2(this);
                break;
            case 3:
                world = new Level3(this);
                break;
            case 4:
                world = new Level4(this);
                break;
        }
        window.removeKeyListener(keyHandler);
        keyHandler = new KeyHandler(world);
        window.addKeyListener(keyHandler);
        background.setWorld(getWorld());
        world.removeStepListener(tracker);
        tracker = new Tracker(background, world.getMc());
        world.addStepListener(tracker);
        world.getMc().setHitPoints(tempHitPoints);
        world.getDragonBoss().setDragonHP(dragonHitPotnts);


        world.start();


    }

    public void goLevel2() {
// method to load level 2

        if (level == 2) {

        System.exit(0);
        } else {
            level++;
            System.out.println(level);



            world = new Level2(this);
            world.populate(this);
            KeyHandler kAdapt = new KeyHandler(world);
            kAdapt.setMc(world.getMc());
            background.setWorld(getWorld());
            world.start();
        }
    }

    public void goLevel3() {
        // method to load level 3
        world.stop();

        if (level == 3) {

            System.exit(0);
        } else {
            level++;
            System.out.println(level);

            world = new Level3(this);
            world.populate(this);
            KeyHandler keyHandler = new KeyHandler(world);
            keyHandler.setMc(world.getMc());
            background.setWorld(getWorld());
            world.start();
        }
    }

    public void goLevel4() {
        // method to load level 4
        world.stop();

        if (level == 4) {

            System.exit(0);
        } else {
            level++;
            System.out.println(level);
            world = new Level4(this);
            world.populate(this);
            keyHandler = new KeyHandler(world);
            background.setWorld(getWorld());
            world.start();
        }

    }

    //creates world
    public static void main(String[] args) {
        new Main();

    }

}