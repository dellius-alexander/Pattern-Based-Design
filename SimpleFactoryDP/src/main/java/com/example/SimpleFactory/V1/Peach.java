package com.example.SimpleFactory.V1;

import com.example.SimpleFactory.IFruit.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Peach implements Fruit<Object> {
    private static final Logger log = LoggerFactory.getLogger(Peach.class);

    static final long serialVersionUID = -20L;

    private String taste;

    /**
     * Grows your fruit
     */
    @Override
    public void grow(){
        log.info("\nPeach is growing...");
    }
    /**
     * Get the fruit data.
     * @return the fruit data
     */
    @Override
    public Fruit.Data<Object> getData() {
        return new Fruit.Data<>("Peach", "1.99", Type.SIMPLE);
    }
}
