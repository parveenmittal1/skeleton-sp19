package creatures;

import huglife.Action;
import huglife.Creature;
import huglife.Direction;
import huglife.Occupant;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Clorus extends Creature {
    private double moveProbability = .1;

    double energy;
    private int r;
    private int g;
    private int b;


    public Clorus(double i) {
        super("clorus");
        energy=i;
        r=0;
        g=0;
        b=0;
    }

    public Clorus() {
        this(1);
    }

    public double energy() {
        return this.energy;
    }

    public void move() {
        if(energy>0)
        this.energy=energy-0.03;
        else this.energy=energy;
    }


    public void attack(Creature c) {
        this.energy=this.energy+c.energy();

    }

    public Color color() {
            r = 34;
            g = 0;
            b=231;
            return color(r, g, b);

    }
    public static Color color(int r,int g,int b) {
        return new Color(r,g,b);
    }

    public void stay() {
        if(energy>0)
            this.energy=energy-0.01;
        else this.energy=energy;
    }



    public Clorus replicate() {
        {
            this.energy=energy/2;
            return new Clorus(this.energy/2);
        }
    }

    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        for (Direction entry : neighbors.keySet())
        {
             if (neighbors.get(entry.TOP).name().equals("plip")) {
            return new Action(Action.ActionType.ATTACK, Direction.TOP);
        } else if (neighbors.get(entry.BOTTOM).name().equals("plip")) {
            return new Action(Action.ActionType.ATTACK, Direction.BOTTOM);
        } else if (neighbors.get(entry.LEFT).name().equals("plip")) {
            return new Action(Action.ActionType.ATTACK, Direction.LEFT);
        } else if (neighbors.get(entry.RIGHT).name().equals("plip")) {
            return new Action(Action.ActionType.ATTACK, Direction.RIGHT);
        }
         else   if (neighbors.get(entry.TOP).name().equals("empty") && this.energy() >= 1.0&&Math.random() < moveProbability) {
                return new Action(Action.ActionType.REPLICATE, Direction.TOP);
            } else if (neighbors.get(entry.BOTTOM).name().equals("empty") && this.energy() >= 1.0&&Math.random() < moveProbability) {
                return new Action(Action.ActionType.REPLICATE, Direction.BOTTOM);
            } else if (neighbors.get(entry.LEFT).name().equals("empty") && this.energy() >= 1.0&&Math.random() < moveProbability) {
                return new Action(Action.ActionType.REPLICATE, Direction.LEFT);
            } else if (neighbors.get(entry.RIGHT).name().equals("empty") && this.energy() >= 1.0&&Math.random() < moveProbability) {
                return new Action(Action.ActionType.REPLICATE, Direction.RIGHT);
            } else if (neighbors.get(entry.TOP).name().equals("empty")&&Math.random() < moveProbability) {
                return new Action(Action.ActionType.MOVE, Direction.TOP);
            } else if (neighbors.get(entry.BOTTOM).name().equals("empty")&&Math.random() < moveProbability) {
                return new Action(Action.ActionType.MOVE, Direction.BOTTOM);
            } else if (neighbors.get(entry.LEFT).name().equals("empty")&&Math.random() < moveProbability) {
                return new Action(Action.ActionType.MOVE, Direction.LEFT);
            } else if (neighbors.get(entry.RIGHT).name().equals("empty")&&Math.random() < moveProbability) {
                return new Action(Action.ActionType.MOVE, Direction.RIGHT);
            }
            else {
                return new Action(Action.ActionType.STAY);
            }
        }
        return null;
    }
}

