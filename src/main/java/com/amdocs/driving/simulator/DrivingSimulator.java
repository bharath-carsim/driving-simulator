/**
 *
 */
package com.amdocs.driving.simulator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.amdocs.driving.simulator.data.RecordDataAccess;
import com.amdocs.driving.simulator.data.exception.EndOfInstructionsException;
import com.amdocs.driving.simulator.data.read.InstructionsRecordReader;
import com.amdocs.driving.simulator.execute.ProcessInstruction;
import com.amdocs.driving.simulator.validator.InstructionValidator;
import com.amdocs.driving.simulator.validator.exception.InvalidInstructionException;

/**
 * @author Bharath Maturi
 */
public class DrivingSimulator {

    private static final ProcessInstruction processor = new ProcessInstruction();

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            final String message = "For running the program from a file - Usage : DrivingSimulator <file_path>";
            System.out.println(message);
            System.out.println("Waiting for input from console. Press y to exit");

            // Taking from console
            final Scanner scanner = new Scanner(System.in);
            String instruction;
            while (!"y".equalsIgnoreCase(instruction = scanner.nextLine())) {
                if (isNotEmpty(instruction)) {
                    playInstruction(instruction);
                }
            }
            scanner.close();
        } else if (args.length == 1) {
            final File dataFile = new File(args[0]);
            // "/home/adminuser/bmaturi/code/coding-challenge/driving-simulator/src/test/resources/instructions.txt");
            if (!dataFile.exists()) {
                final String message = "File does not exist. Please provide a valid input data file.";
                throw new IllegalArgumentException(message);
            } else {

                final RecordDataAccess dataAccess = new InstructionsRecordReader().read(dataFile);
                while (true) {
                    try {
                        processor.process(dataAccess.getNextInstruction());
                    } catch (final EndOfInstructionsException e) {
                        System.out.println("End of instructions");
                        break;
                    }
                }
            }
        } else {
            System.err.println("Invalid arguments. Try running without any arguments to input from command line ");
            System.err.println("Or to run the program from a file - Usage : DrivingSimulator <file_path>");
        }
    }

    private static void playInstruction(String instruction) {
        try {
            instruction = instruction.toUpperCase().trim();
            InstructionValidator.isVaidInstruction(instruction);
        } catch (final InvalidInstructionException e) {
            System.err.println("Ignoring invalid instruction : " + instruction);
        }
        processor.process(instruction);
    }

    private static boolean isNotEmpty(String instruction) {
        if (instruction != null && instruction.length() > 0) {
            return true;
        }
        return false;
    }
}
