/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import java.awt.Color;

/**
 * A <code>Flower</code> is an actor that darkens over time. Some actors drop
 * flowers as they move. <br />
 * The API of this class is testable on the AP CS A and AB exams.
 */

public class Blossom extends Flower
{
    private static final Color DEFAULT_COLOR = Color.GREEN;
    private static double DARKENING_FACTOR;
    private int lifetime;
    private int count;

    // lose 5% of color value in each step

    /**
     * Constructs a pink flower.
     */
    public Blossom()
    {
        lifetime = 10;
        DARKENING_FACTOR = 1.00/lifetime;
        setColor(DEFAULT_COLOR);
    
    }

    /**
     * Constructs a flower of a given color.
     * @param initialColor the initial color of this flower
     */
    public Blossom(int lifeSteps)
    {
        lifetime = lifeSteps;
        setColor(DEFAULT_COLOR);
        DARKENING_FACTOR = 1.00/lifetime;

    }

    /**
     * Causes the color of this flower to darken.
     */
    public void act()
    {
        
        Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

        this.setColor(new Color(red, green, blue));

        count++;

        if (count == lifetime) {
            removeSelfFromGrid();
        }
    }
}
