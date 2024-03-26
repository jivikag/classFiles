import info.gridworld.actor.Critter;
import java.awt.Color;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class BlusterCritter extends Critter {
    
    private int c;
    private final double DARKENING_FACTOR = 0.05;

    public BlusterCritter(int courage) {
        c = courage;
    }

    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();

        Location loc = getLocation();
        for(int r = loc.getRow() - 2; r <= loc.getRow() + 2; r++ )
            for(int c = loc.getCol() - 2; c <= loc.getCol() + 2; c++)
            {
                Location tempLoc = new Location(r,c);
                if(getGrid().isValid(tempLoc))
                {
                    Actor a = getGrid().get(tempLoc);
                    if(a != null && a != this)
                        actors.add(a);
                }
            }
        return actors;
    }
    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (actors.get(i) instanceof Critter) {
                count++;
            }
        }
        if (count >= c) {
            Color c = getColor();
            int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
            int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
            int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
            setColor(new Color(red, green, blue)); 
            return;

        }
        else {
            Color c = getColor();
            int red = c.getRed();
            int green = c.getGreen();
            int blue = c.getBlue();
            if(red < 255) red++;
            if(green < 255) green++;
            if(blue < 255) blue++;
            setColor(new Color(red, green, blue)); 
        }
        
     
    }
}