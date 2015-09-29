/**
 *
 */
package com.amdocs.driving.simulator.data;

import com.amdocs.driving.simulator.data.exception.EndOfInstructionsException;

/**
 * @author bmaturi
 */
public interface RecordDataAccess {

    public void addInstruction(String instruction);

    public String getNextInstruction() throws EndOfInstructionsException;

    public int getNumberOfRecords();

}
