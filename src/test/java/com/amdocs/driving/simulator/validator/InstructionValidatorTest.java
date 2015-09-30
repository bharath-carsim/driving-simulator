/**
 *
 */
package com.amdocs.driving.simulator.validator;

import org.junit.Test;

import com.amdocs.driving.simulator.validator.exception.InvalidInstructionException;

/**
 * @author bmaturi
 */
public class InstructionValidatorTest {

    /**
     * This test case is not expected to throw any exception, so no asserts
     *
     * @throws InvalidInstructionException
     */
    @Test
    public void testValidateInstruction() throws InvalidInstructionException {

        InstructionValidator.isVaidInstruction("FORWARD");

        InstructionValidator.isVaidInstruction("GPS_REPORT");

        InstructionValidator.isVaidInstruction("TURN_LEFT");

        InstructionValidator.isVaidInstruction("TURN_RIGHT");

        InstructionValidator.isVaidInstruction("INIT 0,0,NORTH");

        InstructionValidator.isVaidInstruction("INIT 0,0,EAST");

        InstructionValidator.isVaidInstruction("INIT 0,0,WEST");

        InstructionValidator.isVaidInstruction("INIT 0,0,SOUTH");
    }

    @Test(expected = InvalidInstructionException.class)
    public void testValidateInstructionInvalid() throws InvalidInstructionException {
        InstructionValidator.isVaidInstruction("DUMMY");
    }

}
