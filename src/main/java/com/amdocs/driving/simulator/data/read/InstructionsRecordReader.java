/**
 *
 */
package com.amdocs.driving.simulator.data.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.amdocs.driving.simulator.data.InstructionRecordDataAccess;
import com.amdocs.driving.simulator.data.RecordDataAccess;
import com.amdocs.driving.simulator.validator.InstructionValidator;
import com.amdocs.driving.simulator.validator.exception.InvalidInstructionException;

/**
 * @author bmaturi
 */
public class InstructionsRecordReader implements RecordReader {

    /*
     * (non-Javadoc)
     * @see com.amdocs.driving.simulator.data.read.RecordReader#read(java.io.File)
     */
    @Override
    public RecordDataAccess read(File file) throws IOException {
        validateFile(file);
        final RecordDataAccess dataAccess = new InstructionRecordDataAccess();

        // Read the file using BufferedReader,FileReader
        // to handle large files also
        try (FileReader fileReader = new FileReader(file); BufferedReader br = new BufferedReader(fileReader);) {

            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                } else {
                    line = line.toUpperCase().trim();
                    try {
                        InstructionValidator.isVaidInstruction(line);
                        dataAccess.addInstruction(line);
                    } catch (final InvalidInstructionException e) {
                        System.err.println("Ignoring invalid instruction : " + line);
                    }
                }
            }
        } catch (final IOException e) {
            throw e;
        }
        return dataAccess;
    }

    private void validateFile(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new FileNotFoundException();
        }
    }

}
