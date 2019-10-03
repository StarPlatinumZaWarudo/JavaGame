import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

/**
 * this loads and creates the level design of level 2.
 */


public class Level2 extends GameWorld {
    private SoundClip lvl2Music;

    public Level2(Main main) {
        super(main);
        populate(main);

    }

@Override
    public void populate(Main main) {
        // creation and design of level 2
        super.populate(main);


        Shape groundShape = new BoxShape(200, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, 0));

        int x = 6;

        for (int i = 0; i < x; i++) {
            Shape platShape = new BoxShape(20, 0.5f);
            Body platform = new StaticBody(this, platShape);
            platform.setPosition(new Vec2(10 + i*20, 5+ i*4));

        }


        Worm worm = new Worm(this);
        worm.setPosition(new Vec2(20, 27f));
        worm.addCollisionListener(new CollisionHandler(this.getMc(), main));


        //add health
        Health health = new Health(this);
        health.setPosition(new Vec2(-25, 3f));
        health.addCollisionListener(new CollisionHandler(this.getMc(), main));

        //add shard
        AetherShard shard = new AetherShard(this);
        shard.setPosition(new Vec2(55, 33f));
        shard.addCollisionListener(new PickUp(getMc()));

        EyeBat eyeBat = new EyeBat(this);
        eyeBat.setPosition(new Vec2(35, 50f));
        eyeBat.addCollisionListener(new CollisionHandler(this.getMc(), main));

        Door2 portal = new Door2(this);
        portal.setPosition(new Vec2(70, 40f));
        portal.addCollisionListener(new CollisionHandler(this.getMc(), main));


    }

    public Vec2 setPosMC() {
        return new Vec2(-20, 3);
    }
    public Vec2 setPosDragon(){
        return new Vec2 (-100,-1000);
    }
}