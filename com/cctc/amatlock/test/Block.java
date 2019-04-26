package com.cctc.amatlock.test;

import java.awt.*;

public class Block extends CoreObject
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
    boolean broken = false;

    public Block(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
    }

    @Override
    public void tick()
    {
        if(broken)
        {
            return;
        }

        Rectangle right = new Rectangle(x + width, y, 1, 20);
        Rectangle left = new Rectangle(x, y, 1, 20);
        Ball ball = Screen.getInstance().ball;

        if(intersects(ball))
        {
            if(ball.intersects(left) || ball.intersects(right))
            {
                broken = true;
                ball.setVelX(ball.getVelX() * -1);
            }
            else
            {
                broken = true;
                ball.setVelY(ball.getVelY() * -1);
            }
        }
    }

    @Override
    public void render(Graphics g)
    {
        if(!broken)
        {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }
}
