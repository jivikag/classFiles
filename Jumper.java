import info.gridworld.actor.Bug;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color; 

public class Jumper extends Bug
{

    public Jumper()
    {

        setColor(Color.BLUE);
    }
   
    public Jumper(Color JumperColor)
    {
        setColor(JumperColor);
    }
    public void act()
    {
        if (canMove())
            move();
        else
            turn();
    }
    

    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    } 

    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location twoAway = next.getAdjacentLocation(getDirection());
        if (gr.isValid(twoAway)) {
            moveTo(twoAway);
        }
        else
            removeSelfFromGrid();

        Blossom blossom = new Blossom();
        blossom.putSelfInGrid(gr, loc);
    }
   
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        if (!((neighbor == null))
        || (neighbor instanceof Rock))
            return false;
        Location twoAway = next.getAdjacentLocation(getDirection());
        if (!gr.isValid(twoAway))
            return false;

        neighbor = gr.get(twoAway);
        return (neighbor == null);
    }
}