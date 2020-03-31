package creatures;
import huglife.*;
import javafx.scene.input.Dragboard;
import org.junit.Test;
import sun.plugin2.main.server.Plugin;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import java.util.Map;
//import sun.misc.ClassLoaderUtil;

import static org.junit.Assert.assertEquals;

public class TestClorus {
    /** Tests the plip class
     *  @author Parveen Kumar
     */

        @Test
        public void testBasics() {
            Clorus c = new Clorus(2);
            assertEquals(2, c.energy(), 0.01);
            assertEquals(new Color(34, 0, 231), c.color());
            c.move();
            assertEquals(1.97, c.energy(), 0.01);
            c.move();
            assertEquals(1.94, c.energy(), 0.01);
            c.stay();
            assertEquals(1.93, c.energy(), 0.01);
            c.stay();
            assertEquals(1.92, c.energy(), 0.01);
        }

        @Test
        public void testReplicate() {
            Clorus c =new Clorus(8);
            assertEquals(8, c.energy(), 0.01);
            assertEquals(new Color(34,0, 231), c.color());
            Clorus temp=c.replicate();
            assertEquals(4, c.energy(), 0.01);
            assertNotSame(c, temp);
        }

        @Test
        public void testAttack(){
            {
                Clorus c =new Clorus(18);
                assertEquals(18, c.energy(), 0.01);
                assertEquals(new Color(34,0, 231), c.color());
                c.attack(new Plip(8));
                assertEquals(26, c.energy(), 0.01);
            }
        }

        @Test
        public void testChoose() {

            // No empty adjacent spaces; stay.
            Clorus c = new Clorus(1.2);
            HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
            surrounded.put(Direction.TOP, new Impassible());
            surrounded.put(Direction.BOTTOM, new Impassible());
            surrounded.put(Direction.LEFT, new Impassible());
            surrounded.put(Direction.RIGHT, new Impassible());

            Action actual = c.chooseAction(surrounded);
            Action expected = new Action(Action.ActionType.STAY);

            assertEquals(expected, actual);


            // Energy >= 1; replicate towards an empty space.
            c = new Clorus(1.2);
            HashMap<Direction, Occupant> topEmpty = new HashMap<Direction, Occupant>();
            topEmpty.put(Direction.TOP, new Empty());
            topEmpty.put(Direction.BOTTOM, new Impassible());
            topEmpty.put(Direction.LEFT, new Impassible());
            topEmpty.put(Direction.RIGHT, new Impassible());

            actual = c.chooseAction(topEmpty);
            expected = new Action(Action.ActionType.REPLICATE, Direction.TOP);

            assertEquals(expected, actual);


            // Energy >= 1; replicate towards an empty space.
            c = new Clorus(1.2);
            HashMap<Direction, Occupant> allEmpty = new HashMap<Direction, Occupant>();
            allEmpty.put(Direction.TOP, new Empty());
            allEmpty.put(Direction.BOTTOM, new Empty());
            allEmpty.put(Direction.LEFT, new Empty());
            allEmpty.put(Direction.RIGHT, new Empty());

            actual = c.chooseAction(allEmpty);
            // Action expected2 = new Action(Action.ActionType.STAY);

            assertEquals(expected, actual);



            c = new Clorus(1.2);
            HashMap<Direction, Occupant> topEmpty2 = new HashMap<Direction, Occupant>();
            topEmpty2.put(Direction.TOP, new Plip());
            topEmpty2.put(Direction.BOTTOM, new Plip());
            topEmpty2.put(Direction.LEFT, new Plip());
            topEmpty2.put(Direction.RIGHT, new Plip());

            actual = c.chooseAction(topEmpty2);
            expected = new Action(Action.ActionType.ATTACK, Direction.TOP);

            assertEquals(expected, actual);


            // Energy < 1; stay.
            c = new Clorus(.99);

            actual = c.chooseAction(allEmpty);
            expected = new Action(Action.ActionType.MOVE, Direction.TOP);

            assertEquals(expected, actual);


            // Energy < 1; stay.
            c = new Clorus(.99);

            actual = c.chooseAction(topEmpty);
            expected = new Action(Action.ActionType.MOVE,Direction.TOP);

            assertEquals(expected, actual);


            // We don't have Cloruses yet, so we can't test behavior for when they are nearby right now.
        }
    }
