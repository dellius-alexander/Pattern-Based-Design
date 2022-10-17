package com.example.SimpleFactory.V2;

import com.example.SimpleFactory.IFruit.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Client {
    private static final Logger log = LoggerFactory.getLogger(Client.class);

    /**
     * Driver
     * @param args CLi arguments
     */
    public static void main(String[] args) {
        // container for fruits
        List<Fruit<?>> fruits;
        try {
            assert args == null;
            args = new String[]{
                    "Golden Apple",
                    "Mango",
                    "Peach",
                    "Fuji Apple",
                    "Orange"
            };
            log.info("\n{}\n", (Object) args);
            // request fruit classes from FruitFactory
            fruits = FruitFactory.factoryMethod(args);
            // grow each fruit or skip on null
            for(Fruit<?> fruit : fruits)
            {
                fruit.grow();
                log.info("\n{}\n", fruit.getData());
            }
        } catch (Exception e){
            // do nothing on null exception
        }
    }
}
