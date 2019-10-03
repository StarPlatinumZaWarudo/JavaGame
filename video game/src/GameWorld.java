import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
this is the hub of the game and links all the levels and all the things common between levels.
 */

public abstract class GameWorld extends World {

    private MainCharacter mc;

    public MainCharacter getMc(){
        return mc;
    }

    private DragonBoss dragonBoss;
    public DragonBoss getDragonBoss(){
        return dragonBoss;
        }

    public GameWorld(Main main) {
        super(30);
        dragonBoss = new DragonBoss(this);
        dragonBoss.setPosition(setPosDragon());
    }
    public void populate (Main main){
        mc = new MainCharacter(this);
        mc.setPosition(setPosMC());
    }
    public abstract Vec2 setPosMC();
    public abstract Vec2 setPosDragon();

}


