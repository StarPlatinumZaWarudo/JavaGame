import city.cs.engine.*;

/**
 * creates castle.
 */
public class Castle extends StaticBody {

    private static BodyImage castle = new BodyImage("Assets/castle.png", 50f);


    Shape building = new PolygonShape(-23.9f,24.1f, -23.3f,-23.7f, 23.3f,-24.0f, 23.6f,24.1f);

// calls castle into world
    public Castle(World w) {
        super(w);

        SolidFixture castleFixture = new SolidFixture(this, building, 100f);

        addImage(castle);

    }
}
