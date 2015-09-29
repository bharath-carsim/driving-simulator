/**
 *
 */
package com.amdocs.driving.simulator.execute;

import com.amdocs.driving.simulator.constants.CONSTANTS;
import com.amdocs.driving.simulator.data.Direction;
import com.amdocs.driving.simulator.execute.exception.OutOfGridException;

/**
 * @author bmaturi
 */
public class ExecuteInstruction {

    private static final Position position = new Position();

    /**
     * @param X
     * @param Y
     * @param initialdirection
     */
    public static void setInitialPosition(int xPosition, int yPosition, Direction initialdirection) {
        position.setxPosition(xPosition);
        position.setyPosition(yPosition);
        position.setDirection(initialdirection);
    }

    /**
     * @param changeDirection
     */
    public static void changeDirection(String leftOrRight) {

        switch (leftOrRight) {
            case CONSTANTS.TURN.LEFT:
                switch (position.getDirection()) {
                    case NORTH:
                        position.setDirection(Direction.WEST);
                        break;
                    case SOUTH:
                        position.setDirection(Direction.EAST);
                        break;
                    case WEST:
                        position.setDirection(Direction.SOUTH);
                        break;
                    case EAST:
                        position.setDirection(Direction.NORTH);
                        break;
                }
                break;
            case CONSTANTS.TURN.RIGHT:
                switch (position.getDirection()) {
                    case NORTH:
                        position.setDirection(Direction.EAST);
                        break;
                    case SOUTH:
                        position.setDirection(Direction.WEST);
                        break;
                    case WEST:
                        position.setDirection(Direction.NORTH);
                        break;
                    case EAST:
                        position.setDirection(Direction.SOUTH);
                        break;
                }
                break;
        }
    }

    /**
     * @throws OutOfGridException
     */
    public static void move() throws OutOfGridException {
        switch (position.getDirection()) {
            case NORTH:
            case SOUTH:
                if (position.getyPosition() == (CONSTANTS.MAX_GRID.Y - 1)) {
                    throw new OutOfGridException();
                } else {
                    position.moveY();
                }
                break;
            case WEST:
            case EAST:
                if (position.getxPosition() == (CONSTANTS.MAX_GRID.X - 1)) {
                    throw new OutOfGridException();
                } else {
                    position.moveX();
                }
                break;
        }
    }

    /**
     * @return the current position
     */
    public static String getPosition() {
        return position.toString();
    }
}
