/**
 *
 */
package com.amdocs.driving.simulator.data.read;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.amdocs.driving.simulator.data.RecordDataAccess;
import com.amdocs.driving.simulator.data.exception.EndOfInstructionsException;

/**
 * @author bmaturi
 */
public class InstructionsRecordReaderTest {

    @Test(expected = FileNotFoundException.class)
    public void testReadNull() throws IOException {
        new InstructionsRecordReader().read(null);
    }

    @Test
    public void read() throws IOException, EndOfInstructionsException {
        final RecordDataAccess dataAccess = new InstructionsRecordReader().read(new File(getClass().getResource(
                "/instructions.txt").getFile()));
        assertNotNull(dataAccess);
        assertEquals(30, dataAccess.getNumberOfRecords());
        assertEquals("INIT <X>,<Y>,<F>", dataAccess.getNextInstruction());
        assertEquals("FORWARD", dataAccess.getNextInstruction());
    }
}
