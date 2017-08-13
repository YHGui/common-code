package week10.lab15.creatures;


import week10.lab15.huglife.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

/** An implementation of a motile pacifist photosynthesizer.
 *  @author Josh Hug
 */
public class Plip extends Creature {
    private static final double ENERGY_LOST = 0.15;
    private static final int RED = 99;
    private static final int BLUE = 76;
    private static final double MAX_ENERGY = 2.0;
    private static final double ENERGY_GAIN = 0.2;

    /** red color. */
    private int r;
    /** green color. */
    private int g;
    /** blue color. */
    private int b;

    /** creates plip with energy equal to E. */
    public Plip(double e) {
        super("plip");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /** creates a plip with energy equal to 1. */
    public Plip() {
        this(1);
    }

    /** Should return a color with red = 99, blue = 76, and green that varies
     *  linearly based on the energy of the Plip. If the plip has zero energy,
     *  it should have a green value of 63. If it has max energy, it should
     *  have a green value of 255. The green value should vary with energy
     *  linearly in between these two extremes. It's not absolutely vital
     *  that you get this exactly correct.
     */
    public Color color() {
        double e = energy();
        g = 63;
        g = g + (int)((255 - 63) * e / (MAX_ENERGY - 0.0));
        return color(RED, g, BLUE);
    }

    /** Do nothing with C, Plips are pacifists(和平主义者). */
    public void attack(Creature c) {
        //DO NOTHING
    }

    /** Plips should lose 0.15 units of energy when moving. If you want to
     *  to avoid the magic number warning, you'll need to make a
     *  private static final variable. This is not required for this lab.
     */
    public void move() {
        energy = energy - ENERGY_LOST;
    }


    /** Plips gain 0.2 energy when staying due to photosynthesis. */
    public void stay() {
        energy = energy() + ENERGY_GAIN;
        if (energy > 2) {
            energy = MAX_ENERGY;
        }
    }

    /** Plips and their offspring each get 50% of the energy, with none
     *  lost to the process. Now that's efficiency! Returns a baby
     *  Plip.
     */
    public Plip replicate() {
        energy = energy / 2;
        Plip offspring = new Plip(energy);
        return offspring;
    }

    /** Plips take exactly the following actions based on NEIGHBORS:
     *  1. If no empty adjacent spaces, STAY.
     *  2. Otherwise, if energy >= 1, REPLICATE.
     *  3. Otherwise, if any Cloruses, MOVE with 50% probability.
     *  4. Otherwise, if nothing else, STAY
     *
     *  Returns an object of type Action. See Action.java for the
     *  scoop on how Actions work. See SampleCreature.chooseAction()
     *  for an example to follow.
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> empties = getNeighborsOfType(neighbors, "empty");
        List<Direction> cloruses = getNeighborsOfType(neighbors, "clorus");
        if (empties.size() == 0) {
            return new Action(Action.ActionType.STAY);
        } else if (energy >= 1) {
            Direction replicate = HugLifeUtils.randomEntry(empties);
            return new Action(Action.ActionType.REPLICATE, replicate);
        } else if (cloruses.size() > 0 && HugLifeUtils.random() >= 0.25) {
            Direction flee = HugLifeUtils.randomEntry(empties);
            return new Action(Action.ActionType.MOVE, flee);
        } else {
            return new Action(Action.ActionType.STAY);
        }
    }

}
