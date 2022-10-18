package com.example.SimpleFactory;

import com.example.SimpleFactory.IFruit.Fruit;
import com.example.SimpleFactory.V2.FruitFactory;
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
        try {
            assert args == null;
            Fruit<?> goldenApple = FruitFactory.factoryMethod("golden");
            assert goldenApple != null;
            goldenApple.grow();
            System.out.printf("%s", goldenApple.getData());
            Fruit<?> fujiApple = FruitFactory.factoryMethod("fuji");
            assert fujiApple != null;
            fujiApple.grow();
            System.out.printf("%s", fujiApple.getData());
            Fruit<?> peach = FruitFactory.factoryMethod("peach");
            assert peach != null;
            peach.grow();
            System.out.printf("%s", peach.getData());

        } catch (Exception e){
            log.error(e.getLocalizedMessage());
            // do nothing on null exception
        }
    }
}
