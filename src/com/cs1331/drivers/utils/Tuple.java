package com.cs1331.drivers.utils;
/**
 * A generic class used for holding two values that might be related
 */
public class Tuple<X, Y> {
    /**
     * The first element
     */
    public final X first;

    /**
     * The second element
     */
    public final Y second;

    /**
     * Constructs a new Tuple.
     * @param first The first element
     * @param second The second element
     */
    public Tuple(X first, Y second) {
        this.first = first;
        this.second = second;
    }
}