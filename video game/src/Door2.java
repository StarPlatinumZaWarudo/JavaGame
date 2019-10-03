import city.cs.engine.*;

/**
 *  creates door 2.
*  this is the transition to level 3.
 */

public class Door2 extends StaticBody {private static BodyImage portal = new BodyImage("Assets/Portal.gif", 6f);


    Shape port = new PolygonShape(-5.2f,-11.5f, -5.1f,5.3f);

    public Door2(World w){
        super(w);

        SolidFixture portFixture = new SolidFixture(this, port, 100f);

        addImage(portal);
    }
}
