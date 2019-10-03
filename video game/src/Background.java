import city.cs.engine.*;
import javax.swing.*;
import java.awt.*;


/**
*Background adds all the images for the background and foreground.
*Changes the image of the background depending on the level int from main.
*Changes the life displayed on the foreground depending on the HitPoints from main character and if it is 0 then it will paint a game over screen over the foreground.
*If the DragonBoss HP = 0 in level 4 then it will load a victory screen.
 * Victory screen is a new addition for milestone 3.
 */

public class Background extends UserView {
    MainCharacter mc;
    private Main main;
    public void setMc(MainCharacter mc) {
        this.mc = mc;
    }

    private Image background;
    private Image HP;
    private Image gameOver;
    private Image ground;
    private Image background2;
    private Image background3;
    private Image background4;
    private Image victory;
    private Image awesome;
    private Image kawaii;
    private Image sonic;
    private Image squidward;
    public World world;

// creates and calls background to world and locks it to the main character
    public Background(Main main, World world, MainCharacter mc, int width, int height) {
        super(world, width, height);
        this.main = main;
// images of background levels
        this.background = new ImageIcon("Assets/MedievalNight.png").getImage().getScaledInstance(1440, 860, 0);
        this.background2 = new ImageIcon("Assets/wall.png").getImage().getScaledInstance(1440, 860, 0);
        this.background3 = new ImageIcon("Assets/CasinoNightZone.gif").getImage().getScaledInstance(1440, 860, 0);
        this.background4 = new ImageIcon("Assets/background4.png").getImage().getScaledInstance(1440, 860, 0);
// images of other assets
        this.HP = new ImageIcon("Assets/Health.gif").getImage().getScaledInstance(100, 100, 0);
        this.gameOver = new ImageIcon("Assets/GameOver.gif").getImage().getScaledInstance(1440, 860, 0);
        this.ground = new ImageIcon("Assets/lvl1Ground.png").getImage().getScaledInstance(100, 50, 0);
        this.victory = new ImageIcon("Assets/victoryScreen.gif").getImage().getScaledInstance(400, 400, 0);
        this.awesome = new ImageIcon("Assets/YouAreAwesome.png").getImage().getScaledInstance(1440, 860, 0);
        this.kawaii = new ImageIcon("Assets/kawaii.gif").getImage().getScaledInstance(300, 300, 0);
        this.sonic = new ImageIcon("Assets/sonic.gif").getImage().getScaledInstance(300, 300, 0);
        this.squidward = new ImageIcon("Assets/squidward.gif").getImage().getScaledInstance(300, 300, 0);


    }
    //paints the background with the images provided
    @Override
    protected void paintBackground(Graphics2D g) {


        if (main.getLevel() == 1) {
            g.drawImage(background, 0, 0, this);
        } else if (main.getLevel() == 2) {
            g.drawImage(background2, 0, 0, this);

        } else if (main.getLevel() == 3) {
            g.drawImage(background3, 0, 0, this);

        } else if (main.getLevel() == 4) {
            g.drawImage(background4, 0, 0, this);

        }
        g.drawImage(ground, 0, -430, this);
    }
// paints foreground with the other assets
    @Override
    protected void paintForeground(Graphics2D g) {
        if (((GameWorld) getWorld()).getMc().getHitPoints() == 3) {
            g.drawImage(HP, 0, 0, this);
            g.drawImage(HP, 100, 0, this);
            g.drawImage(HP, 200, 0, this);
        } else if (((GameWorld) getWorld()).getMc().getHitPoints() == 2) {
            g.drawImage(HP, 0, 0, this);
            g.drawImage(HP, 100, 0, this);
        } else if (((GameWorld) getWorld()).getMc().getHitPoints() == 1) {
            g.drawImage(HP, 0, 0, this);
        } else if (((GameWorld) getWorld()).getMc().getHitPoints() == 0) {
            g.drawImage(gameOver, 0, 0, this);
        }

    if (((GameWorld) getWorld()).getDragonBoss().getDragonHP() <= 0) {
        g.drawImage(awesome,0,0,this);
        g.drawImage(victory, 0, 0, this);
        g.drawImage(kawaii,950,0,this);
        g.drawImage(sonic,950,400,this);
        g.drawImage(squidward,0,400,this);
        }
    }
}