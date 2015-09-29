/**
 *
 */
package com.amdocs.driving.simulator.data;


/**
 * @author bmaturi
 */
public enum Direction {

    NORTH("NORTH"), EAST("EAST"), WEST("WEST"), SOUTH("SOUTH");

    private final String value;

    Direction(String value) {
        this.value = value;
    }

    public static Direction fromValue(String value) {
        return valueOf(value.toUpperCase());
    }

    @Override
    public String toString() {
        return this.value;
    }

}
