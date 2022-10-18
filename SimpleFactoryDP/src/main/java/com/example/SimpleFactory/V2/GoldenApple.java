package com.example.SimpleFactory.V2;

import com.example.SimpleFactory.IFruit.Apple;
import com.example.SimpleFactory.IFruit.Fruit;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class GoldenApple implements Apple<Object> {
    private static final Logger log = LoggerFactory.getLogger(GoldenApple.class);
    static final long serialVersionUID = -10L;
    private int treeAge;
    private String taste;

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
    public Fruit.Data<Object> getData() {
        return new Data<>(type(), "5.99", Fruit.Type.SIMPLE);

    }
}
