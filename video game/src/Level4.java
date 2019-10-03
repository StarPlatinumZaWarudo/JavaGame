import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * New Addition for milestone 3
 * this loads and creates the level design of level 4.
 */

public class Level4 extends GameWorld {

    public Level4(Main main) {
        super(main);
        populate(main);
    }


    @Override
    public void populate(Main main) {
        // creation and design of level 4
        super.populate(main);

        Shape groundShape = new BoxShape(150, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        int x = 100;
        for (int i = 0; i <= x; i = i + 10) {
            FireBall fireBall = new FireBall(this);
            fireBall.setPosition(new Vec2(15 + i, (float) Math.random() * 500 + 500));
            fireBall.addCollisionListener(new CollisionHandler(this.getMc(), main));
        }

    }
    @Override
    public Vec2 setPosMC() {
        return new Vec2(-20, 3);
    }
    public Vec2 setPosDragon(){
        return new Vec2 (100,500);
    }
}
