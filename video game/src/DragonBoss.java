import city.cs.engine.*;

/**
 * New Addition for milestone 3.
 * this is the class for the final boss of the game.
 */

public class DragonBoss extends Walker {
    public int dragonHP;
    public int victory;

    public int getDragonHP(){
        return dragonHP;
    }
    public void setDragonHP(int dragonHP){
        this.dragonHP = dragonHP;
    }
    // creates boss
    // gif was created by myself
    private static BodyImage dragon = new BodyImage("Assets/Dragon.gif", 15f);
    Shape body = new PolygonShape(7.35f,7.41f, -7.38f,7.41f, -7.41f,-7.23f, 6.75f,-7.17f, 7.71f,7.38f);



    public DragonBoss(World w) {

        super(w);
        setGravityScale(1);
        SolidFixture dragonFixture = new SolidFixture(this, body, 1000f);
        addImage(dragon);
        dragonHP = 100;



    }


}