import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * this is body increases the HitPoints of the Main character if his HP is less than 3.
 */

public class Health extends DynamicBody {

// gif was created by myself
    private static BodyImage health = new BodyImage("Assets/Health.gif", 3f);
    Shape body = new PolygonShape(-0.19f,2.72f, -2.63f,2.4f, -2.66f,-2.42f, 0.1f,-2.84f,
            2.75f,-2.4f, 2.75f,2.45f, -0.19f,2.72f);



    public Health(World w) {
        super(w);
        AttachedImage healthImage = new AttachedImage(this, health,1,0,new Vec2(0,1.5f));
        SolidFixture healthFixture = new SolidFixture(this, body, 0);
    }



}