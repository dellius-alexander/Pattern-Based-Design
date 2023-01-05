package com.example.AbstractFactory.V3;

import com.example.AbstractFactory.IFruit.*;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class GoldenApple implements Apple<Object> {
    static final long serialVersionUID = -34L; // 0010-0010
    private static final Logger log = LoggerFactory.getLogger(GoldenApple.class);
    private final Data<Object> data;
    public GoldenApple(){
        data = new Data<>(type(), 5.99, Type.SIMPLE);
        log.info("{}", this);
    }
    /**
     * The type of apple: Golden Delicious. <br>
     * @return the type of apple
     */
    @Override
    public String type() {
        return "Golden Apple";
    }
    /**
     * Grows your fruit
     */
    @Override
    public void grow(){
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
