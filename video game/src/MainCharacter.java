import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * this creates the main character and also giving it HitPoints as well as sounds for jumping and attacking.
 * the methods for movement and attacking are created here and then called into the Key Handler class.
 */

public class MainCharacter extends Walker {

    public MainCharacter(World w) {
        super(w);
        addImage(image);
        this.setGravityScale(4);
        HitPoints = 3;
        count = 0;

    }
        private int HitPoints;

        public int getHitPoints () {
            return HitPoints;
        }

        public void setHitPoints ( int newHealth){
            this.HitPoints = newHealth;
        }

        private int count;

        public int getCount() {
        return count;
    }

    private SoundClip shine;
        private SoundClip jump;

    // All assets in this class were created by myself

    public void addOne() {
        count++;
    }
    private BodyImage image = new BodyImage("Assets/mainCharacter.gif", 6f);
    Shape body = new PolygonShape(-0.84f, 2.87f, -1.42f, 0.48f, -0.77f, -2.64f, 0.16f, -2.95f,
            1.33f, -2.66f, 1.75f, 1.13f, 0.95f, 2.9f, -0.84f, 2.87f);
    SolidFixture bodyFixture = new SolidFixture(this, body,10f);
    @Override
    public void startWalking(float speed) {
        super.startWalking(speed);


    }


    public void jump(float speed) {
        if(getLinearVelocity().y == 0) {
            super.jump(speed);
        }
    }
    // methods for functions called in key handler these add additional changes to the main character when keys are pressed and released
    public void MoveRight() {
        if (this.getLinearVelocity().y == 0.0) {
            BodyImage image = new BodyImage("Assets/mainCharacter.gif", 6f);
            removeAllImages();
            addImage(image);
        }
    }
    public void MoveLeft() {
        if (this.getLinearVelocity().y == 0.0) {
            BodyImage leftImage = new BodyImage("Assets/mainCharacterLeft.gif", 6f);
            removeAllImages();
            addImage(leftImage);
        }
    }
    public void Crouch() {
        if (this.getLinearVelocity().y == 0.0) {
            BodyImage crouchImage = new BodyImage("Assets/Crouch.png", 6f);
            removeAllImages();
            addImage(crouchImage);
        }
    }
    public void idle() {
        removeAllImages();
        addImage(image);
    }
    public void Attack1(){
        BodyImage attackImage = new BodyImage("Assets/Attack1.gif", 6f);
        removeAllImages();
        addImage(attackImage);
        try {
            shine = new SoundClip("Sound/Shine.mp3");
            shine.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
}











