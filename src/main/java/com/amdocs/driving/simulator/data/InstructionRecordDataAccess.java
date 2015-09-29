/**
 *
 */
package com.amdocs.driving.simulator.data;

import java.util.LinkedList;
import java.util.Queue;

import com.amdocs.driving.simulator.data.exception.EndOfInstructionsException;

/**
 * @author bmaturi
 */
public class InstructionRecordDataAccess implements RecordDataAccess {

    Queue<String> instructionList = new LinkedList<String>();

    @Override
    public void addInstruction(String instruction) {
        instructionList.add(instruction);

    }

    @Override
    public String getNextInstruction() throws EndOfInstructionsException {
        if (!instructionList.isEmpty()) {
            return instructionList.remove();
        } else {
            throw new EndOfInstructionsException();
        }
    }

    @Override
    public int getNumberOfRecords() {
        return instructionList.size();
    }

}
