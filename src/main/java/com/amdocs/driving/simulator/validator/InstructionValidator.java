/**
 *
 */
package com.amdocs.driving.simulator.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.amdocs.driving.simulator.validator.exception.InvalidInstructionException;

/**
 * @author bmaturi
 */
public class InstructionValidator {

    private static final List<Pattern> INSTRUCTIONPATTERNLIST = new ArrayList<Pattern>();

    // FIXME : Could be picked up from a config file
    static {
        INSTRUCTIONPATTERNLIST.add(Pattern.compile("FORWARD"));
        INSTRUCTIONPATTERNLIST.add((Pattern.compile("GPS_REPORT")));
        INSTRUCTIONPATTERNLIST.add((Pattern.compile("TURN_(LEFT|RIGHT)")));
        INSTRUCTIONPATTERNLIST.add((Pattern.compile("INIT [0-9],[0-9],(NORTH|EAST|WEST|SOUTH)")));
    }

    public static void isVaidInstruction(String instruction) throws InvalidInstructionException {
        boolean isValid = false;
        for (final Pattern pattern : INSTRUCTIONPATTERNLIST) {
            if (pattern.matcher(instruction).matches()) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            throw new InvalidInstructionException();
        }
    }
}
