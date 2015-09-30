/**
 *
 */
package com.amdocs.driving.simulator.execute;

import com.amdocs.driving.simulator.constants.CONSTANTS;
import com.amdocs.driving.simulator.data.Direction;
import com.amdocs.driving.simulator.execute.exception.InitialPositionNotSetException;
import com.amdocs.driving.simulator.execute.exception.OutOfGridException;

/**
 * @author bmaturi
 */
public class ExecuteInstructionImpl implements ExecuteInstruction {

    private static Position position = null;

    private static ExecuteInstructionImpl instance = null;

    protected ExecuteInstructionImpl() {
        // Exists only to defeat instantiation.
    }

    /**
     * Used to return a singleton instance of the class
     *
     * @return ExecuteInstructionImpl
     */
    public static ExecuteInstructionImpl getInstance() {
        if (instance == null) {
            instance = new ExecuteInstructionImpl();
        }
        return instance;
    }

    @Override
    public void setInitialPosition(Position initPosition) throws OutOfGridException {
        isValidXYPosition(initPosition);

        position = initPosition;
    }

    @Override
    public void changeDirection(String leftOrRight) throws InitialPositionNotSetException {
        if (position == null) {
            throw new InitialPositionNotSetException();
        } else {
            final Direction dir = getDirectionBasedOnTurning(leftOrRight);
            position.setDirection((dir == null) ? position.getDirection() : dir);
        }
    }

    @Override
    public void move() throws OutOfGridException, InitialPositionNotSetException {
        if (position == null) {
            throw new InitialPositionNotSetException();
        }
        switch (position.getDirection()) {
            case NORTH:
                if (position.getyPosition() == CONSTANTS.MAX_GRID.Y) {
                    throw new OutOfGridException();
                }
                position.moveY(1);
                break;
            case SOUTH:
                if (position.getyPosition() == CONSTANTS.MIN_GRID.Y) {
                    throw new OutOfGridException();
                }
                position.moveY(-1);
                break;
            case EAST:
                if (position.getxPosition() == CONSTANTS.MAX_GRID.X - 1) {
                    throw new OutOfGridException();
                }
                position.moveX(1);
                break;
            case WEST:
                if (position.getxPosition() == CONSTANTS.MIN_GRID.X) {
                    throw new OutOfGridException();
                }
                position.moveX(-1);
                break;
        }

    }

    @Override
    public String getPosition() {
        if (position == null) {
            return "Initial position not set.";
        } else {
            return position.toString();
        }
    }

    private static Direction getDirectionBasedOnTurning(String leftOrRight) {
        Direction direction = null;
        switch (leftOrRight) {
            case CONSTANTS.TURN.LEFT:
                switch (position.getDirection()) {
                    case NORTH:
                        direction = Direction.WEST;
                        break;
                    case SOUTH:
                        direction = Direction.EAST;
                        break;
                    case WEST:
                        direction = Direction.SOUTH;
                        break;
                    case EAST:
                        direction = Direction.NORTH;
                        break;
                }
                break;
            case CONSTANTS.TURN.RIGHT:
                switch (position.getDirection()) {
                    case NORTH:
                        direction = Direction.EAST;
                        break;
                    case SOUTH:
                        direction = Direction.WEST;
                        break;
                    case WEST:
                        direction = Direction.NORTH;
                        break;
                    case EAST:
                        direction = Direction.SOUTH;
                        break;
                }
                break;
        }
        return direction;
    }

    private static void isValidXYPosition(Position initPosition) throws OutOfGridException {
        if (initPosition == null) {
            throw new OutOfGridException();
        } else {
            final int xPosition = initPosition.getxPosition();
            final int yPosition = initPosition.getyPosition();
            // validate X position
            if (xPosition < CONSTANTS.MIN_GRID.X || xPosition > CONSTANTS.MAX_GRID.X - 1
                    || yPosition < CONSTANTS.MIN_GRID.Y || yPosition > CONSTANTS.MAX_GRID.Y - 1) {
                throw new OutOfGridException();
            }
        }
    }

    public static void setPosition(Position pos) {
        position = pos;
    }

}
