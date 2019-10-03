import city.cs.engine.*;

/**
this is an enemy in the game that drops from great heights.
 */

public class EyeBat extends Walker {
    private static int eyeHP;
    public static void setEyeHP( int eyeHP){
        EyeBat.eyeHP = eyeHP;
    }
    public static int getEyeHP(){
        return eyeHP;

    }
    // creates enemy
    // gif was created by myself

    private static BodyImage eyeBat = new BodyImage("Assets/EyeBat.gif", 6f);
    Shape body = new PolygonShape(-2.86f,2.3f, 2.94f,2.24f, 0.35f,-1.16f, -2.86f,2.29f);



    public EyeBat(World w) {
        super(w);
        setGravityScale(10);
        MainCharacter mc;

        SolidFixture eyeBatFixture = new SolidFixture(this, body, 10000f);

        addImage(eyeBat);
        eyeHP = 3;



    }


}