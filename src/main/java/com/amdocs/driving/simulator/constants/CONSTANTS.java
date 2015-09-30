/**
 *
 */
package com.amdocs.driving.simulator.constants;

/**
 * @author bmaturi
 */
public class CONSTANTS {

    // FIXME : can be picked up from a config
    // Set the Grid variables here
    // size on x and y axis
    private static final int GRID_SIZE_X = 5;
    private static final int GRID_SIZE_Y = 5;

    /**
     * TODO :
     */
    public static final class MAX_GRID {

        public static final int X = GRID_SIZE_X - 1;

        public static final int Y = GRID_SIZE_Y - 1;

    }

    /**
     * TODO :
     */
    public static final class MIN_GRID {

        public static final int X = 0;

        public static final int Y = 0;

    }

    /**
     * @author adminuser
     */
    public static final class TURN {

        public static final String LEFT = "TURN_LEFT";

        public static final String RIGHT = "TURN_RIGHT";

    }

}
