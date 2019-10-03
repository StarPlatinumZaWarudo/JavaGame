import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * this loads and creates the level design of level 3.
 */

public class Level3 extends GameWorld {
    public Level3(Main main) {
        super(main);
        populate(main);
    }


    @Override
    public void populate(Main main) {
        // creation and design of level 3
        super.populate(main);


        Shape groundShape = new BoxShape(220, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));

        int x = 150;
        for (int i = 0; i < x; i = i + 10) {
            Worm worm = new Worm(this);
            worm.setPosition(new Vec2(-60 + i, 3));
            worm.addCollisionListener(new CollisionHandler(this.getMc(), main));

            EyeBat eyeBat = new EyeBat(this);
            eyeBat.setPosition(new Vec2(-60 + i, (float) Math.random() * 500 + 500));
            eyeBat.addCollisionListener(new CollisionHandler(this.getMc(), main));
        }
        int y = 3;
        for (int i = 0; i < y; i++) {
            Health health = new Health(this);
            health.setPosition(new Vec2(-100 - y, 3));
            health.addCollisionListener(new CollisionHandler(this.getMc(), main));
        }
        Door3 gargoyle = new Door3(this);
        gargoyle.setPosition(new Vec2(180, 3));
        gargoyle.addCollisionListener(new CollisionHandler(this.getMc(), main));

        AetherShard aetherShard = new AetherShard(this);
        aetherShard.setPosition(new Vec2(175, 3));
        aetherShard.addCollisionListener(new PickUp(getMc()));

    }

    @Override
    public Vec2 setPosMC() {
        return new Vec2(-90, 3);
    }
    public Vec2 setPosDragon(){
        return new Vec2 (-100,-1000);
    }
}
