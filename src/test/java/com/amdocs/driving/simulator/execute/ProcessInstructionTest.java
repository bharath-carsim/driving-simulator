/**
 *
 */
package com.amdocs.driving.simulator.execute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author bmaturi
 */
public class ProcessInstructionTest {

    ProcessInstruction processInst = new ProcessInstruction();

    @Test
    public void testProcess() {

        final ExecuteInstructionImpl executeInst = ExecuteInstructionImpl.getInstance();
        processInst.process("FORWARD");
        processInst.process("INIT 0,0,NORTH");
        assertEquals("0,0,NORTH", executeInst.getPosition());

        processInst.process("FORWARD");
        assertEquals("0,1,NORTH", executeInst.getPosition());

        processInst.process("TURN_LEFT");
        assertEquals("0,1,WEST", executeInst.getPosition());

        processInst.process("TURN_RIGHT");
        assertEquals("0,1,NORTH", executeInst.getPosition());

        processInst.process("GPS_REPORT");
        assertEquals("0,1,NORTH", executeInst.getPosition());

        processInst.process("FORWARD");
        processInst.process("FORWARD");
        processInst.process("FORWARD");
        processInst.process("FORWARD");
        assertEquals("0,4,NORTH", executeInst.getPosition());
    }

}
