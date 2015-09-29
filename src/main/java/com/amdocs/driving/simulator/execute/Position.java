/**
 *
 */
package com.amdocs.driving.simulator.execute;

import com.amdocs.driving.simulator.data.Direction;

/**
 * @author bmaturi
 */
public class Position {

    private int xPosition = 0;

    private int yPosition = 0;

    private Direction direction = Direction.NORTH;

    /**
     * @return the xPosition
     */
    public int getxPosition() {
        return xPosition;
    }

    /**
     * @param xPosition
     *            the xPosition to set
     */
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    /**
     * @return the yPosition
     */
    public int getyPosition() {
        return yPosition;
    }

    /**
     * @param yPosition
     *            the yPosition to set
     */
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction
     *            the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     *
     */
    public void moveX() {
        xPosition++;
    }

    /**
     *
     */
    public void moveY() {
        yPosition++;
    }

    @Override
    public String toString() {
        return xPosition + "," + yPosition + "," + direction;
    }

}
