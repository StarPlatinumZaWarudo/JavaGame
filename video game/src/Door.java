import city.cs.engine.*;

/**
As i just wanted the door of the castle to be the collision to trasition to level 2 i had to create a door over the castle at the end of level 1.
 */
// image was created by myself
public class Door extends StaticBody {private static BodyImage door = new BodyImage("Assets/Door.png", 50f);


    Shape exit = new PolygonShape(-5.2f,-11.5f, -5.1f,5.3f);

    public Door(World w){
        super(w);

        SolidFixture doorFixture = new SolidFixture(this, exit, 100f);

        addImage(door);
    }
}
