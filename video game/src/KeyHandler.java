import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * this handles the keyboard inputs and releases of the game by calling methods in the Main Character class.
 */


public class KeyHandler extends KeyAdapter {
    
    Airslash airslash;
    GameWorld world;
    java.awt.event.KeyAdapter keyAdapt;
    private SoundClip jump;


    public MainCharacter p1;

    public KeyHandler(GameWorld world) {
        this.world = world;
        this.p1 = world.getMc();
    }

    public void setMc(MainCharacter mc) {
        this.p1 = mc;

    }
    public void setAirS(Airslash AirS){
        airslash = AirS;
    }


    public void keyPressed(KeyEvent e) {
        // controls keyboard inputs by calling methods in the main character class

        if (e.getKeyCode() == KeyEvent.VK_D) {
            p1.startWalking(25);
            p1.MoveRight();

        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            p1.startWalking(-25);
            p1.MoveLeft();

        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
                p1.jump(35);
                try {
                    jump = new SoundClip("Sound/Jump.mp3");
                    jump.play();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException d) {
                    System.out.println(d);
                }
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            p1.Crouch();

        }
        if (e.getKeyCode() == KeyEvent.VK_I) {
            p1.Attack1();
            airslash = new Airslash(world);
            airslash.setPosition(new Vec2(p1.getPosition().x +4, p1.getPosition().y+1) );
            airslash.setLinearVelocity(new Vec2(300, 0));



        }

    }

    public void keyReleased(KeyEvent e) {
        // controls keyboard releases by calling methods in the main character class
        if (e.getKeyCode() == KeyEvent.VK_D) {
            p1.stopWalking();

        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            p1.stopWalking();

        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            p1.jump(-10);
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            p1.idle();
        }

        if (e.getKeyCode() == KeyEvent.VK_I) {
            p1.idle();

        }


    }

}





