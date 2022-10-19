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
            if (args.length == 0) {
                Fruit<?> goldenApple = FruitFactory.factoryMethod("golden");
                assert goldenApple != null;
                goldenApple.grow();
                log.info("\n{}", goldenApple.getData());
                Fruit<?> fujiApple = FruitFactory.factoryMethod("fuji");
                assert fujiApple != null;
                fujiApple.grow();
                log.info("\n{}", fujiApple.getData());
                Fruit<?> peach = FruitFactory.factoryMethod("peach");
                assert peach != null;
                peach.grow();
                log.info("\n{}", peach.getData());
            }
            else {
                List<Fruit<?>> fruits = FruitFactory.factoryMethod(args);
                fruits.forEach( fruit -> {
                    fruit.grow();
                    log.info("\n{}", fruit.getData());
                        }

                );
//                for (String arg : args)
//                {
//                    Fruit<?> fruit = FruitFactory.factoryMethod(arg);
//                    if (fruit == null) continue;
//                    fruit.grow();
//                    System.out.printf("%s", fruit.getData().getData());
//                }
            }
        } catch (Exception e){
            log.error(e.getLocalizedMessage());
            // do nothing on null exception
        }
    }
}
