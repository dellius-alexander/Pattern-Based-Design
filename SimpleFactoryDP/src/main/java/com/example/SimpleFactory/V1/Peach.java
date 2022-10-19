package com.example.SimpleFactory.V1;

import com.example.SimpleFactory.IFruit.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Peach implements Fruit<Object> {
    private static final Logger log = LoggerFactory.getLogger(Peach.class);
    static final long serialVersionUID = -20L;
    private final Fruit.Data<Object> data;
    private Peach(){
        data = new Data<>("Peach", "3.99", Fruit.Type.SIMPLE);
    }
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
        return data;
    }
}
