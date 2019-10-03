import city.cs.engine.*;

/**
 * this is the body that has the collision for transitioning to level 2.
 */

public class Lvl1Exit extends StaticBody {


    private static BodyImage castle = new BodyImage("Assets/castle.png", 50f);

    Shape building = new PolygonShape(2,2,2,2);




    public Lvl1Exit(World w) {
        super(w);

        SolidFixture castleFixture = new SolidFixture(this, building, 100f);

        addImage(castle);


    }



}

