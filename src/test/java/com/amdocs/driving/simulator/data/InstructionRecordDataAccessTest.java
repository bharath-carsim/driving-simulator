/**
 *
 */
package com.amdocs.driving.simulator.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.amdocs.driving.simulator.data.exception.EndOfInstructionsException;

/**
 * @author bmaturi
 */
public class InstructionRecordDataAccessTest {

    @Test
    public void testAddInstruction() throws EndOfInstructionsException {
        final InstructionRecordDataAccess dataAccess = new InstructionRecordDataAccess();
        dataAccess.addInstruction("INST1");
        dataAccess.addInstruction("INST2");

        assertEquals(2, dataAccess.getNumberOfRecords());
        assertEquals("INST1", dataAccess.getNextInstruction());
        assertEquals("INST2", dataAccess.getNextInstruction());
        assertEquals(0, dataAccess.getNumberOfRecords());

    }

    @Test(expected = EndOfInstructionsException.class)
    public void testEndOfInstructions() throws EndOfInstructionsException {

        final InstructionRecordDataAccess dataAccess = new InstructionRecordDataAccess();
        dataAccess.addInstruction("INST1");

        assertEquals(1, dataAccess.getNumberOfRecords());
        assertEquals("INST1", dataAccess.getNextInstruction());
        assertEquals(0, dataAccess.getNumberOfRecords());
        // This should throw the exception
        dataAccess.getNextInstruction();

    }
}
