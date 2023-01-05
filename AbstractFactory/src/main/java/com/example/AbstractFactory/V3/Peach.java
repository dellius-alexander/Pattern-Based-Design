package com.example.AbstractFactory.V3;

import com.example.AbstractFactory.IFruit.*;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class Peach implements Fruit<Object> {
    static final long serialVersionUID = -35L; // 0010-0011
    private static final Logger log = LoggerFactory.getLogger(Peach.class);
    private final Data<Object> data;
    public Peach(){
        data = new Data<>("Peach", 2.99, Type.SIMPLE);
        log.info("{}", this);
    }
    @Override
    public void grow(){
        log.info("\nPeach is growing...");
    }

    /**
     * Get the fruit data.
     * @return the fruit data
     */
    @Override
    public Data<Object> getData() {
        return data;
    }
}
