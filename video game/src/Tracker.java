

import city.cs.engine.Body;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;

/**
 * this makes the view as well as the background move with the main character for a sidescrolling experience.
 */

public class Tracker implements StepListener {
    private WorldView view;
    private MainCharacter mc;

    public void setMc(MainCharacter mc) {
        this.mc = mc;
    }
    public void setView(WorldView view) {
        this.view = view;
    }
    public Tracker(WorldView view, MainCharacter mc) {
        this.view = view;
        this.mc = mc;
    }
    public void preStep(StepEvent e) {
        Main.window.requestFocusInWindow();
    }
    public void postStep(StepEvent e) {
        // places main character in centre of the view and moves the background along with the main character
    this.view.setCentre(new Vec2(0,0));
        if(mc.getPosition() == view.getCentre()) {
            this.view.setCentre(new Vec2(mc.getPosition()));
        }
        else {
            this.view.setCentre(new Vec2(mc.getPosition()));
        }
    }
}
