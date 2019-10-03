import city.cs.engine.*;



/**
 * creates projectile.
 *calls projectile into the world.
 */
public class Airslash extends DynamicBody {
    MainCharacter mc;
// png was created by myself
    private static BodyImage airslash = new BodyImage("Assets/Airslash.png", 6f);
    Shape body = new PolygonShape(1.22f,2.81f, 1.6f,0.1f, 1.2f,-2.76f, -1.13f,-2.82f, -1.2f,2.8f, 1.22f,2.81f);



    public Airslash(World w) {

        super(w);

        SolidFixture airslashFixture = new SolidFixture(this, body, 0f);
        addImage(airslash);
        this.addCollisionListener(new CollisionKill(this));
        //this.addCollisionListener(new CollisionKill(this.);
    }

    public void AirSlash(){
        addImage(airslash);
        //this.addCollisionListener(new CollisionKill(this));



    }

    public static BodyImage getAirslash() {
        return airslash;
    }

    public static void setAirslash(BodyImage airslash) {
        Airslash.airslash = airslash;

    }

}