package com.example.SimpleFactory.IFruit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

interface __Types {
    void setType(String type);
    Types getType();

}

public enum Types{
    SLIDINGDOOR("slidingdoor");

    ;
    private final String label;
    // static inference
    private static final Map<String, Types> BY_LABEL = new HashMap<>();
    /**
     * Create new TYPE with label = label
     * @param label the type label
     */
    Types(String label) {
        this.label = label;
    }
    /*
     * static inference collection of TYPES
     */
    static {
        for (Types e : values())
        {
            BY_LABEL.put(e.label, e);
        }
    }

}
