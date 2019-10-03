import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * this creates the enemy worm and also gives it a HP.
 */

public class Worm extends Walker {
    private static int wormHP;
    public static void setWormHP( int wormHP){
        Worm.wormHP = wormHP;
    }
    public static int getWormHP(){
        return wormHP;
    }
// creates worm
// gif was created by myself
    private static BodyImage worm = new BodyImage("Assets/worm.gif", 6f);
    Shape body = new PolygonShape(-1.09f,1.22f, 0.1f,1.2f, 1.04f,-0.8f, 1.42f,-2.17f, -0.3f,-1.07f,
            -1.49f,0.55f, -1.09f,1.22f);

    public Worm(World w) {
        super(w);
        setGravityScale(4);
        MainCharacter mc;
        SolidFixture wormFixture = new SolidFixture(this, body, 0f);
        addImage(worm);
        wormHP = 3;
    }
}

