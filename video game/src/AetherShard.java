import city.cs.engine.*;


/**
 *  creates shard which is a pickup item and calls it into world.
 */
public class AetherShard extends DynamicBody {
// gif was created by myself
    private static BodyImage shard = new BodyImage("Assets/AetherShard.gif", 3f);
    Shape body = new PolygonShape(-1.33f,-2.94f, 1.38f,-2.95f, 2.21f,-1.04f, 1.46f,1.45f, -0.92f,1.5f,
            -2.18f,0.58f, -2.23f,-0.97f, -1.33f,-2.94f);


// calls shard into world
    public AetherShard(World w) {
        super(w);

        SolidFixture ShardFixture = new SolidFixture(this, body, 1000f);


        addImage(shard);

    }



}