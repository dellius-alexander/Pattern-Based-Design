package com.example.AbstractFactory.V3;

import com.example.AbstractFactory.IFruit.*;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class FujiApple implements Apple<Object> {
    static final long serialVersionUID = -33L; // 0010-0001
    private static final Logger log = LoggerFactory.getLogger(FujiApple.class);
    private final Data<Object> data;
    public FujiApple(){
        data = new Data<>(type(), 6.99, Type.SIMPLE);
        log.info("{}", this);
    }
    /**
     * The type of apple: Fuji. <br>
     * @return the type of apple
     */
    @Override
    public String type() {
        return "Fuji Apple";
    }
    /**
     * Grows your fruit
     */
    @Override
    public void grow() {
        log.info("\n{} is growing...", type());
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
