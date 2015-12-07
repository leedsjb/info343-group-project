import uwcse.graphics.*;
import java.util.*;

/**
 * The simulation of a solar system
 * @author CSC 143
 */
public class SolarSystem extends GWindowEventAdapter {

    // To display the planets and moons
    private GWindow window;

    // The scale used to draw the objects
    private double scale;

    // The speed of the animation in ms
    private int animationPeriod = 100;

    // The Sun
    private Sun sun = new Sun(2E+30);

    // The other astronomical objects
    private ArrayList planetsAndMoons = new ArrayList();


    /**
     * Creates a solar system made of the Sun, Venus, the Earth and the Moon,
     * and Mars
     */
    public SolarSystem() {
        window = new GWindow("Solar System", 400, 400);
        window.setExitOnClose();
        window.addEventHandler(this);
        scale = 200 / 2.3E+11;

        Planet venus = new Planet(sun, 1E11, 1E7, 4.88E24);
        Planet earth = new Planet(sun, 1.5E11, 1E7, 5.98E24);
        Planet mars = new Planet(sun, 2.28E11, 1E7, 6.42E23);
        Moon moon = new Moon(earth, 4E8, 3.E6, 7.4E22);
        planetsAndMoons.add(venus);
        planetsAndMoons.add(earth);
        planetsAndMoons.add(mars);
        planetsAndMoons.add(moon);

        // draw the solar system
        draw();
    }

    /**
     * Handles the keyboard commands (namely starts and stops the animation, and
     * exits the application)
     * 'Q' to quit
     * 'A' to start the animation
     * 'S' to stop the animation
     * @param e the GWindowEvent that describes the keyboard event
     */
    public void keyPressed(GWindowEvent e) {
        switch(Character.toUpperCase(e.getKey())) {
            // Exit
            case 'Q':
                window.stopTimerEvents();
                System.exit(0);
                break;
            // Start the animation
            case 'A':
                window.startTimerEvents(animationPeriod);
                break;
            // Stop the animation
            case 'S':
                window.stopTimerEvents();
                break;
        }
    }

    /**
     * Moves the objects around the sun at every step of the animation
     * @param e the GWindowEvent that describes the animation event
     */
    public void timerExpired(GWindowEvent e) {
        // Move all of the objects (except the sun)
        Iterator it = planetsAndMoons.iterator();
        while(it.hasNext()) {
            AstronomicalObject astrObject = (AstronomicalObject) it.next();
            astrObject.move(24 * 3600 * 5); // 5 days
        }
        // draw the solar system
        draw();
    }

    /**
     * Draws the solar system
     */
    private void draw() {
        window.erase();
        sun.draw(window, scale);
        Iterator it = planetsAndMoons.iterator();
        while(it.hasNext()) {
            AstronomicalObject astrObject = (AstronomicalObject) it.next();
            astrObject.draw(window, scale);
        }
    }
}






