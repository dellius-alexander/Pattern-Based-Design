package com.example.AbstractFactory.V3;

import com.example.AbstractFactory.Factory.*;
import com.example.AbstractFactory.IFruit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
    private static final Logger log = LoggerFactory.getLogger(Client.class);
    /**
     * Driver
     * @param args CLi arguments
     */
    public static void main(String[] args) {
        // container for fruits
        try {
            Fruit<?> goldenApple = (new GoldenAppleFactory()).factoryMethod();
            goldenApple.grow();
            log.info("{}", goldenApple.getData());
            Fruit<?> fujiApple = (new FujiAppleFactory()).factoryMethod();
            fujiApple.grow();
            log.info("{}", fujiApple.getData());
            Fruit<?> peach = (new PeachFactory()).factoryMethod();
            peach.grow();
            log.info("{}", peach.getData());

        } catch (Exception e){
            log.error(e.getLocalizedMessage());
            // do nothing on null exception
        }
    }
}
