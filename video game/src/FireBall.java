import city.cs.engine.*;

/**
 * New Addition for milestone 3.
*the boss shoots fire into the air which drop down taking away 1 HitPoints from the main character.
 */

public class FireBall extends DynamicBody {

    private static BodyImage fireball = new BodyImage("Assets/fireBall.png", 6f);
    Shape body = new PolygonShape(-3.12f,1.4f, -3.12f,-0.46f, -0.3f,-2.11f, 4.24f,0.21f, -0.37f,2.61f, -3.09f,1.63f);




    public FireBall(World w) {

        super(w);
        SolidFixture fireballFixture = new SolidFixture(this, body, 10000f);
        addImage(fireball);

    }
}
