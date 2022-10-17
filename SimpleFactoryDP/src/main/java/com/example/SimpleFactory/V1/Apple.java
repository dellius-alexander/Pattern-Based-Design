package com.example.SimpleFactory.V1;

import com.example.SimpleFactory.IFruit.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Apple implements Fruit<Object> {
    private static final Logger log = LoggerFactory.getLogger(Apple.class);

    static final long serialVersionUID = -16L;

    private int treeAge;
    private String taste;

    /**
     * Grows your fruit
     */
    @Override
    public void grow() {
        log.info("\nApple is growing...");
    }

    /**
     * Get the fruit data.
     * @return the fruit data
     */
    @Override
    public String getData() {
        return "\nData{\n" +
                "\t\"Fruit_Name\":\"Apple\"" +
                "\n}\n";
    }
}
