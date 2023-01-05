package com.example.AbstractFactory.Factory;

import java.io.Serializable;

/**
 * Factory method pattern
 */
public interface AbstractFactory<object> extends Serializable {
    static final long serialVersionUID = -16L; // 0001-0000
    /**
     * Creates a type of fruit
     * @return a type of fruit
     */
    object factoryMethod();
}
