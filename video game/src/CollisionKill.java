import city.cs.engine.CollisionListener;
import city.cs.engine.CollisionEvent;

/**
 * this handles the collisions with the projectile and other bodies such as enemies etc.
 */

public class CollisionKill implements CollisionListener {
    public Airslash airslash;

    public CollisionKill(Airslash airslash) {
        this.airslash = airslash;
    }

    public void collide(CollisionEvent e) {
// kills enemy if projectile collides with enemy
        if (e.getOtherBody() instanceof EyeBat) {
            EyeBat.setEyeHP(EyeBat.getEyeHP() -10);
            if (EyeBat.getEyeHP() <= 0) {
                e.getReportingBody().destroy();
                e.getOtherBody().destroy();
            }
        }
        // kills enemy if projectile collides with enemy
        if (e.getOtherBody() instanceof Worm) {
            Worm.setWormHP(Worm.getWormHP() - 10);
            if (Worm.getWormHP() <= 0) {
                e.getReportingBody().destroy();
                e.getOtherBody().destroy();


            }
        }


        if (e.getOtherBody() instanceof DragonBoss && e.getReportingBody() instanceof Airslash) {
            ((DragonBoss) e.getOtherBody()).setDragonHP(((DragonBoss) e.getOtherBody()).getDragonHP() - 10);
            if (((DragonBoss) e.getOtherBody()).getDragonHP() <= 0) {
                e.getOtherBody().destroy();
                e.getReportingBody();

            }
        }
             // destroys projectile if it collides with anything
                if(e.getReportingBody() instanceof Airslash){
                    e.getReportingBody().destroy();
                }
    }
}






