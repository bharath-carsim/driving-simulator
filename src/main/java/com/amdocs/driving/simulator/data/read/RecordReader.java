/**
 *
 */
package com.amdocs.driving.simulator.data.read;

import java.io.File;
import java.io.IOException;

import com.amdocs.driving.simulator.data.RecordDataAccess;

/**
 * @author bmaturi
 */
public interface RecordReader {

    public RecordDataAccess read(File file) throws IOException;

}
