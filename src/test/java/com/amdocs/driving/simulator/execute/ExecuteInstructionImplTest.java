/**
 *
 */
package com.amdocs.driving.simulator.execute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.amdocs.driving.simulator.constants.CONSTANTS;
import com.amdocs.driving.simulator.data.Direction;
import com.amdocs.driving.simulator.execute.exception.InitialPositionNotSetException;
import com.amdocs.driving.simulator.execute.exception.OutOfGridException;

/**
 * @author bmaturi
 */
public class ExecuteInstructionImplTest {

    @Test
    public void testSetInitialPosition() throws OutOfGridException {
        final ExecuteInstructionImpl executeInst = ExecuteInstructionImpl.getInstance();

        final Position position = new Position();
        position.setDirection(Direction.NORTH);
        position.setxPosition(1);
        position.setyPosition(1);

        executeInst.setInitialPosition(position);

        assertNotNull(executeInst);
        assertEquals("1,1,NORTH", executeInst.getPosition());
    }

    @Test(expected = OutOfGridException.class)
    public void testSetInitialPositionException() throws OutOfGridException {
        final ExecuteInstructionImpl executeInst = ExecuteInstructionImpl.getInstance();

        final Position position = new Position();
        position.setDirection(Direction.NORTH);
        position.setxPosition(5);
        position.setyPosition(1);

        executeInst.setInitialPosition(position);

    }

    @Test(expected = OutOfGridException.class)
    public void testSetInitialPositionInitException() throws OutOfGridException {
        final ExecuteInstructionImpl executeInst = ExecuteInstructionImpl.getInstance();
        ExecuteInstructionImpl.setPosition(null);
        executeInst.setInitialPosition(null);

    }

    @Test
    public void testgetPositionInitException() throws OutOfGridException {
        final ExecuteInstructionImpl executeInst = ExecuteInstructionImpl.getInstance();
        ExecuteInstructionImpl.setPosition(null);
        assertEquals("Initial position not set.", executeInst.getPosition());

    }

    @Test
    public void testSetInitialPositionIgnoring() {
        final ExecuteInstructionImpl executeInst = ExecuteInstructionImpl.getInstance();

        Position position = new Position();
        position.setDirection(Direction.NORTH);
        position.setxPosition(1);
        position.setyPosition(1);

        try {
            executeInst.setInitialPosition(position);
        } catch (final OutOfGridException e) {
            // ignore for this test
        }

        position = new Position();
        position.setDirection(Direction.NORTH);
        position.setxPosition(-1);
        position.setyPosition(1);

        try {
            executeInst.setInitialPosition(position);
        } catch (final OutOfGridException e) {
            // ignore for this test
        }

        // check if the original position is still set
        assertEquals("1,1,NORTH", executeInst.getPosition());
    }

    @Test
    public void testChangeDirection() throws OutOfGridException, InitialPositionNotSetException {
        final ExecuteInstructionImpl executeInst = ExecuteInstructionImpl.getInstance();

        final Position position = new Position();
        position.setDirection(Direction.NORTH);
        position.setxPosition(1);
        position.setyPosition(1);

        executeInst.setInitialPosition(position);

        executeInst.changeDirection(CONSTANTS.TURN.LEFT);
        assertEquals("1,1,WEST", executeInst.getPosition());

        executeInst.changeDirection(CONSTANTS.TURN.LEFT);
        assertEquals("1,1,SOUTH", executeInst.getPosition());

        executeInst.changeDirection(CONSTANTS.TURN.LEFT);
        assertEquals("1,1,EAST", executeInst.getPosition());

        executeInst.changeDirection(CONSTANTS.TURN.LEFT);
        assertEquals("1,1,NORTH", executeInst.getPosition());

        executeInst.changeDirection(CONSTANTS.TURN.RIGHT);
        assertEquals("1,1,EAST", executeInst.getPosition());

        executeInst.changeDirection(CONSTANTS.TURN.RIGHT);
        assertEquals("1,1,SOUTH", executeInst.getPosition());

        executeInst.changeDirection(CONSTANTS.TURN.RIGHT);
        assertEquals("1,1,WEST", executeInst.getPosition());

        executeInst.changeDirection(CONSTANTS.TURN.RIGHT);
        assertEquals("1,1,NORTH", executeInst.getPosition());

    }

    @Test
    public void testChangeDirectionInvalid() throws OutOfGridException, InitialPositionNotSetException {

        final ExecuteInstructionImpl executeInst = ExecuteInstructionImpl.getInstance();

        final Position position = new Position();
        position.setDirection(Direction.NORTH);
        position.setxPosition(1);
        position.setyPosition(1);

        executeInst.setInitialPosition(position);

        executeInst.changeDirection(CONSTANTS.TURN.LEFT);
        assertEquals("1,1,WEST", executeInst.getPosition());

        executeInst.changeDirection("test");
        assertEquals("1,1,WEST", executeInst.getPosition());

    }

    @Test(expected = InitialPositionNotSetException.class)
    public void testChangeDirectionInitialPositionNotSet() throws InitialPositionNotSetException {
        final ExecuteInstructionImpl executeInst = ExecuteInstructionImpl.getInstance();
        ExecuteInstructionImpl.setPosition(null);
        executeInst.changeDirection(CONSTANTS.TURN.LEFT);
    }

}
