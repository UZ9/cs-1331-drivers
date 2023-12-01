package com.cs1331.drivers.javafx;

import javafx.scene.Node;
import javafx.scene.layout.Pane;



public class RecursiveSearch {
    @SuppressWarnings("unchecked")
    public static <T extends Node> T recursiveSearch(Filter<T> filter, Class<T> type, Pane current) {
        for (int i = 0; i < current.getChildren().size(); i++) {
            Node node = current.getChildren().get(i);

            if (type.isAssignableFrom(node.getClass())) {
                T castVar = (T) node;

                if (filter.matches(castVar)) {
                    return castVar;
                }
            } else if (node instanceof Pane) {
                T res = recursiveSearch(filter, type, (Pane) node);
                if (res != null) return res;
            }
        }

        return null;
    }
}

