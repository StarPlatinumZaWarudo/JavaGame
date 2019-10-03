import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

/**
 * this loads and creates the level design of level 1.
 */

public class Level1 extends GameWorld {
// calls level one into game
    private SoundClip lvl1Music;

    public Level1(Main main) {
        super(main);
        populate(main);
    }
    @Override
    public void populate(Main main) {
        // creation and design of level 1
        super.populate(main);

        Shape shape = new BoxShape(120, 10f);
        Body ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(70, 0));
        ground.addImage(new BodyImage("Assets/ground.png", 20f));


        Shape plat = new BoxShape(12, 0.5f);
        Body platform = new StaticBody(this, plat);
        platform.setPosition(new Vec2(40, 20f));
        platform.addImage(new BodyImage("Assets/ground.png", 2f));


        //add worm
        Worm worm = new Worm(this);
        worm.setPosition(new Vec2(40, 3));
        worm.addCollisionListener(new CollisionHandler(this.getMc(), main));


        //add health
        Health health = new Health(this);
        health.setPosition(new Vec2(40, 30));
        health.addCollisionListener(new CollisionHandler(this.getMc(), main));

        //add shard
        AetherShard shard = new AetherShard(this);
        shard.setPosition(new Vec2(43, 30));
        shard.addCollisionListener(new PickUp(getMc()));

        EyeBat eyeBat = new EyeBat(this);
        eyeBat.setPosition(new Vec2(80, 500));
        eyeBat.addCollisionListener(new CollisionHandler(this.getMc(), main));


        Castle castle = new Castle(this);
        castle.setPosition(new Vec2(-30, 30));

        Door door = new Door(this);
        door.setPosition(new Vec2(150, 14));
        door.addCollisionListener(new CollisionHandler(this.getMc(), main));


        Lvl1Exit exit = new Lvl1Exit(this);
        exit.setPosition(new Vec2(150, 31));


    }

    public Vec2 setPosMC() {
        // sets pos of main character
        return new Vec2(-8, 3);
    }
    public Vec2 setPosDragon(){
        return new Vec2 (-10,-1000);
    }

}

