import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;

import java.util.ArrayList;


public class RockHound extends Critter {
    
    public void processActors(ArrayList<Actor> actors)
    {
        
        for (int i = 0; i < actors.size(); i++) {
            if (actors.get(i) instanceof Rock) {
                actors.get(i).removeSelfFromGrid();
            }
        }
    }

    
}