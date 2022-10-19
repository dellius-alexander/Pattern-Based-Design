package com.example.SimpleFactory.V2;

import com.example.SimpleFactory.IFruit.Apple;
import com.example.SimpleFactory.IFruit.Fruit;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class FujiApple implements Apple<Object> {
    private static final Logger log = LoggerFactory.getLogger(FujiApple.class);
    static final long serialVersionUID = -9L;
    private final Fruit.Data<Object> data;
    public FujiApple(){
        data = new Data<>(type(), "6.99", Fruit.Type.SIMPLE);
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
    public Fruit.Data<Object> getData() {
        return data;
    }
}
