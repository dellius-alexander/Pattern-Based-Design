package com.example.SimpleFactory.IFruit;

/**
 * Base Case Fruit implementation.
 * @param <Data> fruit data of type Object
 */
public interface Fruit<Data> {
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
