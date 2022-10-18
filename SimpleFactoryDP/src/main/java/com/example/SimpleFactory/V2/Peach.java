package com.example.SimpleFactory.V2;

import com.example.SimpleFactory.IFruit.Fruit;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class Peach implements Fruit<Object> {
    private static final Logger log = LoggerFactory.getLogger(Peach.class);
    static final long serialVersionUID = -13L;
    private String taste;
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
        return new Fruit.Data<>("Peach", "2.99", Fruit.Type.SIMPLE);

    }
}
