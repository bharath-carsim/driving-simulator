/**
 *
 */
package com.amdocs.driving.simulator.execute;

import com.amdocs.driving.simulator.execute.exception.InitialPositionNotSetException;
import com.amdocs.driving.simulator.execute.exception.OutOfGridException;

/**
 * @author bmaturi
 */
public interface ExecuteInstruction {

    /**
     * Sets the initial position of the vehicle if the position is valid else ignores the setting.
     *
     * @param X
     * @param Y
     * @param initialdirection
     * @throws OutOfGridException
     */
    public void setInitialPosition(Position initPosition) throws OutOfGridException;

    /**
     * Changes the direction of the vehicle LEFT/RIGHT based on the current direction the vehicle is
     * pointing to.
     *
     * @param changeDirection
     * @throws InitialPositionNotSetException
     */
    public void changeDirection(String leftOrRight) throws InitialPositionNotSetException;

    /**
     * @throws OutOfGridException
     * @throws InitialPositionNotSetException
     */
    public void move() throws OutOfGridException, InitialPositionNotSetException;

    /**
     * @return the current position
     * @throws InitialPositionNotSetException
     */
    public String getPosition();
}
