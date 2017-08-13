package week10.lab15.creatures;

import week10.lab15.huglife.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Katsura on 2017/5/11.
 */
public class Clorus extends Creature{
    /** red color.*/
    private int r;
    /** green color.*/
    private int g;
    /** blue color.*/
    private int b;
    private static final double ENERGY_LOST = 0.03;
    private static final double ENERGY_STAY = 0.01;

    public Clorus(double e){
        super("clorus");
        r = 34;
        g = 0;
        b = 231;
        energy = e;
    }

    public Clorus(){
        this(1);
    }

    @Override
    public void move() {
        energy -= ENERGY_LOST;
    }

    @Override
    public void attack(Creature c) {
        energy += c.energy();
    }

    @Override
    public Color color() {
        b = (int)(10 * energy + 120);
        if (b > 231) {
            b = 231;
        }
        return color(r, g, b);
    }

    @Override
    public Creature replicate() {
        energy= energy/2;
        return new Clorus(energy);
    }

    @Override
    public void stay() {
        energy -= ENERGY_STAY;
    }

    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> empties = getNeighborsOfType(neighbors, "empty");
        List<Direction> plips = getNeighborsOfType(neighbors,"plip");

        if(empties.size() == 0){
            return new Action(Action.ActionType.STAY);
        }else if(plips.size() >= 1){
            Direction attackDir = HugLifeUtils.randomEntry(plips);
            return new Action(Action.ActionType.ATTACK, attackDir);
        }else if(energy >= 1){
            Direction replicateDir = HugLifeUtils.randomEntry(empties);
            return new Action(Action.ActionType.REPLICATE, replicateDir);
        }else {
            Direction moveDir = HugLifeUtils.randomEntry(empties);
            return new Action(Action.ActionType.MOVE, moveDir);
        }

    }

}

