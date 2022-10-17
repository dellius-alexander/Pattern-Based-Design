package com.example.SimpleFactory.IFruit;

import java.io.Serializable;

/**
 * Base Case Fruit implementation.
 * @param <Data> fruit data of type Object
 */
public interface Fruit<Data> extends Serializable {
    long serialVersionUID = -1L;

    /**
     * Grows your fruit
     */
    void grow();

    /**
     * Get the fruit data. This can be represented
     * according to implementation. <br>
     * Note: Update documentation
     * according to implementation.
     * @return the fruit data
     */
    Data getData();
}
