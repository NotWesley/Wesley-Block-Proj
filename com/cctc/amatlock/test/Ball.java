package com.cctc.amatlock.test;

import java.awt.*;

public class Ball extends CoreObject
{

    /**
     * Creates the core object. All subclasses
     * will call this with super.
     * The super call to the Rectangle class.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     */
    public Ball(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void tick()
    {
        // X is the horizontal coordinate... Ugh...
        if(y < 0)
        {
            System.out.println("Bounce!");
            setVelY(getVelY() * -1);
        }
        else if(y > Reference.HEIGHT)
        {
            Screen.getInstance().reset();
        }

        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
