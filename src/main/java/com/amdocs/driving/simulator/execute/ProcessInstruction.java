/**
 *
 */
package com.amdocs.driving.simulator.execute;

import com.amdocs.driving.simulator.data.Direction;
import com.amdocs.driving.simulator.execute.exception.InitialPositionNotSetException;
import com.amdocs.driving.simulator.execute.exception.OutOfGridException;

/**
 * @author bmaturi
 */
public class ProcessInstruction {

    private ExecuteInstructionImpl executeService = null;

    /**
     *
     */
    public ProcessInstruction() {
        executeService = ExecuteInstructionImpl.getInstance();
    }

    /**
     * Processes the given instruction by passing the responsibility to ExecuteInstruction Currently
     * expected instructions : INIT <X>,<Y>,<F> FORWARD TURN_LEFT TURN_RIGHT GPS_REPORT
     *
     * @param instruction
     */
    public void process(String instruction) {

        try {
            if (instruction.startsWith("INIT")) {
                executeService.setInitialPosition(parseInitCommand(instruction));
            } else if (instruction.equals("FORWARD")) {
                executeService.move();
            } else if (instruction.startsWith("TURN")) {
                executeService.changeDirection(instruction);
            } else if (instruction.equals("GPS_REPORT")) {
                System.out.println(executeService.getPosition());
            }
        } catch (final OutOfGridException e) {
            System.err.println("Ignoring instruction " + instruction
                    + " since vehicle going out of grid. current position : " + executeService.getPosition());
        } catch (final InitialPositionNotSetException e) {
            System.err.println("Ignoring instruction since initial position is not set.");
        }
    }

    // At this stage the INIT instruction is already expected to be validated for the format
    private Position parseInitCommand(String instruction) {
        final String[] params = instruction.substring(5).split(",");
        final Position position = new Position();
        position.setxPosition(Integer.valueOf(params[0]));
        position.setyPosition(Integer.valueOf(params[1]));
        position.setDirection(Direction.fromValue(params[2]));

        return position;
    }

}
