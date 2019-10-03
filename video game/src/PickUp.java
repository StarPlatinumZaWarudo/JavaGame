import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * this is the collision for picking up the pickup item shard.
 */

public class PickUp implements CollisionListener {
    private MainCharacter mc;
    private SoundClip aetherShard;

    public PickUp(MainCharacter mc) {
        this.mc = mc;

    }
// creates collision for picking up shards
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == mc)
        if (e.getReportingBody() instanceof AetherShard ){
            try {
                aetherShard = new SoundClip("Sound/AetherShard.mp3");
                aetherShard.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException d) {
                System.out.println(d);
            }
            mc.addOne();
            e.getReportingBody().destroy();
        }
    }

}