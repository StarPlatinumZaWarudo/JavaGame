import city.cs.engine.*;

/**
this is the transition to level 4.
 */

public class Door3 extends StaticBody {private static BodyImage gargoyle = new BodyImage("Assets/gargoyle.png", 3f);


    Shape gar = new PolygonShape(3,3,3,3);

    public Door3(World w){
        super(w);

        SolidFixture doorFixture = new SolidFixture(this, gar, 10f);

        addImage(gargoyle);
    }
}
