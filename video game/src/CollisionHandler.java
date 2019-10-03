import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * this handles the collision between the main character and other bodies and objects as well as the collision for level transitions.
 */

public class CollisionHandler implements CollisionListener {

    public MainCharacter p1;
    public World world;
    public Main main;
    private SoundClip HpUp;


    // handles collision with the main character
    public CollisionHandler(MainCharacter p1, Main main) {
        this.p1 = p1;
        this.main = main;

    }

    @Override
    public void collide(CollisionEvent e) {
        // main character loses 1HP if he collides with an enemy
        if (e.getOtherBody() instanceof MainCharacter) {
            if (e.getReportingBody() instanceof Worm) {
                ((MainCharacter) e.getOtherBody()).setHitPoints(((MainCharacter) e.getOtherBody()).getHitPoints() - 1);
            }

        }
        if (e.getOtherBody() instanceof MainCharacter) {
            if (e.getReportingBody() instanceof FireBall) {
                ((MainCharacter) e.getOtherBody()).setHitPoints(((MainCharacter) e.getOtherBody()).getHitPoints() - 1);
                e.getReportingBody().destroy();
            }
            // main character loses 1HP if he collides with an enemy
            if (e.getOtherBody() instanceof MainCharacter) {
                if (e.getReportingBody() instanceof EyeBat) {
                    ((MainCharacter) e.getOtherBody()).setHitPoints(((MainCharacter) e.getOtherBody()).getHitPoints() - 1);

                }
            }
            // main character loses 1HP if he collides with an enemy
            if (e.getOtherBody() instanceof MainCharacter) {
                if (e.getReportingBody() instanceof DragonBoss) {
                    ((MainCharacter) e.getOtherBody()).setHitPoints(((MainCharacter) e.getOtherBody()).getHitPoints() - 1);
                }

                // kills main character if HP <= 0
                if (((MainCharacter) e.getOtherBody()).getHitPoints() <= 0) {
                    e.getOtherBody().destroy();
                }
            }


            // main character gains 1HP as long as his HP < 3
            if (e.getOtherBody() instanceof MainCharacter) {
                if (e.getReportingBody() instanceof Health) {
                    if (((MainCharacter) e.getOtherBody()).getHitPoints() < 3) {
                        ((MainCharacter) e.getOtherBody()).setHitPoints(((MainCharacter) e.getOtherBody()).getHitPoints() + 1);
                        e.getReportingBody().destroy();
                        try {
                            HpUp = new SoundClip("Sound/HpUp.mp3");
                            HpUp.play();
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException d) {
                            System.out.println(d);
                        }

                    }
                }
            }
            // destroys projectile when it collides with anything
            if (e.getOtherBody() instanceof Airslash) {
                if (e.getReportingBody() instanceof Health) {
                    ((Health) e.getReportingBody()).setLinearVelocity(new Vec2(0, 0));
                }
            }
            // level 2 collision
            if (e.getOtherBody() instanceof MainCharacter) {
                if (e.getReportingBody() instanceof Door) {
                    main.goNextLevel();
                }
            }
            // level 3 collision
            if (e.getOtherBody() instanceof MainCharacter) {
                if (e.getReportingBody() instanceof Door2) {

                    main.goNextLevel();
                }
            }
            // level 4 collision
            if (e.getOtherBody() instanceof MainCharacter) {
                if (e.getReportingBody() instanceof Door3) {

                    main.goNextLevel();
                }
            }
        }
    }
}












