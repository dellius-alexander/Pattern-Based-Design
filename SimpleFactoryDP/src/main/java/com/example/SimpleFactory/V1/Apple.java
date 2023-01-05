package com.example.SimpleFactory.V1;

import com.example.SimpleFactory.IFruit.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Apple implements Fruit<Object> {
    private static final Logger log = LoggerFactory.getLogger(Apple.class);

    static final long serialVersionUID = -16L;
    private final Fruit.Data<Object> data;
    private Apple(){
        data = new Data<>("Apple", 3.99, Fruit.Type.SIMPLE);
    }

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
    public Fruit.Data<Object> getData() {
        return data;
    }
}
