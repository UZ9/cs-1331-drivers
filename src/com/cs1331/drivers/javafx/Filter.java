package com.cs1331.drivers.javafx;

public interface Filter<T> {
    boolean matches(T input);
}
